package Practice;

public class StaticKeyword {
	/*
	 * Static can be used with variable , block , method , inner class
	 * 
	 * main method can be overloaded , but jvm will only execute main method which has parameter as string[] args.
	 */
	
	static int age;
	static
	{
		age = 10;
		System.out.println("my age is " + age);                    // Static block is executed even before main method.
	}
	public static void main(int[] args)
	{
		System.out.println("int main method");
	}
	public static void main(String[] args)
	{
		System.out.println("String main method");
	}

}
