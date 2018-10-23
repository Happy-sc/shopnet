package com.paixie.action.backstage;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.DealString;
import com.paixie.common.GetSavePath;
import com.paixie.common.UploadAndDeleteImage;
import com.paixie.domain.Worker;
import com.paixie.service.WorkerService;

@Controller("workerInfoAction")
public class WorkerInfoAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Resource(name="uploadAndDeleteImage")
	private UploadAndDeleteImage uploadAndDeleteImage;
	@Resource(name="workerService")
	private WorkerService workerService;
	private Worker worker;                  //Ա����Ϣ
	private File workerImage;               //�ϴ��ļ���
	private String workerImageContentType;  //�����ϴ��ļ�����
	private String workerImageFileName;     //�ϴ��ļ���
	
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
	 * �鿴������Ϣ
	 */
	public String workerInforUI(){
		return "entryWorkerInfoUI";
	}
	
	/**
	 * �����޸Ļ�����Ϣ����
	 */
	public String updateInfoUI(){
		return "updateInfoUI";
	}
	
	/**
	 * �޸�Ա��������Ϣ
	 */
	public String updateInfo(){
		//��ȡ�û�
		Worker worker1 = (Worker) session.getAttribute("worker");
		//�ļ�·��
		String savePath = GetSavePath.getSavePath("worker");
		//���Ա���ϴ�����Ƭ���򱣴�ͼƬ
		if(getWorkerImage()!=null){
			//�ϴ�ͷ���ļ�
			//�Է��������ļ������ַ��Ա�ļ��������ϴ��ļ������
			uploadAndDeleteImage.upload(getWorkerImage(), savePath+"\\"+getWorkerImageFileName());
			//�ϴ�ͼƬ��,ɾ����ǰ��ͼƬ
			String workerImage = worker1.getWorkerImage();
			//���ͼƬ������ɾ��
			if(workerImage!=null){
				//��ȡ�ļ���
				String[] strings = workerImage.split("/");
				String stringName = strings[strings.length-1];
				//ɾ���ļ�
				uploadAndDeleteImage.delete(savePath+"\\"+stringName); 
			}
			
			//�����û���ͼƬ��¼
			//����ͼƬ·��
			String image = DealString.subAndReplaceString(savePath+"\\"+getWorkerImageFileName());
			getWorker().setWorkerImage(image);
		}
		else {        //���Ϊ������Ҫ����ԭʼͼƬ
			getWorker().setWorkerImage(worker1.getWorkerImage());
		}
		//���������ְ��û�����ã����Ի�Ϊ��,����ֵ
		getWorker().setWorkerPassword(worker1.getWorkerPassword());   
		getWorker().setPosition(worker1.getPosition());
		
		//����Ա����Ϣ
		workerService.UpdateWorker(getWorker());
		//���޸ĺ��Ա����Ϣ���浽session��
		session.setAttribute("worker", getWorker());
		ActionContext.getContext().put("type", "updateInfo");
		return "updateSuccess";
	}
	
	/**
	 * �޸��������
	 */
	public String updatePasswordUI(){
		return "updatePasswordUI";
	}
	
	/**
	 * �޸�����
	 */
	public String updatePassword(){
		//��ȡ�¾�����
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		//��ȡ�û�
		Worker  worker1 = (Worker) request.getSession().getAttribute("worker");	
		//�鿴�������Ƿ�������ȷ
		if(oldPassword.equals(worker1.getWorkerPassword())){      //�ɹ��޸�����
			worker1.setWorkerPassword(newPassword);
			//������Ϣ
			workerService.UpdateWorker(worker1);
			request.getSession().setAttribute("worker", worker1);
			return "updateSuccess";
		}
		else {       //ʧ�ܷ��ش�����Ϣ
			request.setAttribute("message", "�������������...");
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

