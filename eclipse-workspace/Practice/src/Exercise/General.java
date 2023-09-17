package Exercise;
import java.util.Date;

import java.time.*;
public class General {

	public static void main(String[] args) {
		//Date and Time , are present in both util and sql package
		
		Date date = new Date();
		System.out.println(date); // will give date time and region (toString method is overridden)
		System.out.println(date.getDay()); // this method is deprecated.
		
		int time = (int) date.getTime();
		java.sql.Date d = new java.sql.Date(time); // instead of importing we can directly use from package
		
		System.out.println(d); // gives only date
		
		
		// above some methods are deprecated. , there is new package java.time which is new
		// java.time package classes does not have any constructor , so we cannot create object of that class ,
		// we can use only static methods
		
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		System.out.println(ld.getDayOfMonth());
		System.out.println(ld.getMonth());
		System.out.println(ld.getDayOfYear());
		
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		
		
		var num = 10; // generic data type 
		var values = new int[10];
		values[0] = 10;
		
		record student(int rollno,String name,String subject) // instead of creating separate class for this data we can use this in new java version
		{
		
			
		}
		
		student s1 = new student(10,"indra","java");
		/*
		sealed class Z permits b  // to permit only specified subclass which can extend this class 
		{
			
		}
		
		class b extends Z
		{
			
		}
		class d extends Z
		{
			
		}
		*/
		 int alarm = 0;
		switch("mon")
		{
		case "sat","mon" -> alarm = 9;  // in this syntax break is not required
		};
		
		alarm = switch("sat")
				{
		case "sun","sat" -> 9;             // if case matches then 9 is assigned to alarm.
		default -> 0;
				};
		
		
	}

}
