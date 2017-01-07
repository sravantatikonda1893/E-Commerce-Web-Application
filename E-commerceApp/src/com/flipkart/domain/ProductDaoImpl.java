package com.flipkart.domain;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ProductDaoImpl  extends CommonBaseDao{
	
	
	
	public  List<Product> getAllProducts()
	{
		List<Product> products = new ArrayList<Product>();
		Connection con = null;
		Statement st = null;

		try {
			con=CommonBaseDao.getConnection();
			if(con!=null)
			{
				st = con.createStatement();
				String sql="select * from products1";
				ResultSet rs = st.executeQuery(sql);
				if(rs!=null)
				{

					while(rs.next())
					{
						Product prod = new Product();
						prod.setId(rs.getInt("id"));
						prod.setProdType(rs.getString("prodtype"));
						prod.setProdComp(rs.getString("prodcomp"));
						prod.setProdModal(rs.getString("prodmodal"));
						prod.setProdPrice(rs.getInt("prodprice"));
						prod.setProdImg(rs.getString("prodimg"));
						products.add(prod);

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

		return products;
	}

	
	

	public  List<Product> getProducts(String prodType, String prodComp)
	{
		List<Product> products = new ArrayList<Product>();
		Connection con = null;
		Statement st = null;

		try {
			con=CommonBaseDao.getConnection();
			if(con!=null)
			{
				st = con.createStatement();
				String sql="select * from products1 where prodtype='"+prodType+"' and prodcomp='"+prodComp+"'";
				System.out.println(sql);
				ResultSet rs = st.executeQuery(sql);
				if(rs!=null)
				{

					while(rs.next())
					{
						Product prod = new Product();
						prod.setId(rs.getInt("id"));
						prod.setProdType(rs.getString("prodtype"));
						prod.setProdComp(rs.getString("prodcomp"));
						prod.setProdModal(rs.getString("prodmodal"));
						prod.setProdPrice(rs.getInt("prodprice"));
						prod.setProdImg(rs.getString("prodimg"));
						products.add(prod);

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

		return products;
	}

	public Product		findByPrimaryKey(int product_id)
	{
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs=null;
		Product prod = new Product();
		try {
			con=getConnection();
			if(con!=null)
			{
			String sql=	"select * from products1 where id=?";
			System.out.println(sql);
			st = con.prepareStatement(sql);

				st.setInt(1, product_id);
				rs= st.executeQuery();
				if(rs!=null)
				{

					while(rs.next())
					{

						//					prod.setId(rs.getInt("id"));
						prod.setProdType(rs.getString("prodtype"));
						prod.setProdComp(rs.getString("prodcomp"));
						prod.setProdModal(rs.getString("prodmodal"));
						prod.setProdPrice(rs.getInt("prodprice"));
						prod.setProdImg(rs.getString("prodimg"));
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
		return prod;
	}
	public List<Product> getByOrderId(int orderId) throws ClassNotFoundException
	{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement st=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		List<Product> products= new ArrayList<>();
		try {
			con=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oms","system");	
			if(con!=null)
			{

				String sql="select   p.id,p.prodtype,p.prodmodal, p.prodprice"+
						"from  	  order_details od, products1 p"+
						"where    od.order_id=p.order_id"+
						"and od.order_id=?";

				st = con.prepareStatement(sql);
				st.setInt(1, orderId);
				rs = st.executeQuery();

				if(rs!=null)
				{

					while(rs.next())
					{
						Product product=new Product();
						product.setId(rs.getInt("pid"));
						product.setProdModal(rs.getString("prodtype"));
						product.setProdPrice(rs.getDouble("prodprice"));
						product.setProdModal(rs.getString("prodmodal"));
						products.add(product);
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


		return products;
	}
}

