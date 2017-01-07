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
public class OnClickDisplayProducts extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		 String prodType= request.getParameter("prodType");
		 String prodComp=request.getParameter("prodComp");
		 System.out.println("type="+prodType+"   comp="+prodComp);
		 RequestDispatcher rd= request.getRequestDispatcher("/header");
		rd.include(request, response);
		 ProductDaoImpl dao=new ProductDaoImpl();
		 List<Product> products= dao.getProducts(prodType, prodComp);
		for(Product product:products)
		{
			out.println("<a href=\"./displayproductdetails?id="+product.getId()+"\" ><img src=\"./images/"+product.getProdImg()+"\" /></a><br>");
		}
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
