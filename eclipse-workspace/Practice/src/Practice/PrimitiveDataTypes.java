package Practice;

public class PrimitiveDataTypes {
	
	// 
	public static void main(String args[])
	{
		char character = 'A'; //2 bytes
		byte bytedata  = 100; //1 byte
		short dateOfBirth = 23; // 2 bytes
		int year = 1998; // 4 bytes - default conversion of compiler when arthimatic operations are performed like byte + int -> int
		long longnumber = 324343434l; // 8 bytes l is required at the end when number is too long 
		float temperature = 36.5f; // 4 bytes
		double fahrenheit = 100.5; // 8 bytes
		boolean amIRight  = true;
				
		// implicit conversion type casting
		
		float division = 25/2;
		System.out.println("division "+division);
		
		float num1 = 25;
		float num2 = 26;
		System.out.println(num1/num2);
		
		float num3 = 27.4f;
		double num4 = 21;
		System.out.println(num3/num4);
	
		double  a = 45.7777;
		byte b;
		b = (byte)a; // explicit type casting from higher data type to lower data type
		System.out.println("explicit byte "+b);
		
		char char1 = 'A';
		int c;
		c = char1;				// implicit type casting
		System.out.println(c);
		
		int d = 67;
		char explicit;
		explicit = (char)d;
		System.out.println(explicit);
		
		int increment = 10;
		System.out.println(++increment);
		System.out.println(increment);
		
		boolean True = true;
		boolean False = false;
		
		boolean result = True || False;
		System.out.println(result);
		
		// ternery operator
		
		System.out.println((True && False)?True:False);
		
		if (result)
		{
			
			System.out.println(result);
		}
		else if(!result)
		{
			System.out.println(result);
		}
		else
		{
			System.out.println("Default");
		}
		
		int number1 = 13;
		int number2 = 18;
		int maxNumber = (number1>number2)?number1:number2;
		
		System.out.println("Maximum number is "+maxNumber);
		
		int sum1 = 14;
		float sum2 = 45.5f;
		float	totalsum = sum1 + sum2;
		System.out.println("Total sum is :"+totalsum);
		
		if ((true && true) == true)
		{
			System.out.println("true:" + true);
		}
		
	}

}
