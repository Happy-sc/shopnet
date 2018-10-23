package com.paixie.action.prosceniums;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.domain.Address;
import com.paixie.domain.SecretSecurity;
import com.paixie.domain.Users;
import com.paixie.service.AddressService;
import com.paixie.service.SecretSecurityService;
import com.paixie.service.UsersService;

@Controller("userInformationAction")
public class UserInformationAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="usersService")private UsersService usersService;
	@Resource(name="secretSecurityService")private SecretSecurityService secretSecurityService;
	@Resource(name="addressService")private AddressService addressService;
	private Users users;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * ���������Ϣ����
	 */
	public String enterUserInfor(){
		//��ȡ�û�ʵ��
		Users user = (Users) session.getAttribute("user");
		//�����ַ
		String address = user.getUserAddress();
		if(!"".equals(address)&&address!=null){
			String[] string = address.split(",");
			ActionContext.getContext().put("province",string[0]);
			ActionContext.getContext().put("city",string[1]);
			ActionContext.getContext().put("country",string[2]);
			ActionContext.getContext().put("village",string[3]);
		}
		return "enterUserInfor";
	}
	
	/**
	 * �޸��û�������Ϣ
	 */
	public String saveUserInfor(){
		//�����ַ
		//��ȡ��ַ��Ϣ
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String countryCity = request.getParameter("countryCity");
		String villageStreet = request.getParameter("villageStreet");
		//������ַ��Ϣ
		String address = province+","+city+","+countryCity+","+villageStreet;

		//��ȡ���û�
		Users user = usersService.getUserById(users.getUserId());
		//������Ϣ
		user.setUserAddress(address);
		user.setUserBirthday(users.getUserBirthday());
		user.setUserSex(users.getUserSex());
		user.setUserRealName(users.getUserRealName());
		
		usersService.updateUser(user);
		session.setAttribute("user", user);
		
		return "userInforSuccess";
	}
	
	/**
	 * ���밲ȫ����
	 */
	public String enterSafeCenter(){
		//��ȡ�û��ܱ��������ж��Ƿ��Ѿ��������ܱ�
		Users user = (Users ) session.getAttribute("user");
		List<SecretSecurity> secretSecurities = secretSecurityService.getSecreteSecurityByUserId(user.getUserId());
		ActionContext.getContext().put("secret", secretSecurities.size());
		return "enterSafeCenter";
	}
	
	/**
	 * �����ջ��ַ
	 */
	public String enterAddressManager(){
		//��ȡ���û��������ջ��ַ
		Users user = (Users) session.getAttribute("user");
		List<Address> addresses = addressService.getAddressByUser(user.getUserId());
		ActionContext.getContext().put("addresses", addresses);
		ActionContext.getContext().put("addressNumber", addresses.size());
		return "enterAddressManager";
	}
	
}
