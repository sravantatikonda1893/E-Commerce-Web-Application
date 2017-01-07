package com.flipkart.buisnesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flipkart.domain.Product;
public class Header extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

PrintWriter out=response.getWriter();
int size=0;
HttpSession session=request.getSession();
List<Product> cart=	(List<Product>)session.getAttribute("ShoppingCart");
if(cart!=null)
{	size=cart.size();
for(Product p:cart)
	System.out.println("size:" +size);
System.out.println(size);
}	
out.println(" <html>");
out.println("<head> ");
out.println("<title>Online Stores</title>");
out.println("<style>");
out.println(".dropbtn { background-color: blue; color: white; padding: 16px; padding-top: 8px; padding-bottom: 8px; font-size: 16px;");
out.println("  border: none; cursor: pointer;}.dropdown {  position: relative; ");
out.println( "display: inline-block;} .dropdown-content {   display: none;   position: absolute;  background-color: lightblue;"+"  min-width: 160px;    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);}");
out.println(" .dropdown-content a { color: black; padding: 12px 16px; text-decoration: none; display: block; }.dropdown-content a:hover {background-color: #f1f1f1}");
out.println(" .dropdown:hover .dropdown-content { display: block; }.dropdown:hover .dropbtn {    background-color: lightblue;}</style> </head>");
out.println(" <body>");
out.println(" <table style=\"width:100%;\"> <tr style=\"background: blue; text-align: right;\"> <td colspan=\"3\"> <a href=\"./SignUp.html\" style=\"color: white;\">Sign Up</a> &nbsp; &nbsp; ");
out.println("<a href=\"./login.html\" style=\"color: white;\">Log in</a> </td></tr><tr style=\"background: blue;\"> <td width=\"15%\" style=\"text-align: center;\">");
out.println(" <div style=\"color: white; font-size: 22px; padding-top: 5px; padding-bottom: 5px;\">Online Stores</div> </td><td width=\"70%\">"); 
out.println("<input type=\"text\" style=\"width: 90%;\" /> </td> <td width=\"15%\" style=\"text-align:center;\"> <a href=\"./cart\"><img height=38 width=25 src=\"./images/cart.png\">("+size+")</a></td> </tr> <tr style=\"background: blue;\">");
out.println(" 	<td></td>	<td>	<div class=\"dropdown\">	  <button class=\"dropbtn\">Mobiles</button> <div class=\"dropdown-content\"> <a href=\"./onclickdisplayproducts?prodType=mobile&prodComp=apple\">Apple</a>");
out.println(" <a href=\"./onclickdisplayproducts?prodType=mobile&prodComp=samsung\">Samsung</a>  <a href=\"./onclickdisplayproducts?prodType=mobile&prodComp=nokia\">Nokia</a></div>");
out.println("</div>	<div class=\"dropdown\">	  <button class=\"dropbtn\">Laptops</button>	  <div class=\"dropdown-content\">    <a href=\"./onclickdisplayproducts?prodType=laptop&prodComp=lenovo\">Lenovo</a>	    <a href=\"./onclickdisplayproducts?prodType=laptop&prodComp=hp\">HP</a>");
out.println("<a href=\"./onclickdisplayproducts?prodType=laptop&prodComp=dell\">Dell</a>  </div> </div>	<div class=\"dropdown\">	  <button class=\"dropbtn\">TVs</button>	  <div class=\"dropdown-content\">");
out.println("  <a href=\"./onclickdisplayproducts?prodType=tv&prodComp=samsung\">Samsung</a>	    <a href=\"./onclickdisplayproducts?prodType=tv&prodComp=lg\">LG</a>    <a href=\"./onclickdisplayproducts?prodType=tv&prodComp=sony\">Sony</a>");
out.println(" </div> 	</div> <div class=\"dropdown\"> <button class=\"dropbtn\">Cameras</button> <div class=\"dropdown-content\"> 	    <a href=\"./onclickdisplayproducts?prodType=camera&prodComp=sony\">Sony</a> <a href=\"./onclickdisplayproducts?prodType=camera&prodComp=canon\">Canon</a>");
out.println(" <a href=\"./onclickdisplayproducts?prodType=camera&prodComp=nikon\">Nikon</a>  </div></div></td>	<td></td></tr><tr><td></td><td><td><td></td></tr></table></body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

}
