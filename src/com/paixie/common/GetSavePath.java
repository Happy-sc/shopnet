package com.paixie.common;

import org.apache.struts2.ServletActionContext;

/**
 * 获取上传文件目录
 */
public class GetSavePath {
	
	/**
	 * 根据类型获取上传文件路径
	 * @param type 类型
	 * @return
	 */
	public static String getSavePath(String type){
		String savepath = null;
		//商品上传路劲
		if("goods".equals(type)){          
			savepath = ServletActionContext.getServletContext().getRealPath("images/goods/goods");
		}
		
		//临时文件上传路径
		if("temp".equals(type)){
			savepath = ServletActionContext.getServletContext().getRealPath("images/goods/temps");
		}
		
		//品牌文件上传路劲
		if("brand".equals(type)){
			savepath =ServletActionContext.getServletContext().getRealPath("images/goods/brands");
		}
		
		//员工头像
		if("worker".equals(type)){
			savepath = ServletActionContext.getServletContext().getRealPath("images/photo/worker");
		}
		
		//用户头像
		if("user".equals(type)){
			savepath = ServletActionContext.getServletContext().getRealPath("images/photo/user");
		}
		return savepath;
	}

}
