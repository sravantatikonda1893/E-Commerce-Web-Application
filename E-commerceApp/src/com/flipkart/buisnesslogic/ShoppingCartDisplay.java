package com.flipkart.buisnesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flipkart.domain.Product;
public class ShoppingCartDisplay extends HttpServlet

{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		PrintWriter p=response.getWriter();
		RequestDispatcher rd= request.getRequestDispatcher("/header");
		rd.include(request, response);	 
		String id=request.getParameter("prod_id");
//		int id=Integer.parseInt(id);
		System.out.println("id from shoppingcart display="+id);
		p.println("<html>");
		p.println("<head>");
				p.println("</head>");
		p.println("<body>");
		
		p.println(" <table border=1>");
		p.println("<tr>");
		p.println("<th>Name<th>");
		p.println("<th>Type<th>");
		p.println("<th>Price<th>");
		p.println("</tr>");
		HttpSession session=request.getSession();
		List<Product> products=(List<Product>)session.getAttribute("ShoppingCart");
		
		for(Product prod: products)
		{
			p.println("<tr>");
			p.println("<td>"+prod.getProdModal()+"</td>");
			p.println("<td>"+prod.getProdType()+"</td>");	
			p.println("<td>"+prod.getProdPrice()+"</td>");
			p.println("</tr>");
		}
		p.println("<h1>Do you wanna shop more?</h1>");
		p.println("<h2>Click <a href=\"./home\">Here</a></h2>" );
		p.println("<h2>If you are done shopping, Click<a href=\"./checkout?prod_id="+id+"\">Here</a></h2>" );
		p.println("</body>");
		p.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

}
