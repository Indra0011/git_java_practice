package Exercise;
/*
 * ENUM		- predefined grouped constants are specified in enum
 * enum can contain variables constructors and methods
 * 
 * based on number of constants in the enum , the constructor is executed so many number of times
 * by default every enum extends the enum class
 * class Result extends enum( a class is created when an enum is created in the backend)
 * {
 * 
 * }
 * 
 * 
 */


enum Days
{
	MON,TUE,WED,THU,SAT,SUN;                   // these are of type Days , without specifying datatype it allows in enum
}

enum Result
{
	PASS,FAIL,NR;
	
	//backend jvm creates this below for all the constants in result
	//public static final Result PASS = new Result();   // this is the reason constructor is called 3 times in this case(due to
	// three constants in enum
	
	private int marks;
	Result()
	{
		System.out.println("Constructor in enum");
	}
	void setMarks(int marks)
	{
		this.marks	= marks;
	}
	int getMarks()
	{
		return this.marks;
	}
}

public class EnumsDemo {

	public static void main(String[] args) {
		
		enum Resut                      // enum can also be created inside a class 
		{
			PASS,FAIL,NR;
		}
		
		final int AGE = 10;
		
		Days day = Days.MON;	// data type is of type Days 
		
		System.out.println(day);
		
		int index	= Days.WED.ordinal(); // gives the index of the value in enum.
		
		System.out.println(index);
		
		
		Days[]  days= Days.values();   // returns all the values of a Days enum as an array
		for(Days d:days)               //  
		{
			
			System.out.println("Days in a week "+d);
		}
		
		Result.PASS.setMarks(35);                
		
		int m1  = Result.PASS.getMarks();
		int m2	= Result.FAIL.getMarks();
		
		System.out.println("marks 1 and 2 "+m1 +" " + m2);
		
		// switch case with enums
		Result res =Result.PASS;
		switch(res)
		{
			case	PASS:
				System.out.println("Pass");
				break;
			case	FAIL:
				System.out.println("Fail");
				break;
			case NR:
				System.out.println("No result");
				break;
		}
		
		
	}

}
