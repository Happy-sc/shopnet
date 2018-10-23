package com.paixie.domain;

import java.io.Serializable;

/**
 * 公告实体类
 * @author Administrator
 *
 */
public class Notice implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String noticeId;              //公告编号
	private String noticeContent;         //公告内容
	private String noticeTitle;           //公告主题
	private String noticeTime;            //公告发布时间
	private String noticeType;            //公告类型 1:站内  2：站外
	private Worker worker;                //发布人
	
	public Notice(){
		
	}
	
	public Notice(String noticeId){
		this.noticeId = noticeId;
	}
	
	public Notice(String noticeId,String noticeContent,String noticeTitle,
			String noticeTime,String noticeType,Worker worker){
		this.noticeId = noticeId;
		this.noticeContent = noticeContent;
		this.noticeTime = noticeTime;
		this.noticeTitle = noticeTitle;
		this.noticeType = noticeType;
		this.worker = worker;
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
	
}
