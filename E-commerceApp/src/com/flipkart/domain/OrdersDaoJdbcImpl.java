package com.flipkart.domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDaoJdbcImpl implements OrdersDaoInterface
{
	Connection con = null;
	PreparedStatement st = null;
	
	public void createOrder(String uname, Order order) throws DAOException, ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		List<Order> orders=new ArrayList<>();
		int orderId=0;
		try {
			con=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oms","system");	
			if(con!=null)
			{
				String sql = "insert into orders values(?,?,?,?,?)";
				st = con.prepareStatement(sql);
				st.setInt(1, orderId);
				st.setString(2,order.getUserName());
				st.setString(3,order.getOrderNumber() );
				st.setDate(4, new Date(order.getOrderDate().getTime()));
				st.setDouble(5, order.getOrderAmount());
				int no = st.executeUpdate();
				System.out.println("rows inserted"+no);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		insertIntoOrderDetails(orderId,order);

	}

	private void insertIntoOrderDetails(int orderId,Order order) throws ClassNotFoundException, DAOException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		List<Order> orders=new ArrayList<>();
		try {
			con=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oms","system");	
			String sql="insert into order_details values(1,?,?)";	
			List<Product> products=order.getProducts();
			for(Product product:products)
			{
				st=con.prepareStatement(sql);
				st.setInt(1, orderId);
				st.setInt(2, product.getId());
				st.executeUpdate();
			}
		}
		catch(SQLException e)
		{
			throw new DAOException("Error occured while adding order into created order", e);

		}

	}
	public List<Order> getOrders(int customerId) throws ClassNotFoundException

	{
		ResultSet rs=null;
		Statement st=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		List<Order> orders= new ArrayList<>();
		ProductDaoImpl dao=new ProductDaoImpl();
		try {
			
			con=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oms","system");	
			if(con!=null)
			{
				st = con.createStatement();
				String sql="select * from orders where id="+customerId;
				rs = st.executeQuery(sql);
				if(rs!=null)
				{

					while(rs.next())
					{
						Order order = new Order();
						order.setId(rs.getInt("id"));
						order.setOrderNumber(rs.getString("ORDER_NUMBER"));
						order.setOrderDate(rs.getDate("ORDER_DATE"));
						order.setOrderAmount(rs.getDouble("ORDER_AMOUNT"));
						List<Product> products=dao.getByOrderId(rs.getInt("id"));
						order.setProducts(products);
						orders.add(order);
					}
					rs.close();
				}
				st.close();
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return orders;
	}

	
}
