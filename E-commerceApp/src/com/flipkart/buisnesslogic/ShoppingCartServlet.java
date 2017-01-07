package com.flipkart.buisnesslogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flipkart.domain.Product;
import com.flipkart.domain.ProductDaoImpl;

public class ShoppingCartServlet extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//	Gettting id of each product selected and retrieving from db, putting in a list of products and then putting the bag in the session
		int prod_id=Integer.parseInt(request.getParameter("prod_id"));
		HttpSession session=request.getSession();
		ProductDaoImpl pd=new ProductDaoImpl();
		Product product=pd.findByPrimaryKey(prod_id);
		if(session.getAttribute("ShoppingCart")==null)
		{
			List<Product> products=new ArrayList<Product>();
			products.add(product);		
			session.setAttribute("ShoppingCart", products);
		}
		else
		{
			List<Product> products=	(List<Product>)session.getAttribute("ShoppingCart");
			products.add(product);
			session.setAttribute("ShoppingCart", products);
		}
		RequestDispatcher rd=request.getRequestDispatcher("/shoppingcartdisplay");
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

}
