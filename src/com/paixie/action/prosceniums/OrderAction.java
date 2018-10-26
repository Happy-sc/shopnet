package com.paixie.action.prosceniums;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.GetTime;
import com.paixie.common.ProduceId;
import com.paixie.domain.Address;
import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;
import com.paixie.domain.OrderState;
import com.paixie.domain.PaixieBRecord;
import com.paixie.domain.ShoppingCar;
import com.paixie.domain.Users;
import com.paixie.service.AddressService;
import com.paixie.service.OrderDetailService;
import com.paixie.service.OrderService;
import com.paixie.service.OrderStateService;
import com.paixie.service.PaixieBService;
import com.paixie.service.UsersService;

@Controller("orderAction")
public class OrderAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="addressService")private AddressService addressService;
	@Resource(name="orderService")private OrderService orderService;
	@Resource(name="orderDetailService")private OrderDetailService orderDetailService;
	@Resource(name="orderStateService") private OrderStateService orderStateService;
	@Resource(name="usersService")private UsersService usersService;
	@Resource(name="")private PaixieBService paixieBService;
	private Order order;
	private String type;
	private String orderDetailId;
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	/**
	 * ȷ������
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String firmOrder(){
		//��ȡ���û�
		Users user = (Users) session.getAttribute("user");
		//��ȡ�û���Ĭ�ϵ�ַ
		Address dfAddress = null;
		Address address1 = addressService.getUserDefaultAddress(user.getUserId());
		if(address1!=null){
			dfAddress = address1;
		}
		else {    //����û�û������Ĭ�ϵ�ַ
			List<Address> addresses = addressService.getAddressByUser(user.getUserId());
			if(addresses!=null&&addresses.size()!=0)
				dfAddress = addresses.get(0);
		}
		
		//��ȡ���ﳵ
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) session.getAttribute("mapCar");
		//���㹺�ﳵ���ܽ��
		float sum = 0;
		for(Entry<String, ShoppingCar> mycar:mapCar.entrySet()){
			sum = sum + mycar.getValue().getGoodsNumber()*mycar.getValue().getGoodsListing().getGoodsMarketPrice();
		}
		
		//�����˷�
		float freight = 0;
		freight = sum<259?10:0;
		//������Ϣ
		ActionContext.getContext().put("address", dfAddress);
		ActionContext.getContext().put("mapCar", mapCar);
		ActionContext.getContext().put("sum", sum);
		ActionContext.getContext().put("freight", freight);
		ActionContext.getContext().put("type", "firmOrder");
		
		return "firmOrder";
	}
	
	/**
	 * �ύ����
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	public String submitOrder(){
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) request.getSession().getAttribute("mapCar");   //���ﳵ
		Users users = (Users) request.getSession().getAttribute("user");          //�û�
		
		//�½�����
		Order newOrder = new Order();
		//���ö���ֵ
		newOrder.setOrderId(ProduceId.getId());                        //�������
		newOrder.setOrderAddress(order.getOrderAddress());             //�������յ�ַ
		newOrder.setOrderConsignee(order.getOrderConsignee());         //����������
		String orderDate = GetTime.getTime("yyyy-MM-dd HH:mm:ss");
		newOrder.setOrderDate(orderDate);                              //����ʱ��
		newOrder.setOrderFreight(order.getOrderFreight());             //�˷�
		newOrder.setOrderPayment(order.getOrderPayment());             //֧����ʽ
		newOrder.setOrderPhone(order.getOrderPhone());                 //��ϵ�绰
		newOrder.setOrderPostalcode(order.getOrderPostalcode());       //��������
		newOrder.setOrderPrice(order.getOrderPrice());                 //�����ܽ��
		newOrder.setPaixieBNum(order.getPaixieBNum());                 //�û�ʹ����Ь��
		newOrder.setUsers(users);                                      //�û�
		newOrder.setOrderUserRequire(order.getOrderUserRequire());     //�û�Ҫ��
		
		//������״̬
		//���Ϊ��������򶩵�״̬Ϊ:������
		//���Ϊ����֧��������֧����Ϊ�����ֻ�и������ܷ���
		OrderState orderState ;
		if("1".equals(order.getOrderPayment())){
			orderState = orderStateService.getOrderState("500001");
		}
		else {
			orderState = orderStateService.getOrderState("500003");
		}
		
		newOrder.setOrderState(orderState);
		
		//���涩��,
		orderService.saveOrder(newOrder); 
		//���涩����ϸ,ͬʱ�����ݿ���ɾ�����ﳵ�������Щ����
		orderDetailService.saveOrderDetail(mapCar,newOrder);
		
		/*
		 * �����ȡ��Ь�Ҹ�����Ϊ0
		 * �򱣴��û������Ь�Ҽ�¼
		 * ���޸��û���Ь�Ҹ���
		 */
		int paixieBSum = (int) (order.getOrderPrice()/100);
		//�����Ь��
		if(paixieBSum>0){
			PaixieBRecord paixieBRecord = new PaixieBRecord();
			paixieBRecord.setPaixieBId(ProduceId.getId());
			paixieBRecord.setPaixieBNum(paixieBSum);
			paixieBRecord.setPaixieBState(1);
			paixieBRecord.setPaixieBTime(orderDate);
			paixieBRecord.setPaixieBStyle("������Ʒʱ����ȡ��"+paixieBSum+"����Ь��");
			paixieBRecord.setUsers(users);
			paixieBService.savePaixieB(paixieBRecord);
		}
		
		String sypxb = request.getParameter("sypxb");
		int sypxbS = 0;
		if(sypxb!=null&&!"".equals(sypxb)){
			sypxbS = Integer.valueOf(sypxb);
		}
		
		//���ʹ����Ь��
		if(sypxbS>0){
			PaixieBRecord paixieBRecord = new PaixieBRecord();
			paixieBRecord.setPaixieBId(ProduceId.getId());
			paixieBRecord.setPaixieBNum(sypxbS);
			paixieBRecord.setPaixieBState(0);
			paixieBRecord.setPaixieBTime(orderDate);
			paixieBRecord.setPaixieBStyle("������Ʒʱ��ʹ����"+sypxbS+"����Ь��");
			paixieBRecord.setUsers(users);
			paixieBService.savePaixieB(paixieBRecord);
		}
		
		//�޸��û�����Ь�Ҹ���
		int userPaixie = users.getPaixieB()+paixieBSum-sypxbS;
		users.setPaixieB(userPaixie);
		usersService.updateUser(users);
		
		int flag = 0 ;    //��ǩ���ж�֧����ʽ��֧����ʽ��ͬ����ʾ�Ľ��治ͬ
		if("��������".equals(order.getOrderPayment()))
			flag = 0;
		if("����֧��".equals(order.getOrderPayment()))
			flag = 1;
		if("����֧��".equals(order.getOrderPayment()))
			flag = 2;

		//��չ��ﳵ
		session.removeAttribute("mapCar");
		
		ActionContext.getContext().put("flag", flag);
		ActionContext.getContext().put("orderPrice", newOrder.getOrderPrice());
		ActionContext.getContext().put("orderId", newOrder.getOrderId());
		ActionContext.getContext().put("type", "successOrder");
		
	
		return "submitSuccess";
	}
	
	/**
	 * �鿴����
	 * @return
	 */
	public String seeOrder(){
		//�û�
		Users user = (Users) request.getSession().getAttribute("user");
		//����
		int page = super.getPage();
		Map<Order, List<OrderDetail>> AllOrders = new HashMap<Order, List<OrderDetail>>();    //����
		List<OrderDetail> orList = new ArrayList<OrderDetail>();
		int allSum = 0 ;         //��������
		/*
		 * ��ȡ������Ϣ
		 * ����Ǵ��ջ�����Ҫ��orderDetail�л�ȡ����
		 * ��������Ҫʱorder�л�ȡ����
		 */
		if("dsh".equals(type)){
			orList = orderDetailService.getDSHOrderDetail(page,user.getUserId(),0);        //�û����ջ�����
			allSum = orderDetailService.getDSHOrderSum(user.getUserId(),0);
		}
		else {
			 AllOrders = orderService.getOrderByUserState(page,user.getUserId(),type);  //���ж���
			 allSum = orderService.getAllOrderSum(user.getUserId(),type);
		}
		
		pageSum = allSum%5==0?allSum/5:allSum/5+1;        //���ж���
			
		//������Ϣ
		ActionContext.getContext().put("allOrders",AllOrders);
		ActionContext.getContext().put("orlist", orList);
		return "seeOrder";
	}
	

	/**
	 * ȡ������
	 * @return
	 */
	public String cancelOrder(){
		String orderId = request.getParameter("orderId");
		System.out.println(super.getPage());
		System.out.println(type);
		Order order = orderService.getOrder(orderId);
		OrderState orderState = orderStateService.getOrderState("500005");
		
		order.setOrderState(orderState);
		orderService.updateOrder(order);

		return "cancelOrder";
	}
	
	/**
	 * ȷ���ջ�
	 */
	public String qrsh(){
		//�������
		String orderId = request.getParameter("orderId");
		//����������
		
		//��ȡ��������
		OrderDetail orderDetail = orderDetailService.getOrderDetailById(orderDetailId);
		orderDetail.setIsAccept(1);
		orderDetail.setAcceptTime(GetTime.getTime("yyyy-MM-dd HH:mm:ss"));
		
		/*
		 * ȷ���ջ�������orderDetail�����Ҳ鿴�����������Ƿ���û��ȷ���ջ��Ķ���
		 * ���û�� ���޸���������״̬  ---ȷ���ջ�
		 * �����޸�
		 */
		orderDetailService.QRSH(orderDetail,orderId);

		//ȷ���ջ���ת����Ʒ����
		return "qrsh";    
	}
}
