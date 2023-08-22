package Exercise;
import java.util.Scanner;
/*
 *   Exceptions result in abnormal termination of a program at runtime like divide by 0 error.
 *   Statements after the error will not be executed in the try block, the control is moved to catch block.
 *   multiple catch blocks can be present for a single try block , but only one catch block is excecuted based on exception type
 *   
 *   When an exception arises it is given to JVM and jvm check in the stack frame if the exception is handled , if its not handled 
 *   jvm throws it to default exception handler.
 *   
 *   ducking the exception (throws keyword)
 *   re-throw an exception  (throw , throws, try, catch,finally)
 *   
 *   two types of exceptions
 *   1. unchecked - exceptions (programmer should identify and handle)
 *   2. checked- exceptions (compiler anticipates that exception could occur , if we don't want to handle it we can duck it)
 *   
 */
public class ExceptionHandling {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] nums = null;
		try
		{
			System.out.println("Enter the numerator");
			int num1 = sc.nextInt();
			System.out.println("Enter the denominator");
			int num2 = sc.nextInt();
			double result = num1/num2;
			System.out.println("The result is "+result);
			System.out.println("Enter the size of an array");
			int size = sc.nextInt();
			nums = new int[size];
			System.out.println("Enter the index and element to insert into array");
			int index = sc.nextInt();
			int ele	  = sc.nextInt();
			nums[index] = ele;
			
		}
		catch(ArithmeticException e)                                // specific catch blocks for each exception type
		{
			System.out.println(e.getMessage());
		}
		catch(NegativeArraySizeException e)
		{
			System.out.println(e.printStackTrace());                 // printStackTrace has void return type
			e.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.toString());
		}
		catch(Exception e)      // common exception parent of all exception classes which can handle all exceptions
		{
			System.out.println("Something went wrong");
		}
		
		// to keep above exceptions independent and if code has to be executed even if one funcationality has exception below structure can be followed
		try
		{
			System.out.println("Enter the numerator");
			int num1 = sc.nextInt();
			System.out.println("Enter the denominator");
			int num2 = sc.nextInt();
			double result = num1/num2;
			System.out.println("The result is "+result);
		}
		catch(ArithmeticException e)                                // specific catch blocks for each exception type
		{
			System.out.println("Enter non-zero number");
		}
		try
		{
			System.out.println("Enter the size of an array");
			int size = sc.nextInt();
			nums = new int[size];
		}
		catch(NegativeArraySizeException e)
		{
			System.out.println("Enter only postive number");
		}
		try
		{
			System.out.println("Enter the index and element to insert into array");
			int index = sc.nextInt();
			int ele	  = sc.nextInt();
			nums[index] = ele;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Be in you limits");
		}
		catch(Exception e)      // common exception parent of all exception classes which can handle all exceptions
		{
			System.out.println("Something went wrong");
		}
		
		
	}
	
	public void duckingException()throws Exception // to specify this function return's exception(exception is not handled in this method)
	{
		Thread.sleep(5000);        // if throws Exception is not present compiler gives error at this line(checked-exception)
	}

}
