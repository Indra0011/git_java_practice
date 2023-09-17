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
 *   finally will be executed even though the exception is not handled using the catch block or even if exception does not occur.
 *   if exception occurs in the finally block , it should be handled using try catch in finally block.
 *   if exception occurs in catch block still the finally is also executed.
 *   even if return statement is present in try and catch block finally block is executed.
 *   when System.exit(0) is present  in try and catch then finally is not executed as jvm it self is turned off and stops complete execution.
 *   
 *   under throw statement if any statement is written then compilation issue will occur as these statements will never execute
 *   only catch and finally can be present.
 *   
 *   to throw a custom class instead of exception type class it is not possible(compile error) , we can extend our custom class with exception/throwable and throw that
 *   
 *   nested try catch for ATM scenario using custom exceptions to throw	
 *   
 *   without catch only try and finally can also be present.	
 */
class ExceptionHandling2 {
	
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
		//	System.out.println(e.printStackTrace());                 // printStackTrace has void return type
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

public class ExceptionHandling5
{
	public static void main(String[] args)
	{
		ExceptionHandling3 except = new ExceptionHandling3();
		try
		{
			except.alpha();
		}
		catch(Exception e)
		{
			System.out.println("Handled in main method");    // both catch block is also executed as we are throwing back again in the alpha method.
		}
		
		
	}
	
}

class ExceptionHandling3
{
	public void alpha()throws Exception // since we are throwing an exception it is better to inform in the signature.(either using throw keyword or unhandled exception is thrown)
	{
		try
		{
			int result = 1/0;
		}
		catch(Exception e)
		{
			System.out.println("Exception handled in alpha");
			throw e;       // will send this exception to caller method.
		}
		finally        // even though throw is present in catch block finally will be executed and then exeception is thrown
		{
			System.out.println("this is not executed");  // this is not executed as we are throwing the exception in catch block.(if specified under finally it will be executed.
		}
	}
	
	
}

class ExceptionHandling  // custom exceptions
{
	public static void main(String[] args)
	{
		try
		{
			ThrowCustomException throwing = new ThrowCustomException();
			throwing.customException();
			throwing.UnderAgeException();
		}
		catch(InvalidCustomerException | UnderAgeException  e)
		{
			System.out.println(e.getMessage());
		}	
	}
}

class ThrowCustomException	
{
	public void customException()throws InvalidCustomerException
	{
		throw new InvalidCustomerException("Custom invalid customer exception"); // parameter can be provided as constructor is defined in custom exception
	}
	
	public void UnderAgeException() throws UnderAgeException
	{
		throw new UnderAgeException();
	}
}

class InvalidCustomerException extends Exception         // custom exception class, without extending we cannot throw this class
{
	/*
	@Override
	public String getMessage()
	{
		return "Custom Exception getmessage";
	}
	*/
	
	public InvalidCustomerException(String msg)
	{
		super(msg);
	}
}

class UnderAgeException extends Exception
{
	
}