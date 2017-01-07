package com.flipkart.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl 
{
	
	public void createCustomer(User user) throws DAOException, ClassNotFoundException 
	{
		Connection con = null;
		PreparedStatement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oms","system");
			String sql = "insert into users1 values(?,?,?,?,?,?)";
			System.out.println(sql);
			st = con.prepareStatement(sql);
			st.setString(1, user.getFirstname());
			st.setString(2, user.getLastname());
			st.setString(3, user.getEmail());
			st.setString(4, user.getUsername());
			st.setString(5, user.getPassword());
			st.setString(6, user.getMobileno());
			int no = st.executeUpdate();
			System.out.println("inserted :" + no + "row/s");

		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new DAOException("error occured", e);
		}
		finally 
		{
			try
			{
					if(st!=null)
			st.close();
					if(con!=null)
				con.close();
				}
				catch(SQLException e){
				
				}	
		}

	}		

}