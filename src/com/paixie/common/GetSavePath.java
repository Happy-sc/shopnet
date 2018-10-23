package com.paixie.common;

import org.apache.struts2.ServletActionContext;

/**
 * ��ȡ�ϴ��ļ�Ŀ¼
 */
public class GetSavePath {
	
	/**
	 * �������ͻ�ȡ�ϴ��ļ�·��
	 * @param type ����
	 * @return
	 */
	public static String getSavePath(String type){
		String savepath = null;
		//��Ʒ�ϴ�·��
		if("goods".equals(type)){          
			savepath = ServletActionContext.getServletContext().getRealPath("images/goods/goods");
		}
		
		//��ʱ�ļ��ϴ�·��
		if("temp".equals(type)){
			savepath = ServletActionContext.getServletContext().getRealPath("images/goods/temps");
		}
		
		//Ʒ���ļ��ϴ�·��
		if("brand".equals(type)){
			savepath =ServletActionContext.getServletContext().getRealPath("images/goods/brands");
		}
		
		//Ա��ͷ��
		if("worker".equals(type)){
			savepath = ServletActionContext.getServletContext().getRealPath("images/photo/worker");
		}
		
		//�û�ͷ��
		if("user".equals(type)){
			savepath = ServletActionContext.getServletContext().getRealPath("images/photo/user");
		}
		return savepath;
	}

}
