package com.flipkart.buisnesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipkart.domain.DAOException;
import com.flipkart.domain.User;
import com.flipkart.domain.UserDaoImpl;

/**
 * Servlet implementation class signup
 */
public class SignUpServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String mobileno=request.getParameter("mobileno");
		User user=new User(firstname,lastname,email,username,password,mobileno);
		UserDaoImpl dao=new UserDaoImpl();
		try {
			dao.createCustomer(user);
			out.println("You have signedup successfully");
			RequestDispatcher rd=request.getRequestDispatcher("/");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		
	}

}
