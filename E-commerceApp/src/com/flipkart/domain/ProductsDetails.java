package com.flipkart.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductsDetails extends CommonBaseDao 
{

	public Product getProductDetails(int prod_id)
	{
		int prodAvailable=0;
		String prodImg="";
		double prodPrice=0.0;
		String prodModal="";
		Product prod=new Product();
		Connection con = null;
		Statement st = null;
		ResultSet rs=null;
				try {
				    con=getConnection();
				    if(con!=null)
				    {
						st = con.createStatement();
//						System.out.println("retrieved id:"+prod_id);
						String sql="select * from products1 where id="+prod_id;
						System.out.println(sql);
						 rs= st.executeQuery(sql);
					    if(rs!=null)
					    {while(rs.next()){
					    	prod.setId(prod_id);
					    	prod.setProdAvailable(rs.getInt("prodAvailable"));
							prod.setProdImg(rs.getString("prodImg"));
							prod.setProdPrice(rs.getDouble("prodPrice"));
							prod.setProdModal(rs.getString("prodModal")); 
							
							}
					    }							
							rs.close();
					    }
						st.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				} finally {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
		return prod;
}
	
}