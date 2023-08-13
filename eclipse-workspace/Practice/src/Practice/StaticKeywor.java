package Practice;
/*
 *
 * 
 *    not object dependent  object dependent 
 * 1. static variables |   non static variable(instance variables)
 * 2. static block     |   non static block (initialization block)
 * 3. static methods   |   non static method
 * 
 * - > when we need something common across all objects we use static
 * -> static method or variable can be accessed using class name directly or using reference variable as well.
 * -> static methods can be accessed in child class but cannot be overridden 
 */

public class StaticKeywor {
	static int a;
	static
	{
		a = 20;
		System.out.println("Value of a from main class " +a);
	}
	public static void main(String[] args)
	{
		demo1.disp();  // static block of demo1 is also executed automatically executed
		demo1 demo = new demo1();
		demo.disp2();  // for disp2 object is required since it's not static
		demo2 d2 = new demo2();
		demo2.disp();          // parent class static method is accessed in child class but cannot be overridden  
	}
}
class demo1
{
	static int a;
	
	//initialization block - executed when object is created before constructor
	{
		System.out.println("Initialization block");
	}
	//static block
	static                                       // executes even before main method, executed even without invoking (invoked when class is loaded)
	{
		a = 10;
		System.out.println("value of a from demo class "+a);
	}
	public demo1()
	{
		a++;                                   // whenever object is created of this class a is incremented since it's static 
		                                      // and shared across all object. (we can count the number of object's created using this
												// we can also add this in intialization block since this block is also executed when object is created
		                                        // before constructor
																						
	}
	public static void disp()                     // static method - can be accessed without object
	{ 
		System.out.println("display method from demo1 "+a);
	}
	
	public void disp2()
	{
		System.out.println("disp2 method from demo1 "+a);
	}
}

class demo2 extends demo1
{
	public void display()
	{
		this.disp();
	}
	
//	@Override
//	public static void disp()  // error since we cannot override static method
//	{
//			
//	}
	
	// method hiding (specialized method)
	public static void disp()   // this is allowed because here we are not overriding the parent static method , but hiding it(method hiding)
	{
		
	}
}
