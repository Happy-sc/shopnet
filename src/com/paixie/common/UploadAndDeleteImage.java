package com.paixie.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

/**
  *该类用于上传和删除图片  
*/
@Component("uploadAndDeleteImage")
public class UploadAndDeleteImage {
	/**
	 * 上传图片
	 * @param file 文件流
	 * @param fileName 文件名
	 */
	public void upload(File file,String fileName){
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			FileInputStream fis = new FileInputStream(file);;
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len=fis.read(buffer))>0){
				fos.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * 删除图片
	 * @param fileName 文件的真实路径
	 */
	public void delete(String fileName){
		File file = new File(fileName);
		if(file.exists()){       //如果存在就删除
			file.delete();
		}
	}
}
