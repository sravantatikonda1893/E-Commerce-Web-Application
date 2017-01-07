package com.flipkart.buisnesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipkart.domain.Product;
import com.flipkart.domain.ProductsDetails;

public class DisplayProductDetails extends HttpServlet  {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		ProductsDetails pd=new ProductsDetails();
		RequestDispatcher rd= request.getRequestDispatcher("/header");
		rd.include(request, response);
		
		int prod_id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id in display prod details="+prod_id);
		
		Product product = pd.getProductDetails(prod_id);
		
		
		out.println(" <html>");
		out.println("<body>");
	out.println("<img height=\"200\", width=\"180 \" src=\"./images/"+product.getProdImg()+" \" />");
	out.println("<h1> Quantity Available :"+product.getProdAvailable()+"</h1>");
	out.println("<h2> Price :"+product.getProdPrice()+"</h2>");
	out.println("<h3> Model :"+product.getProdModal()+"</h3>");
//	System.out.println("<a href=\"/flipkart/cart?prod_id=/"+product.getId()+">Add To Cart</a>");
	out.println("<a href=\"/flipkart/cart?prod_id="+product.getId() +"\">Add To Cart</a>");
	out.println("</body>");
	out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

}
