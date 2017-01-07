package com.flipkart.buisnesslogic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException 
	{
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		Connection con = null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oms","system");
			st = con.createStatement();
			String sql="select username from users where username ='"+username+"' and password = '"+password+"'";
			rs = st.executeQuery(sql);
			while (rs.next()) { 
				username = rs.getString("username");
			}

			if(username!= null)
			{
				System.out.println("login success..");
				HttpSession session=request.getSession();
				session.setAttribute("UserName", username);
			}
			//			For displaying products in the home page immediately after user logging in--
			RequestDispatcher rd=request.getRequestDispatcher("/");
			rd.forward(request, response);
		}

		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if(st!=null)
					st.close();
				if(rs!=null)
					rs.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}	
		}
	}


}

