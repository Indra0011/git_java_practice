package com.telusko.util;
import java.sql.*;
public class Utility {

	static // executed when class is loaded by jvm (class loader subsystem)
	{
		// load and register driver
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Driver registered successfully");
		
	}
	
	public static Connection getConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/teluskodb";
		String userName = "Indra";
		String password = "Indra@123";
		
		return DriverManager.getConnection(url,userName,password);
		
	}
	public static void closeResources(ResultSet rs,Connection con,Statement st)
	{
		try {
			if(rs != null)
				rs.close();
			if(con != null)
				con.close();
			if(st != null)
				st.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}
