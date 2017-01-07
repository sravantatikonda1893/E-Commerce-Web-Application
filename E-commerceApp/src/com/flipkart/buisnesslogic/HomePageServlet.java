package com.flipkart.buisnesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipkart.domain.Product;
import com.flipkart.domain.ProductDaoImpl;

public class HomePageServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
	 RequestDispatcher rd= request.getRequestDispatcher("/header");
	rd.include(request, response);
//	for jsp code
//	<jsp:include page="page path"/>
//	<@include file="pagepath"/>
	 ProductDaoImpl dao=new ProductDaoImpl();
	 List<Product> products= dao.getAllProducts();
	for(Product product:products)
	{
		out.println("<a href=\"./displayproductdetails?id="+product.getId()+"\" ><img  src=\"./images/"+product.getProdImg()+"\" /></a><br>");
	}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}
