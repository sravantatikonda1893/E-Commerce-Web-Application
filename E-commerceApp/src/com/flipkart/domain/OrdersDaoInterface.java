package com.flipkart.domain;

import java.util.List;

public interface OrdersDaoInterface {
	void createOrder(String username,Order order) throws DAOException, ClassNotFoundException;
	List<Order>  getOrders(int customer_id) throws ClassNotFoundException;
	
	
	
	
	

}
