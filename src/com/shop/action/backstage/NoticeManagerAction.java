package com.shop.action.backstage;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.common.GetTime;
import com.shop.common.ProduceId;
import com.shop.domain.Notice;
import com.shop.domain.Worker;
import com.shop.service.NoticeService;

@Controller("noticeManagerAction")
public class NoticeManagerAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="noticeService")private NoticeService noticeService;
	private Notice notice;

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	
	/**
	 * 进入公告管理界面
	 */
	public String noticeManagerUI(){
	
		//获取所有的站内公告
		List<Notice> notices = noticeService.getAllNoticee(super.getPage());
		//对notice进行处理：裁剪公告内容和题目
		List<Notice> noticeL = noticeService.dealNotice(notices);
		
		//获取站内公告的总量 
		pageSum = noticeService.getNoticPageSum("1");
		
		request.setAttribute("notices", noticeL);
		
		return "noticeManagerUI";
	}
	
	/**
	 * 删除公告
	 */
	public void deleteNotice(){
		String noticeId = request.getParameter("noticeId");
		String page = request.getParameter("page");
		
		//根据id删除公告
		noticeService.deleteNotice(noticeId);
		
		try {
			response.sendRedirect("../systemManager/noticeManager_noticeManagerUI.action?page="+page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 增加商品界面
	 */
	public String addNoticeUI(){
		//获取当前时间
		String nowTime = GetTime.getTime("yyyy-MM-dd HH:mm:ss");
		ActionContext.getContext().put("nowTime", nowTime);
		ActionContext.getContext().put("type", "add");
		return "addNoticeUI";
	}
	
	/**
	 * 增加或者修改公告
	 */
	public void saveUpdateNotice(){
		//获取前台来的参数：type、page
		String type = request.getParameter("type");
		
		int page = super.getPage();
		
		//如果为add则设置id
		if("add".equals(type)){
			notice.setNoticeId(ProduceId.getId());
		}
		//获取内容
		String noticeContent = request.getParameter("noticeContent");
		notice.setNoticeContent(noticeContent);
		
		//这是发布人
		Worker  worker = (Worker) session.getAttribute("worker");
		notice.setWorker(worker);
		
		//保存或者修改notice
		noticeService.saveOrUpdateNotice(notice);
		
		try {
			response.sendRedirect("../systemManager/noticeManager_noticeManagerUI?page="+page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查看公告
	 */
	public String showNotice(){
		String noticeId = request.getParameter("noticeId");
		
		//获取公告
		Notice notice1 = noticeService.getNoticeById(noticeId);
		
		request.setAttribute("notice",notice1);
		
		return "showNotice";
	}
	
	/**
	 * 编辑公告界面
	 */
	public String upodateNoticeUI(){
		String noticeId = request.getParameter("noticeId");
		String page = request.getParameter("page");
		
		//获取公告
		Notice notice1 = noticeService.getNoticeById(noticeId);
		
		request.setAttribute("type", "update");
		request.setAttribute("page", page);
		request.setAttribute("notice", notice1);
		request.setAttribute("nowTime", notice1.getNoticeTime());
		
		return "upodateNoticeUI";
	}
}
