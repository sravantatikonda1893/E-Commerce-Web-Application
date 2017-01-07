package com.flipkart.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommonBaseDao {
	
	public static Connection getConnection() throws SQLException 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oms","system");
	}
protected void closingResources(ResultSet rs, Statement st, Connection con)
{
	try{
		if(rs!=null)
	rs.close();
		if(st!=null)
st.close();
		if(con!=null)
	con.close();
	}
	catch(SQLException e){
	
	}	

}
}
