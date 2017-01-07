package com.flipkart.buisnesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipkart.domain.Order;

/**
 * Servlet implementation class OrderDisplayServlet
 */
public class OrderDisplayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter pw=response.getWriter();
RequestDispatcher rd= request.getRequestDispatcher("/header");
rd.include(request, response);
Order order=(Order)request.getAttribute("Order");
pw.println("<h1>Your order has been placed!</h1>");
pw.println("<p>And, your order number is:"+order.getOrderNumber()+"</p>");
pw.println("<h2>Use this for further communication</h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
