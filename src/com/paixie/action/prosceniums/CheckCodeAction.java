package com.paixie.action.prosceniums;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.paixie.action.common.BaseAction;

@Controller("checkCodeAction")
public class CheckCodeAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	//����ͼ����֤���л����ַ�������
	private final Font font = new Font("Arial Black",Font.PLAIN,20);
	//����ͼ����֤��Ĵ�С
	private final int IMG_WIDTH = 90;
	private final int IMG_HEIGTH = 25;
	//����һ����ȡ�����ɫ�ķ���
	private Color getColor(int fc,int bc){
		Random random = new Random();
		if(fc > 255){
			fc = 255;
		}
		if(bc > 255){
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		//�õ������ɫ
		return new Color(r,g,b);
	}
	
	/**
	 * ������֤��
	 * @return ���ɵ��ַ���
	 * @throws IOException
	 */
	public String execute() throws IOException{		
		//����ҳ�治���� 
		response.setHeader("Pragma","No-cache");   
		response.setHeader("Cache-Control","no-cache");   
		response.setDateHeader("Expires", 0);  
		response.setContentType("image/jpeg");
		
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGTH, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getColor(200, 250));
		//�����ɫ
		g.fillRect(1, 1, IMG_WIDTH - 1, IMG_HEIGTH - 1);
		//Ϊͼ����֤����Ʊ߿�
		g.setColor(new Color(102,102,102));
		g.drawRect(0, 0, IMG_WIDTH - 1, IMG_HEIGTH - 1);
		g.setColor(getColor(160, 200));
		
		//�������������
		for(int i = 0;i < 80 ;i++){
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGTH - 1);
			int xl = random.nextInt(6) + 1;
			int yl = random.nextInt(12) + 1;
			g.drawLine(x, y, x + xl, y + yl);
		}
		g.setColor(getColor(160, 200));
		
		//�������������
		for (int i = 0; i < 80; i++) {
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGTH - 1);
			int xl = random.nextInt(12) + 1;
			int yl = random.nextInt(6) + 1;
			g.drawLine(x, y,x - xl,y - yl);
		}
		
		//���û����ַ�������
		g.setFont(font);
		//�û�����ϵͳ���ɵ�����ַ���
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String tmp = getRandomChar();
			sRand += tmp;
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			//��ͼƬ�ϻ���ϵͳ���ɵ�����ַ���
			g.drawString(tmp, 12*i+15, 20);
		}
		
		//��ȡHttpSession����
		HttpSession session = request.getSession();  
		//�������ɵ������
		session.setAttribute("rand", sRand);
		g.dispose();
		
		//�����������ͼƬ
		ImageIO.write(image, "JPEG", response.getOutputStream());
		return null;
	}
	
	/**
	 * �����ȡ����ַ����ķ���
	 * �����漴����ȡ�����Ĵ�д��ĸ��Сд��ĸ������
	 * @return
	 */
	private String getRandomChar(){
		//�������0��1��2֮�е�һ������
		int rand = (int) Math.round(Math.random()*2);
		long itmp = 0;
		char ctmp = '\u0000';
		switch (rand) {
		//���ɴ�д��ĸ
		case 1:
			itmp = Math.round(Math.random()*25 + 65);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);
		//����Сд��ĸ
		case 2:
			itmp = Math.round(Math.random()*25 + 97);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);
		//��������
		default:
			itmp = Math.round(Math.random()*9);
			return itmp + "";
		}
	}
}
