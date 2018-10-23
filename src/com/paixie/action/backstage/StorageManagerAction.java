package com.paixie.action.backstage;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.paixie.action.common.BaseAction;
import com.paixie.domain.Storage;
import com.paixie.service.StorageService;

@Controller("storageManagerAction")
public class StorageManagerAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="storageService") private StorageService storageService;
	/**
	 * 仓库管理首页
	 */
	public String storageManagerUI(){
		//获取该页码的所有仓库
		List<Storage> storages = storageService.getAllStorage();
		
		request.setAttribute("storages", storages);
		return "storageManagerUI";
	}
}
