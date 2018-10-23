package com.paixie.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 500001 
 * @author Administrator
 *
 */
public class OrderState implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private String orderStateId;                 //¶©µ¥×´Ì¬±àºÅ
	private String orderStateName;               //¶©µ¥×´Ì¬Ãû³Æ 
	private Set<OrderState> orderStates = new HashSet<OrderState>();       //¶©µ¥
	
	public OrderState(){
	}
	
	public OrderState(String orderStateId){
		this.orderStateId = orderStateId;
	}
	
	public OrderState(String orderStateId,String orderStateName,Set<OrderState> orderStates){
		this.orderStateId = orderStateId;
		this.orderStateName = orderStateName;
		this.orderStates = orderStates;
	}

	public String getOrderStateId() {
		return orderStateId;
	}

	public void setOrderStateId(String orderStateId) {
		this.orderStateId = orderStateId;
	}

	public String getOrderStateName() {
		return orderStateName;
	}

	public void setOrderStateName(String orderStateName) {
		this.orderStateName = orderStateName;
	}

	public Set<OrderState> getOrderStates() {
		return orderStates;
	}

	public void setOrderStates(Set<OrderState> orderStates) {
		this.orderStates = orderStates;
	}
	
}
