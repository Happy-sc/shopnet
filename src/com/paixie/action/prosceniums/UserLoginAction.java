package com.paixie.action.prosceniums;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.GetTime;
import com.paixie.common.MD5;
import com.paixie.common.ProduceId;
import com.paixie.domain.Collect;
import com.paixie.domain.ShoppingCar;
import com.paixie.domain.Users;
import com.paixie.service.CollectService;
import com.paixie.service.GoodsService;
import com.paixie.service.ShoppingCarService;
import com.paixie.service.UsersService;

@Controller("userLoginAction")
public class UserLoginAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="usersService")private UsersService usersService;
	@Resource(name="collectService")private CollectService collectService;
	@Resource(name="goodsService")private GoodsService goodsService;
	@Resource(name="shoppingCarService")private ShoppingCarService shoppingCarService;
	private Users users;
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * �����û���¼����
	 */
	public String userLoginUI(){
		//��ȡurl����¼��url,�Ա��ڷ��ص�ԭ���ط�
		String url = request.getParameter("myURL");
		ActionContext.getContext().put("url", url);
		return "userLoginUI";
	}
	
	/**
	 * �û���¼
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String userLogin(){
		//��ȡ�û���
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		//��ȡURL
		String url = request.getParameter("myURL");
		if(url==null||"".equals(url)){
			url = request.getContextPath()+"/goods/goods_goodsIndexUI.action";
		}
		//�û���¼
		String tips;
		Users users1 = usersService.userLogin(userName, MD5.getMD5(password), "userName");
		Users users2 = usersService.userLogin(userName, MD5.getMD5(password), "email");
		Users user = users1==null?users2:users1;
		
		if(user==null){
			tips = "�û����������������,����������...";
			ActionContext.getContext().put("tips", tips);
			ActionContext.getContext().put("url", url);
			return "loginError";
		}
		else {   //��¼�ɹ��������û�����
			ActionContext.getContext().getSession().put("user",user);
			//�ж��Ƿ���ڹ��ﳵ,�����Ϊ�գ��򱣴浽���ݿ�
			Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) request.getSession().getAttribute("mapCar");
			if(mapCar!=null){
				for(Entry<String, ShoppingCar> car :mapCar.entrySet()){
					ShoppingCar shoppingCar = new ShoppingCar();
					shoppingCar = car.getValue();
					shoppingCar.setUsers(user);
					shoppingCarService.updateOrSave(shoppingCar);
				}
			}
			
			//�ض���ָ����url
			try {
				response.sendRedirect(url);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	/**
	 * �û��˳�
	 */
	public String userExit(){
		session.removeAttribute("user");
		return "userExit";
	}
	
	/**
	 * �û���¼
	 * �û�ͨ��jQuery UI Dialog��¼
	 * �����û��ղ���Ʒ��������Ʒ����
	 */
	public String dialogUserLogin(){
		
		//��ȡҳ����Ϣ
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		String goodsId = request.getParameter("goodsId");

		Users users1 = usersService.userLogin(userName, MD5.getMD5(password), "userName");
		Users users2 = usersService.userLogin(userName, MD5.getMD5(password), "email");
		Users user = users1==null?users2:users1;
		
		if(user==null){
			writeToPage("�����û��������������...");
		}
		else {   //��¼�ɹ��������û�����
			ActionContext.getContext().getSession().put("user",user);
			/*
			 * �ж�type
			 * ���type==collect���򱣴��û��ղ���Ϣ
			 * ���Ϊcomment����ת�����۽���
			 */
			if("collect".equals(type)){
				/*
				 * �жϸ��û��Ƿ��Ѿ��ղع�����Ʒ
				 * û�У��򱣴棬�������ʾ�Ѿ��ղ���Ϣ
				 */
				Collect collect = null;
				collect = collectService.getCollectByGoods(goodsId, user.getUserId());
				if(collect!=null){
					writeToPage("���Ѿ��ղع�����Ʒ");
				}
				else {
					collect = new Collect();
					collect.setCollectId(ProduceId.getId());
					collect.setCollectTime(GetTime.getTime("yyyy-MM-dd hh:mm:ss"));
					collect.setGoodsListing(goodsService.getGoodsById(goodsId));
					collect.setUsers(user);
					collectService.saveCollect(collect);
					writeToPage("��Ʒ�ղسɹ�...");
				}	
			}
			if("comment".equals(type)){
				writeToPage("����");
			}
		}
		
		return null;
	}
	
}
