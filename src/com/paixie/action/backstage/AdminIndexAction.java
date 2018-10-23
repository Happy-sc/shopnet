package com.paixie.action.backstage;

import org.springframework.stereotype.Controller;

/**
  * 实现jframeset中的src页面
*/
@Controller("adminIndexAction")
public class AdminIndexAction {
	/**
	 * admin_top.jsp
	 */
	public String toAdminTop(){
		return "adminTop";
	}
	
	
	/**
	 * admin_Left.jsp
	 */
	public String toAdminLeft(){
		return "adminLeft";
	}
	
	/**
	 * admin_right.jsp
	 */
	public String toAdminRight(){
		return "adminRight";
	}
}

