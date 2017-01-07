package com.flipkart.domain;

import java.util.Date;
import java.util.List;

public class Order {
private int id;
private String userName;
private String orderNumber;
private Date orderDate;
private double orderAmount;
private List<Product> products=null;
public int getId() {
	return id;
}

public Order() {
	
}
public Order(int id, String userName, String orderNumber, Date orderDate, double orderAmount, List<Product> products) {
	super();
	this.id = id;
	this.userName=userName;
	this.orderNumber = orderNumber;
	this.orderDate = orderDate;
	this.orderAmount = orderAmount;
	this.products = products;
}
public void setId(int id) {
	this.id = id;
}
public void setUserName()
{
	this.userName=userName;
}
public void setOrderNumber(String orderNumber) {
	this.orderNumber = orderNumber;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public void setOrderAmount(double orderAmount) {
	this.orderAmount = orderAmount;
}
public void setProducts(List<Product> products) {
	this.products = products;
}
public String getOrderNumber() {
	return orderNumber;
}

public String getUserName() {
	return userName;
}

public Date getOrderDate() {
	return orderDate;
}
public double getOrderAmount() {
	return orderAmount;
}
public List<Product> getProducts()
{
	return products;
}

}
