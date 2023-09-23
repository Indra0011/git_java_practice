package com.telusko.main;
import com.telusko.util.*;
import java.sql.*;
import java.util.*;
public class LaunchMain {

	public static void main(String[] args) {
		//Resources
		Connection con = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Scanner sc = null;
		
		try
		{
			con = Utility.getConnection();
			
			if(con != null)
			{
				
				//++ using prepared statement(precompiled query, better performance compared to statement)
				//, this is a child of statement , thats the reason when we pass prepared statement to statement reference for closing there is no error
				String Query1  = "INSERT into studentinfo(sid,sname,sage,saddress) values (?,?,?,?)"; // dynamic values can be passed.
				pst = con.prepareStatement(Query1) ;  // query has to be passed when creating the statement,unlike createStatement.
				if(pst != null)
				{
					sc = new Scanner(System.in);
					System.out.println("Enter your id");
					int id = sc.nextInt();
					System.out.println("enter your name");
					String name = sc.next();
					System.out.println("enter your age");
					int age = sc.nextInt();
					System.out.println("enter your address");
					String address = sc.next();
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setInt(3, age);
					pst.setString(4, address);
					
					pst.addBatch(); // adding query to batch (execute batch)
					
					pst.setInt(1, id+1);
					pst.setString(2, name);
					pst.setInt(3, age);
					pst.setString(4, address);
					
					pst.addBatch();
					
					int batch[] = pst.executeBatch(); // executes above two queries with multiple value at once through execute batch
					
					boolean rowsAffected = pst.execute();
					if(rowsAffected)
					{
						rs = pst.getResultSet(); // to get the result set
						int count = pst.getUpdateCount(); // to get number of rows affected
						System.out.println("Data is inserted through prepared statement");
					}
					else
					{
						System.out.println("Data insertion failed through prepared statement");
					}
					
				}
				// -- prepared statement
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
			Utility.closeResources(rs,con,pst);
			
		}

	}

}
