package com.shop.action.prosceniums;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.common.ProduceId;
import com.shop.domain.GoodsListing;
import com.shop.domain.ShoppingCar;
import com.shop.domain.Users;
import com.shop.service.GoodsService;
import com.shop.service.ShoppingCarService;

@Controller("shoppingCarAction")
public class ShoppingCarAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="goodsService")
	private GoodsService goodsService;
	@Resource(name="shoppingCarService")
	private ShoppingCarService shoppingCarService;
	
	/**
	 * 添加商品到购物车
	 */
	@SuppressWarnings("unchecked")
	public void addGoods(){
		//获取提交信息
		String goodsId = request.getParameter("goodsId");                 //商品编号
		String goodsColor = request.getParameter("goodsColor");           //商品颜色
		String goodsAttr = request.getParameter("goodsAttr");             //商品属性
		String goodsNumber = request.getParameter("goodsNumber");         //商品数量
		/*
		 * 获取购物车
		 * 如果购物车为null,则new
		 * 购物车以map形式存在：map<carId,shoppingCar>
		 * carId=goodsId+goodsColor+goodsSize
		 */
		HttpSession session = request.getSession();
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) session.getAttribute("mapCar");
		if(mapCar==null){       //为空则新建
			mapCar = new HashMap<String, ShoppingCar>();
		}
		
		/*
		 * 如果购物车中包含该商品，则只需要叠加数量即可
		 */
		ShoppingCar shoppingCar = null;
		String carId = goodsId+goodsColor+goodsAttr;//购物车编号
		if(mapCar.containsKey(carId)){      //存在该商品，商品数量叠加
			shoppingCar = mapCar.get(carId);  
			shoppingCar.setGoodsNumber(shoppingCar.getGoodsNumber()+Integer.valueOf(goodsNumber));
		}
		else {
			shoppingCar = new ShoppingCar();
			shoppingCar.setCarId(ProduceId.getId());
			shoppingCar.setGoodsColor(goodsColor);
			shoppingCar.setGoodsNumber(Integer.valueOf(goodsNumber));
			shoppingCar.setGoodsAttr(goodsAttr);
			//获取该商品
			GoodsListing goods = goodsService.getGoodsById(goodsId);
			shoppingCar.setGoodsListing(goods);
		}
			
		/*
		 * 如果用户存在,即已经登陆，将购物车添加到该用户名下
		 */
		Users users = (Users) session.getAttribute("user");
		if(users!=null){
			shoppingCar.setUsers(users);        
			//将购物车添加到该用户名下,进行map迭代操作
			for(Entry<String , ShoppingCar> sc:mapCar.entrySet()){
				ShoppingCar mycar = sc.getValue();
				mycar.setUsers(users);
			}
		}
		
		//将购物车添加到map中
		mapCar.put(carId, shoppingCar);

		//用户存在，保存到数据库
		if(users!=null){
			for(Entry<String, ShoppingCar> sc :mapCar.entrySet()){
				ShoppingCar mycar = sc.getValue();
				shoppingCarService.updateOrSave(mycar);
			}
		}
		
		session.setAttribute("mapCar", mapCar);         //更新session
		int countNumber = mapCar.size();
		float sum = this.carSum(mapCar);
		//保存购物车信息
		String returnData = String.valueOf(countNumber+","+sum);
		
		//返回数据
		this.writeToPage(returnData);

	}
	
	/**
	 * 查看购物车
	 */
	@SuppressWarnings("unchecked")
	public String showCar(){
		//获取购物车
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) session.getAttribute("mapCar");
		//计算总金额
		double sum = 0;
		for(Entry<String, ShoppingCar> mycar:mapCar.entrySet()){
			ShoppingCar car =mycar.getValue();
			sum = sum+car.getGoodsListing().getGoodsMarketPrice()*car.getGoodsNumber();
		}
		ActionContext.getContext().put("sum", sum);
		ActionContext.getContext().put("car", mapCar);
		ActionContext.getContext().put("carSize", mapCar.size());
		ActionContext.getContext().put("type", "showCar");
		return "showCar";
	}
	
	/**
	 * 修改购物车
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String updateCar(){
		//获取购物车参数：购物车编号，商品数量
		String carId = request.getParameter("carId");
		String number = request.getParameter("number");
		//获取购物车
		HttpSession session = request.getSession();
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) session.getAttribute("mapCar");
		ShoppingCar car = mapCar.get(carId);
		car.setGoodsNumber(Integer.valueOf(number));
		mapCar.put(carId, car);
		
		//保存在数据库
		for(Entry<String, ShoppingCar> sc :mapCar.entrySet()){
			ShoppingCar mycar = sc.getValue();
			shoppingCarService.updateOrSave(mycar);
		}
		
		session.setAttribute("mapCar", mapCar);        //更新数据库
		
		float sum = this.carSum(mapCar);
		this.writeToPage(String.valueOf(sum));
		return null;
	}
	
	/**
	 * 在购物车中删除某商品
	 * 先在数据库中删除，然后再map中删除
	 * @param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String deleteGoods(){
		//获取该商品参数
		String carId = request.getParameter("carId");
		
		//获取购物车
		HttpSession session = request.getSession();
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) session.getAttribute("mapCar");
		
		//如果用户存在在数据库中也要删除这条记录
		Users user = (Users) session.getAttribute("user");
		if(user!=null){
			shoppingCarService.deleteCar(mapCar.get(carId));
		}
		
		mapCar.remove(carId);
		
		session.setAttribute("mapCar", mapCar);
		
		float sum = this.carSum(mapCar);
		this.writeToPage(String.valueOf(sum));
		return null;
	}
	
	/**
	 * 计算购物车的总金额
	 */
	public float carSum(Map<String, ShoppingCar> mapCar){
		float sum = 0;               //购物车总价格
		for(Entry<String, ShoppingCar> nc : mapCar.entrySet()){
			ShoppingCar myCar = nc.getValue();
			sum = sum+myCar.getGoodsNumber()*myCar.getGoodsListing().getGoodsMarketPrice();
		}
		return sum;
	}
	
	/**
	 * 向客户端传递数据
	 */
	public void writeToPage(String sum){
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(String.valueOf(sum));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
