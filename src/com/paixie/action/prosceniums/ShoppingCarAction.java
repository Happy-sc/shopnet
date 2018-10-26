package com.paixie.action.prosceniums;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.ProduceId;
import com.paixie.domain.GoodsListing;
import com.paixie.domain.ShoppingCar;
import com.paixie.domain.Users;
import com.paixie.service.GoodsService;
import com.paixie.service.ShoppingCarService;

@Controller("shoppingCarAction")
public class ShoppingCarAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="goodsService")private GoodsService goodsService;
	@Resource(name="shoppingCarService")private ShoppingCarService shoppingCarService;
	
	/**
	 * �����Ʒ�����ﳵ
	 */
	@SuppressWarnings("unchecked")
	public void addGoods(){
		//��ȡ�ύ��Ϣ
		String goodsId = request.getParameter("goodsId");                 //��Ʒ���
		String goodsColor = request.getParameter("goodsColor");           //��Ʒ��ɫ
		String goodsAttr = request.getParameter("goodsAttr");             //��Ʒ����
		String goodsNumber = request.getParameter("goodsNumber");         //��Ʒ����
		/*
		 * ��ȡ���ﳵ
		 * ������ﳵΪnull,��new
		 * ���ﳵ��map��ʽ���ڣ�map<carId,shoppingCar>
		 * carId=goodsId+goodsColor+goodsSize
		 */
		HttpSession session = request.getSession();
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) session.getAttribute("mapCar");
		if(mapCar==null){       //Ϊ�����½�
			mapCar = new HashMap<String, ShoppingCar>();
		}
		
		/*
		 * ������ﳵ�а�������Ʒ����ֻ��Ҫ������������
		 */
		ShoppingCar shoppingCar = null;
		String carId = goodsId+goodsColor+goodsAttr;//���ﳵ���
		if(mapCar.containsKey(carId)){      //���ڸ���Ʒ����Ʒ��������
			shoppingCar = mapCar.get(carId);  
			shoppingCar.setGoodsNumber(shoppingCar.getGoodsNumber()+Integer.valueOf(goodsNumber));
		}
		else {
			shoppingCar = new ShoppingCar();
			shoppingCar.setCarId(ProduceId.getId());
			shoppingCar.setGoodsColor(goodsColor);
			shoppingCar.setGoodsNumber(Integer.valueOf(goodsNumber));
			shoppingCar.setGoodsAttr(goodsAttr);
			//��ȡ����Ʒ
			GoodsListing goods = goodsService.getGoodsById(goodsId);
			shoppingCar.setGoodsListing(goods);
		}
			
		/*
		 * ����û�����,���Ѿ���½�������ﳵ��ӵ����û�����
		 */
		Users users = (Users) session.getAttribute("user");
		if(users!=null){
			shoppingCar.setUsers(users);        
			//�����ﳵ��ӵ����û�����,����map��������
			for(Entry<String , ShoppingCar> sc:mapCar.entrySet()){
				ShoppingCar mycar = sc.getValue();
				mycar.setUsers(users);
			}
		}
		
		//�����ﳵ��ӵ�map��
		mapCar.put(carId, shoppingCar);

		//�û����ڣ����浽���ݿ�
		if(users!=null){
			for(Entry<String, ShoppingCar> sc :mapCar.entrySet()){
				ShoppingCar mycar = sc.getValue();
				shoppingCarService.updateOrSave(mycar);
			}
		}
		
		session.setAttribute("mapCar", mapCar);         //����session
		int countNumber = mapCar.size();
		float sum = this.carSum(mapCar);
		//���湺�ﳵ��Ϣ
		String returnData = String.valueOf(countNumber+","+sum);
		
		//��������
		this.writeToPage(returnData);

	}
	
	/**
	 * �鿴���ﳵ
	 */
	@SuppressWarnings("unchecked")
	public String showCar(){
		//��ȡ���ﳵ
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) session.getAttribute("mapCar");
		//�����ܽ��
		double sum = 0;
		for(Entry<String, ShoppingCar> mycar:mapCar.entrySet()){
			ShoppingCar car =mycar.getValue();
			sum = sum+car.getGoodsListing().getGoodsMarketPrice()*car.getGoodsNumber();
		}
		ActionContext.getContext().put("sum", sum);
		ActionContext.getContext().put("car", mapCar);
		ActionContext.getContext().put("carSize", mapCar.size());
		ActionContext.getContext().put("type", "showCar");
		return "showCar";
	}
	
	/**
	 * �޸Ĺ��ﳵ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String updateCar(){
		//��ȡ���ﳵ���������ﳵ��ţ���Ʒ����
		String carId = request.getParameter("carId");
		String number = request.getParameter("number");
		//��ȡ���ﳵ
		HttpSession session = request.getSession();
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) session.getAttribute("mapCar");
		ShoppingCar car = mapCar.get(carId);
		car.setGoodsNumber(Integer.valueOf(number));
		mapCar.put(carId, car);
		
		//���������ݿ�
		for(Entry<String, ShoppingCar> sc :mapCar.entrySet()){
			ShoppingCar mycar = sc.getValue();
			shoppingCarService.updateOrSave(mycar);
		}
		
		session.setAttribute("mapCar", mapCar);        //�������ݿ�
		
		float sum = this.carSum(mapCar);
		this.writeToPage(String.valueOf(sum));
		return null;
	}
	
	/**
	 * �ڹ��ﳵ��ɾ��ĳ��Ʒ
	 * �������ݿ���ɾ����Ȼ����map��ɾ��
	 * @param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String deleteGoods(){
		//��ȡ����Ʒ����
		String carId = request.getParameter("carId");
		
		//��ȡ���ﳵ
		HttpSession session = request.getSession();
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) session.getAttribute("mapCar");
		
		//����û����������ݿ���ҲҪɾ��������¼
		Users user = (Users) session.getAttribute("user");
		if(user!=null){
			shoppingCarService.deleteCar(mapCar.get(carId));
		}
		
		mapCar.remove(carId);
		
		session.setAttribute("mapCar", mapCar);
		
		float sum = this.carSum(mapCar);
		this.writeToPage(String.valueOf(sum));
		return null;
	}
	
	/**
	 * ���㹺�ﳵ���ܽ��
	 */
	public float carSum(Map<String, ShoppingCar> mapCar){
		float sum = 0;               //���ﳵ�ܼ۸�
		for(Entry<String, ShoppingCar> nc : mapCar.entrySet()){
			ShoppingCar myCar = nc.getValue();
			sum = sum+myCar.getGoodsNumber()*myCar.getGoodsListing().getGoodsMarketPrice();
		}
		return sum;
	}
	
	/**
	 * ��ͻ��˴�������
	 */
	public void writeToPage(String sum){
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(String.valueOf(sum));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
