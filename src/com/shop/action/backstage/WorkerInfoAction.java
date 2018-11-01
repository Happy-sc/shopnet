package com.shop.action.backstage;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.common.DealString;
import com.shop.common.GetSavePath;
import com.shop.common.UploadAndDeleteImage;
import com.shop.domain.Worker;
import com.shop.service.WorkerService;

@Controller("workerInfoAction")
public class WorkerInfoAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Resource(name="uploadAndDeleteImage")
	private UploadAndDeleteImage uploadAndDeleteImage;
	@Resource(name="workerService")
	private WorkerService workerService;
	private Worker worker;                  //员工信息
	private File workerImage;               //上传文件域
	private String workerImageContentType;  //分组上传文件类型
	private String workerImageFileName;     //上传文件名
	
	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
	public File getWorkerImage() {
		return workerImage;
	}

	public void setWorkerImage(File workerImage) {
		this.workerImage = workerImage;
	}

	public String getWorkerImageContentType() {
		return workerImageContentType;
	}

	public void setWorkerImageContentType(String workerImageContentType) {
		this.workerImageContentType = workerImageContentType;
	}

	public String getWorkerImageFileName() {
		return workerImageFileName;
	}

	public void setWorkerImageFileName(String workerImageFileName) {
		this.workerImageFileName = workerImageFileName;
	}

	/**
	 * 查看基本信息
	 */
	public String workerInforUI(){
		return "entryWorkerInfoUI";
	}
	
	/**
	 * 进入修改基本信息界面
	 */
	public String updateInfoUI(){
		return "updateInfoUI";
	}
	
	/**
	 * 修改员工基本信息
	 */
	public String updateInfo(){
		//获取用户
		Worker worker1 = (Worker) session.getAttribute("worker");
		//文件路劲
		String savePath = GetSavePath.getSavePath("worker");
		//如果员工上传了照片，则保存图片
		if(getWorkerImage()!=null){
			//上传头像文件
			//以服务器的文件保存地址和员文件名建立上传文件输出流
			uploadAndDeleteImage.upload(getWorkerImage(), savePath+"\\"+getWorkerImageFileName());
			//上传图片后,删除以前的图片
			String workerImage = worker1.getWorkerImage();
			//如果图片存在则删除
			if(workerImage!=null){
				//获取文件名
				String[] strings = workerImage.split("/");
				String stringName = strings[strings.length-1];
				//删除文件
				uploadAndDeleteImage.delete(savePath+"\\"+stringName); 
			}
			
			//保存用户的图片记录
			//处理图片路径
			String image = DealString.subAndReplaceString(savePath+"\\"+getWorkerImageFileName());
			getWorker().setWorkerImage(image);
		}
		else {        //如果为空则需要设置原始图片
			getWorker().setWorkerImage(worker1.getWorkerImage());
		}
		//由于密码和职务没有设置，所以会为空,设置值
		getWorker().setWorkerPassword(worker1.getWorkerPassword());   
		getWorker().setPosition(worker1.getPosition());
		
		//保存员工信息
		workerService.UpdateWorker(getWorker());
		//将修改后的员工信息保存到session中
		session.setAttribute("worker", getWorker());
		ActionContext.getContext().put("type", "updateInfo");
		return "updateSuccess";
	}
	
	/**
	 * 修改密码界面
	 */
	public String updatePasswordUI(){
		return "updatePasswordUI";
	}
	
	/**
	 * 修改密码
	 */
	public String updatePassword(){
		//获取新旧密码
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		//获取用户
		Worker  worker1 = (Worker) request.getSession().getAttribute("worker");	
		//查看旧密码是否输入正确
		if(oldPassword.equals(worker1.getWorkerPassword())){      //成功修改密码
			worker1.setWorkerPassword(newPassword);
			//保存信息
			workerService.UpdateWorker(worker1);
			request.getSession().setAttribute("worker", worker1);
			return "updateSuccess";
		}
		else {       //失败返回错误信息
			request.setAttribute("message", "旧密码输入错误...");
			return "updatePasswordUI";
		}
		
	}
	
	
	public String error(){
		return "error";
	}
	
	public String success(){
		return "success";
	}
	
}

