package com.shop.action.prosceniums;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.shop.action.common.BaseAction;

@Controller("checkCodeAction")
public class CheckCodeAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	//定义图形验证码中绘制字符的字体
	private final Font font = new Font("Arial Black",Font.PLAIN,20);
	//定义图形验证码的大小
	private final int IMG_WIDTH = 90;
	private final int IMG_HEIGTH = 25;
	//定义一个获取随机颜色的方法
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
		//得到随机颜色
		return new Color(r,g,b);
	}
	
	/**
	 * 生成验证码
	 * @return 生成的字符串
	 * @throws IOException
	 */
	public String execute() throws IOException{		
		//设置页面不缓存 
		response.setHeader("Pragma","No-cache");   
		response.setHeader("Cache-Control","no-cache");   
		response.setDateHeader("Expires", 0);  
		response.setContentType("image/jpeg");
		
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGTH, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getColor(200, 250));
		//填充颜色
		g.fillRect(1, 1, IMG_WIDTH - 1, IMG_HEIGTH - 1);
		//为图形验证码绘制边框
		g.setColor(new Color(102,102,102));
		g.drawRect(0, 0, IMG_WIDTH - 1, IMG_HEIGTH - 1);
		g.setColor(getColor(160, 200));
		
		//生成随机干扰线
		for(int i = 0;i < 80 ;i++){
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGTH - 1);
			int xl = random.nextInt(6) + 1;
			int yl = random.nextInt(12) + 1;
			g.drawLine(x, y, x + xl, y + yl);
		}
		g.setColor(getColor(160, 200));
		
		//生成随机干扰线
		for (int i = 0; i < 80; i++) {
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGTH - 1);
			int xl = random.nextInt(12) + 1;
			int yl = random.nextInt(6) + 1;
			g.drawLine(x, y,x - xl,y - yl);
		}
		
		//设置绘制字符的字体
		g.setFont(font);
		//用户保存系统生成的随机字符串
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String tmp = getRandomChar();
			sRand += tmp;
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			//在图片上绘制系统生成的随机字符串
			g.drawString(tmp, 12*i+15, 20);
		}
		
		//获取HttpSession对象
		HttpSession session = request.getSession();  
		//保存生成的随机数
		session.setAttribute("rand", sRand);
		g.dispose();
		
		//向输出流输入图片
		ImageIO.write(image, "JPEG", response.getOutputStream());
		return null;
	}
	
	/**
	 * 定义获取随机字符串的方法
	 * 根据随即数获取生产的大写字母、小写字母、数字
	 * @return
	 */
	private String getRandomChar(){
		//随机生成0、1、2之中的一个数字
		int rand = (int) Math.round(Math.random()*2);
		long itmp = 0;
		char ctmp = '\u0000';
		switch (rand) {
		//生成大写字母
		case 1:
			itmp = Math.round(Math.random()*25 + 65);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);
		//生成小写字母
		case 2:
			itmp = Math.round(Math.random()*25 + 97);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);
		//生成数字
		default:
			itmp = Math.round(Math.random()*9);
			return itmp + "";
		}
	}
}
