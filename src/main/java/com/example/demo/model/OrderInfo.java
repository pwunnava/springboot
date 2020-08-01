package com.example.demo.model;

import java.util.List;

public class OrderInfo {
	
	
	    String orderNumber="";
		String TokenNumber="";
		String deliveryType="";
		String deliveryDate="";
		String storeNum="";
		String banner="";
		 String orderTotal="";
		 String grossTax="";
		 String grossCrv="";
		 String grossSugarTax="";
		 String grossOrderTotal="";
	List<OrderItem>orderItem;
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getTokenNumber() {
		return TokenNumber;
	}
	public void setTokenNumber(String tokenNumber) {
		TokenNumber = tokenNumber;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public List<OrderItem> getOrderItems() {
		return orderItem;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItem = orderItems;
	}
	public String getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getGrossTax() {
		return grossTax;
	}
	public void setGrossTax(String grossTax) {
		this.grossTax = grossTax;
	}
	public String getGrossCrv() {
		return grossCrv;
	}
	public void setGrossCrv(String grossCrv) {
		this.grossCrv = grossCrv;
	}
	public String getGrossSugarTax() {
		return grossSugarTax;
	}
	public void setGrossSugarTax(String grossSugarTax) {
		this.grossSugarTax = grossSugarTax;
	}
	public String getGrossOrderTotal() {
		return grossOrderTotal;
	}
	public void setGrossOrderTotal(String grossOrderTotal) {
		this.grossOrderTotal = grossOrderTotal;
	}

	
	
}
