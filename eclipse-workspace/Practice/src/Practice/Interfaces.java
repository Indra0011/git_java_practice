package Practice;
/*
 * inner class 
 * 1. member inner class
 * 2. static inner class ( class cannot be static Since only members can be static , since inner class is member of outer class it can be static
 * 3. anonymous inner class : we can change the behaviour of an existing class with this concept
 * 
 * anonymous classes cannot be reused.
 * we can use anonymous class to implement interface without the implement keyword and a separte class 
 */

public class Interfaces {

	public static void main(String[] args)
	{
		D  temp = new D();
		temp.show();
	 	//E b = new E(); // Since E is inside D it's not accessible
		//member class instantiation
		D.E	e = temp.new E();  // to create object of inner class we need object of outer class
		e.show();
		// static class 
		D.F 	f = new D.F();     // static inner class can be accessed without object , since static memebers doesnt need objects
		
		//anonymous class
		D d = new D() // separate class file will be created in the directory  (similiar to inheritance)
				{
					@Override
					void show()
					{
						
						System.out.println("Heloo anonymous class");
						super.show();                  // call show method from D class 
					}
					public void disp()
					{
						
					}
				};
		d.show();               //Anonnymous class method is called
		//d.disp();              // disp method is not accessible because reference of object d is D class which has no idea of disp method.
		
		
		 // with abstract class 
		
		//G g = new G();  // Since object cannot be created for abstract class

		G g = new G()         // but can create anonymous class oject and override the show method
				{
					@Override
					void show()
					{
						System.out.println("Anonymous with abstract class ");
					}
				};
				
	  // with interfaces  - interface cannot be instantiated , but here we are instatiating an anonymous class and overriding the method from interface
		
				H h = new H()
						{
							@Override
							public void show()
							{
								System.out.println("anonymous with interface");
							}
						};
						
	// lambda expression , which is replacement for anonymous class
			H hh = () -> System.out.println("helo lambda");
	}
}


class D
{
	 int num;
	 //B b = new B();   B is accessible since they are in same class 
     void show()
	{
		System.out.println("hello D");
		//b.show();
	}
	
	class E                     //member class 
	{
		public void show()
		{
			System.out.println("hello E");
		}
	}
	static class F              //static class
	{
		public void show()
		{
			
		}
	}
}

abstract class G
{
	abstract void show();
}

interface  H
{
	void show();
}