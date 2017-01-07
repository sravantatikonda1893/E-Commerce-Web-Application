package com.flipkart.buisnesslogic;
import java
.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flipkart.domain.DAOException;
import com.flipkart.domain.Order;
import com.flipkart.domain.OrdersDaoInterface;
import com.flipkart.domain.OrdersDaoJdbcImpl;
import com.flipkart.domain.Product;
public class CheckoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		List<Product> products=(List<Product>)session.getAttribute("ShoppingCart");
		double orderTotal=calculateOrderAmount(products);
		String orderNumber =UUID.randomUUID().toString();
		String userName=(String)session.getAttribute("UserName");
		Order order=new Order(0, userName,orderNumber, new Date(), orderTotal, products);
		OrdersDaoInterface odi=new OrdersDaoJdbcImpl();
		try {
			odi.createOrder( userName,order);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DAOException e) 
		{
			e.printStackTrace();
		}
		request.setAttribute("Order", order);
		RequestDispatcher rd=request.getRequestDispatcher("/flipkart/orderdisplay");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	
	}
//	calculating order total
double calculateOrderAmount(List<Product>products)
{	double tot=0.0;
for(Product p:products){
	tot+=p.getProdPrice();
}
 	
	return tot;
}
}
