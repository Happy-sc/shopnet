package com.paixie.action.backstage;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.GetTime;
import com.paixie.common.ProduceId;
import com.paixie.domain.Notice;
import com.paixie.domain.Worker;
import com.paixie.service.NoticeService;

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
	 * ���빫��������
	 */
	public String noticeManagerUI(){
	
		//��ȡ���е�վ�ڹ���
		List<Notice> notices = noticeService.getAllNoticee(super.getPage());
		//��notice���д����ü��������ݺ���Ŀ
		List<Notice> noticeL = noticeService.dealNotice(notices);
		
		//��ȡվ�ڹ�������� 
		pageSum = noticeService.getNoticPageSum("1");
		
		request.setAttribute("notices", noticeL);
		
		return "noticeManagerUI";
	}
	
	/**
	 * ɾ������
	 */
	public void deleteNotice(){
		String noticeId = request.getParameter("noticeId");
		String page = request.getParameter("page");
		
		//����idɾ������
		noticeService.deleteNotice(noticeId);
		
		try {
			response.sendRedirect("../systemManager/noticeManager_noticeManagerUI.action?page="+page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ������Ʒ����
	 */
	public String addNoticeUI(){
		//��ȡ��ǰʱ��
		String nowTime = GetTime.getTime("yyyy-MM-dd HH:mm:ss");
		ActionContext.getContext().put("nowTime", nowTime);
		ActionContext.getContext().put("type", "add");
		return "addNoticeUI";
	}
	
	/**
	 * ���ӻ����޸Ĺ���
	 */
	public void saveUpdateNotice(){
		//��ȡǰ̨���Ĳ�����type��page
		String type = request.getParameter("type");
		
		int page = super.getPage();
		
		//���Ϊadd������id
		if("add".equals(type)){
			notice.setNoticeId(ProduceId.getId());
		}
		//��ȡ����
		String noticeContent = request.getParameter("noticeContent");
		notice.setNoticeContent(noticeContent);
		
		//���Ƿ�����
		Worker  worker = (Worker) session.getAttribute("worker");
		notice.setWorker(worker);
		
		//��������޸�notice
		noticeService.saveOrUpdateNotice(notice);
		
		try {
			response.sendRedirect("../systemManager/noticeManager_noticeManagerUI?page="+page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �鿴����
	 */
	public String showNotice(){
		String noticeId = request.getParameter("noticeId");
		
		//��ȡ����
		Notice notice1 = noticeService.getNoticeById(noticeId);
		
		request.setAttribute("notice",notice1);
		
		return "showNotice";
	}
	
	/**
	 * �༭�������
	 */
	public String upodateNoticeUI(){
		String noticeId = request.getParameter("noticeId");
		String page = request.getParameter("page");
		
		//��ȡ����
		Notice notice1 = noticeService.getNoticeById(noticeId);
		
		request.setAttribute("type", "update");
		request.setAttribute("page", page);
		request.setAttribute("notice", notice1);
		request.setAttribute("nowTime", notice1.getNoticeTime());
		
		return "upodateNoticeUI";
	}
}
