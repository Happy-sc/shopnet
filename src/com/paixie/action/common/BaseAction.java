package com.paixie.action.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
/**
 *����Ϊaction�Ļ��࣬���е�action��Ӧ�ü̳и���
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
	
	protected Integer page = 1;       //ҳ��
	
	protected Integer pageSum = 1;       //��ҳ��

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
	 *��ҳ�洫ֵ
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
