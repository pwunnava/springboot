package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Test {
	
	
	public  static void main(String[] args)
	{
		Order order1= new Order();
		Order order2= new Order();
		Order order3= new Order();
		Order order5= new Order();
		Order order4= new Order();
		
		List<Order> lst =new ArrayList<Order>();
		
		lst.add(order1);
		lst.add(order2);
		lst.add(order3);
		lst.add(order4);
		lst.add(order5);
		
		Orders ords =new Orders();
		ords.setLstOrders(lst);
		
		  //System.out.println(new Gson().toJson(ords)); 
		
		
		
		//OrderDetails orderDetails=new OrderDetails();
		
		OrderInfo orderDetails=new OrderInfo();
		
		
		/////////////////
		//OrderInfo orderInfo = new OrderInfo();
		List<OrderItem>orderItem =new ArrayList<OrderItem>();
		OrderItem orderItems1_1 = new OrderItem();
		OrderItem orderItems1_2 = new OrderItem();
		OrderItem orderItems1_3 = new OrderItem();
		OrderItem orderItems1_4 = new OrderItem();
		
		orderItem.add(orderItems1_1);
		orderItem.add(orderItems1_2);
		orderItem.add(orderItems1_3);
		orderItem.add(orderItems1_4);
		
		orderDetails.setOrderItems(orderItem);
		
		System.out.println(new Gson().toJson(orderDetails)); 
		
		
		GetOrders gg=new GetOrders();
		gg.setGuid("556-129-1585051925719");
		
		System.out.println(new Gson().toJson(gg)); 
	}

}
