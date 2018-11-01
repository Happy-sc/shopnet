package com.shop.action.prosceniums;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.common.GetTime;
import com.shop.common.MD5;
import com.shop.common.ProduceId;
import com.shop.domain.Collect;
import com.shop.domain.ShoppingCar;
import com.shop.domain.Users;
import com.shop.service.CollectService;
import com.shop.service.GoodsService;
import com.shop.service.ShoppingCarService;
import com.shop.service.UsersService;

@Controller("userLoginAction")
public class UserLoginAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="usersService")private UsersService usersService;
	@Resource(name="collectService")private CollectService collectService;
	@Resource(name="goodsService")private GoodsService goodsService;
	@Resource(name="shoppingCarService")private ShoppingCarService shoppingCarService;
	private Users users;
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * 进入用户登录界面
	 */
	public String userLoginUI(){
		//获取url，记录该url,以便于返回到原来地方
		String url = request.getParameter("myURL");
		ActionContext.getContext().put("url", url);
		return "userLoginUI";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String userLogin(){
		//获取用户名
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		//获取URL
		String url = request.getParameter("myURL");
		if(url==null||"".equals(url)){
			url = request.getContextPath()+"/goods/goods_goodsIndexUI.action";
		}
		//用户登录
		String tips;
		Users users1 = usersService.userLogin(userName, MD5.getMD5(password), "userName");
		Users users2 = usersService.userLogin(userName, MD5.getMD5(password), "email");
		Users user = users1==null?users2:users1;
		
		if(user==null){
			tips = "用户名或密码输入错误,请重新输入...";
			ActionContext.getContext().put("tips", tips);
			ActionContext.getContext().put("url", url);
			return "loginError";
		}
		else {   //登录成功，保存用户数据
			ActionContext.getContext().getSession().put("user",user);
			//判断是否存在购物车,如果不为空，则保存到数据库
			Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) request.getSession().getAttribute("mapCar");
			if(mapCar!=null){
				for(Entry<String, ShoppingCar> car :mapCar.entrySet()){
					ShoppingCar shoppingCar = new ShoppingCar();
					shoppingCar = car.getValue();
					shoppingCar.setUsers(user);
					shoppingCarService.updateOrSave(shoppingCar);
				}
			}
			
			//重定向到指定的url
			try {
				response.sendRedirect(url);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	/**
	 * 用户退出
	 */
	public String userExit(){
		session.removeAttribute("user");
		return "userExit";
	}
	
	/**
	 * 用户登录
	 * 用户通过jQuery UI Dialog登录
	 * 进行用户收藏商品和评价商品处理
	 */
	public String dialogUserLogin(){
		
		//获取页面信息
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		String goodsId = request.getParameter("goodsId");

		Users users1 = usersService.userLogin(userName, MD5.getMD5(password), "userName");
		Users users2 = usersService.userLogin(userName, MD5.getMD5(password), "email");
		Users user = users1==null?users2:users1;
		
		if(user==null){
			writeToPage("您的用户名或者密码错误...");
		}
		else {   //登录成功，保存用户数据
			ActionContext.getContext().getSession().put("user",user);
			/*
			 * 判断type
			 * 如果type==collect，则保存用户收藏信息
			 * 如果为comment，则转到评价界面
			 */
			if("collect".equals(type)){
				/*
				 * 判断该用户是否已经收藏过该商品
				 * 没有，则保存，否则就提示已经收藏信息
				 */
				Collect collect = null;
				collect = collectService.getCollectByGoods(goodsId, user.getUserId());
				if(collect!=null){
					writeToPage("您已经收藏过该商品");
				}
				else {
					collect = new Collect();
					collect.setCollectId(ProduceId.getId());
					collect.setCollectTime(GetTime.getTime("yyyy-MM-dd hh:mm:ss"));
					collect.setGoodsListing(goodsService.getGoodsById(goodsId));
					collect.setUsers(user);
					collectService.saveCollect(collect);
					writeToPage("商品收藏成功...");
				}	
			}
			if("comment".equals(type)){
				writeToPage("评价");
			}
		}
		
		return null;
	}
	
}
