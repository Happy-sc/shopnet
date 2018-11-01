package com.shop.action.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
/**
 *该类为action的基类，所有的action都应该继承该类
 */
@Scope("prototype")
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private static final long serialVersionUID = 1L;

	/**
	 * HttpServletRequest
	 */
	protected HttpServletRequest request ;
	
	/**
	 * HttpServletResponse
	 */
	protected HttpServletResponse response;
	
	/**
	 * HttpSession
	 */
	protected HttpSession session ;
	
	protected Integer page = 1;       //页码
	
	protected Integer pageSum = 1;       //总页数

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}


	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 *向页面传值
	 */
	public  void writeToPage(String string){
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		if(page==null||page==0){
			this.page = 1;
		}
		else {
			this.page = page;
		}
		
	}

	public Integer getPageSum() {
		return pageSum;
	}

	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}

}
