package com.paixie.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

/**
  *���������ϴ���ɾ��ͼƬ  
*/
@Component("uploadAndDeleteImage")
public class UploadAndDeleteImage {
	/**
	 * �ϴ�ͼƬ
	 * @param file �ļ���
	 * @param fileName �ļ���
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
	 * ɾ��ͼƬ
	 * @param fileName �ļ�����ʵ·��
	 */
	public void delete(String fileName){
		File file = new File(fileName);
		if(file.exists()){       //������ھ�ɾ��
			file.delete();
		}
	}
}
