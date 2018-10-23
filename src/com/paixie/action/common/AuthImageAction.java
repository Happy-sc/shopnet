package com.paixie.action.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

/**
  *������֤��
*/
@Component("authImageAction")
public class AuthImageAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	//����ͼ����֤���л����ַ�������
	private int AUTH_NUMBER;              //��֤��ĸ���
	//����ͼ����֤��Ĵ�С
	private int IMG_WIDTH ;               //��
	private int IMG_HEIGTH;              //��
	//����
	private int FONT_JBZ;                  //����Ļ���ֵ
	private int FONT_jj;                 //������
	private int FONT_GD;                 //����Ŀ�ʼ�߶�
	private int FONT_SIZE;               //�����С
	public int getAUTH_NUMBER() {
		return AUTH_NUMBER;
	}

	public void setAUTH_NUMBER(int aUTHNUMBER) {
		AUTH_NUMBER = aUTHNUMBER;
	}

	public int getIMG_WIDTH() {
		return IMG_WIDTH;
	}

	public void setIMG_WIDTH(int iMGWIDTH) {
		IMG_WIDTH = iMGWIDTH;
	}

	public int getIMG_HEIGTH() {
		return IMG_HEIGTH;
	}

	public void setIMG_HEIGTH(int iMGHEIGTH) {
		IMG_HEIGTH = iMGHEIGTH;
	}

	public int getFONT_JBZ() {
		return FONT_JBZ;
	}

	public void setFONT_JBZ(int font_jbz) {
		FONT_JBZ = font_jbz;
	}

	public int getFONT_jj() {
		return FONT_jj;
	}

	public void setFONT_jj(int font_jj) {
		FONT_jj = font_jj;
	}

	public int getFONT_GD() {
		return FONT_GD;
	}

	public void setFONT_GD(int font_gd) {
		FONT_GD = font_gd;
	}

	public int getFONT_SIZE() {
		return FONT_SIZE;
	}

	public void setFONT_SIZE(int font_size) {
		FONT_SIZE = font_size;
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
		
		BufferedImage image = new BufferedImage(getIMG_WIDTH(), getIMG_HEIGTH(), BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getColor(200, 250));
		//�����ɫ
		g.fillRect(1, 1, getIMG_WIDTH() - 1, getIMG_HEIGTH() - 1);
		//Ϊͼ����֤����Ʊ߿�
		g.setColor(new Color(102,102,102));
		g.drawRect(0, 0,getIMG_WIDTH() - 1,getIMG_HEIGTH() - 1);
		g.setColor(getColor(160, 200));
		
		//�������������
		for(int i = 0;i < 80 ;i++){
			int x = random.nextInt(getIMG_WIDTH() - 1);
			int y = random.nextInt(getIMG_HEIGTH()- 1);
			int xl = random.nextInt(6) + 1;
			int yl = random.nextInt(12) + 1;
			g.drawLine(x, y, x + xl, y + yl);
		}
		g.setColor(getColor(160, 200));
		
		//�������������
		for (int i = 0; i < 80; i++) {
			int x = random.nextInt(getIMG_WIDTH() - 1);
			int y = random.nextInt(getIMG_HEIGTH() - 1);
			int xl = random.nextInt(12) + 1;
			int yl = random.nextInt(6) + 1;
			g.drawLine(x, y,x - xl,y - yl);
		}
		
		//���û����ַ�������
		Font font = new Font("Arial Black",Font.PLAIN,getFONT_SIZE());
		g.setFont(font);
		//�û�����ϵͳ���ɵ�����ַ���
		String sRand = "";
		for (int i = 0; i < getAUTH_NUMBER(); i++) {
			String tmp = getRandomChar();
			sRand += tmp;
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			//��ͼƬ�ϻ���ϵͳ���ɵ�����ַ���
			g.drawString(tmp, getFONT_JBZ()*i+getFONT_jj(),getFONT_GD());
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
	 * ����һ����ȡ�����ɫ�ķ���
	 */
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
