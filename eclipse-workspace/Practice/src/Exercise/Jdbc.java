package Exercise;
/*
 * 1. import packages
 * 2. download jar files from db vendor sites(required to connect to specific db)
 * 3. load and register driver in java(java project -> properties -> java build path -> libraries -> add external jar)
 * 4. establish connection
 * 5. create prepared statement for querying
 * 6. execute query 
 * 7. process results from above step
 * 8. close connection(resources)
 */
import java.sql.*;
public class Jdbc {

	public static void main(String[] args)throws Exception { // ducking exception
		
		// load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver"); // mandatory address of driver implementation to be provided here.
		
		// Establish connection
		String url = "jdbc:mysql://localhost:3306/teluskodb";
		String userName = "Indra";
		String password = "Indra@123";
		
		Connection con = DriverManager.getConnection(url, userName, password);
		
		// create statement object - to write query
		Statement statement = con.createStatement();
		
		//execute the query
		String query = "select sid,sname,sage,saddress from studentinfo";
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next())
		{
			int id = rs.getInt(1); 
			System.out.println("Student ids are : "+id+"\t" + rs.getString("sname")+"\t" +rs.getInt("sage"));
		}
		
		// non select query 
		
		String query1 = "insert into studentinfo(sid,sname,sage,saddress) values (4,'tejas',24,'kammanahalli')";
		int rowsEffected = statement.executeUpdate(query1);
		if(rowsEffected == 1)
		{
			System.out.println("data inserted successfully");
		}
		
		String query2 = "Delete from studentinfo where sid =4";
		rowsEffected = statement.executeUpdate(query2);
		
		String query3 = "update studentinfo set sage = 30 where sid = 3";
		rowsEffected = statement.executeUpdate(query3);
		
		
		//close the resources
		rs.close();
		statement.close();
		con.close();
		
		
		

	}

}
