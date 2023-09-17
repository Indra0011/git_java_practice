package com.telusko.main;
import com.telusko.util.*;
import java.sql.*;
public class LaunchMain {

	public static void main(String[] args) {
		//Resources
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try
		{
			con = Utility.getConnection();
			
			if(con != null)
			{
				st = con.createStatement();
				String query = "select sid,sname,sage from studentinfo";
				rs = st.executeQuery(query);
				System.out.println("ID\tName\tage");
				while(rs.next())
				{
					System.out.println(rs.getInt("sid")+"\t"+rs.getString("sname")+"\t"+rs.getInt("sage"));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			Utility.closeResources(rs, con, st);
			
		}

	}

}
