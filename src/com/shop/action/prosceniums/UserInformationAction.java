package com.shop.action.prosceniums;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.domain.Address;
import com.shop.domain.SecretSecurity;
import com.shop.domain.Users;
import com.shop.service.AddressService;
import com.shop.service.SecretSecurityService;
import com.shop.service.UsersService;

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
	 * 进入个人信息中心
	 */
	public String enterUserInfor(){
		//获取用户实例
		Users user = (Users) session.getAttribute("user");
		//处理地址
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
	 * 修改用户个人信息
	 */
	public String saveUserInfor(){
		//处理地址
		//获取地址信息
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String countryCity = request.getParameter("countryCity");
		String villageStreet = request.getParameter("villageStreet");
		//构建地址信息
		String address = province+","+city+","+countryCity+","+villageStreet;

		//获取该用户
		Users user = usersService.getUserById(users.getUserId());
		//保存信息
		user.setUserAddress(address);
		user.setUserBirthday(users.getUserBirthday());
		user.setUserSex(users.getUserSex());
		user.setUserRealName(users.getUserRealName());
		
		usersService.updateUser(user);
		session.setAttribute("user", user);
		
		return "userInforSuccess";
	}
	
	/**
	 * 进入安全中心
	 */
	public String enterSafeCenter(){
		//获取用户密保，用于判断是否已经设置了密保
		Users user = (Users ) session.getAttribute("user");
		List<SecretSecurity> secretSecurities = secretSecurityService.getSecreteSecurityByUserId(user.getUserId());
		ActionContext.getContext().put("secret", secretSecurities.size());
		return "enterSafeCenter";
	}
	
	/**
	 * 进入收获地址
	 */
	public String enterAddressManager(){
		//获取该用户的所有收获地址
		Users user = (Users) session.getAttribute("user");
		List<Address> addresses = addressService.getAddressByUser(user.getUserId());
		ActionContext.getContext().put("addresses", addresses);
		ActionContext.getContext().put("addressNumber", addresses.size());
		return "enterAddressManager";
	}
	
}
