package Practice;

import java.io.Serializable;

/* Three types of interface
 * 1.  Normal interface
 * 2.  SAM interface/ functional interface     - single abstract method interface (which has only one method-Runnable)
 * 3.  Marker interface - has 0 methods in it.(serializable interface)
 * 
 *  - > serialization 
 *      storing an application state is called serialization(like current status of game)
 *      using serializable interface we can store the state of an object
 *      
 *  -> lambda expression works only with functional interface(only one method), when multiples methods are there we can use anonymous class.
 *  for anonymous class , .class file is created with dollor sign, wherease for lambda it's not created.
 *  
 */
public class Lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//calca cal = new CalcImpl(); // reference is of type interface and object is of type class
		
		//instead of creating separate class , we can also create anonymous class
		calca cal = new calca()
				{
					@Override
					public void show()
					{
						System.out.println("In show");
					}
				};
		cal.show();
		
		
		// using lambda class 
		
		calca cal1 = () ->  // arrow is called lambda expression (this is just to remove additional lines in anonymous class
		{
			System.out.print("In lambda");
		};
		
		// when only one statement is is present we can write in one line without curly braces
		
		calca cal2 = () -> System.out.println("In lambda");
		cal2.show();
		
		// lambda with parameters
		
		calcul cal3 = (int num) ->{
			return num*num;
		};
		System.out.println("Area is " + cal3.square(10));
		
		calcul cal4 = (int num) -> num*num; // by default return is also added by compiler
		
		calcul cal5 = (num) -> num*num; // type of variable is also not required it is assumed from interface
		
		calcul cal6 = num -> num*num;   // when only one variable is present bracket can be skipped
			
	}

}

class multiInterface implements ramma,thiru   // ambiguity issue - from which interface show method to be called
{
	
}

class multiInter implements ramma,thiru
{
	@Override
	public void show()                // resolves ambiguity issue.
	{
		ramma.super.show();
	}
}
interface calca
{
	void show();
}

interface calcul
{
	int square(int num);
}

interface ramma
{
	default void show()
	{
		System.out.println("in ramma");
	}
}

interface thiru
{
	default void show()
	{
		System.out.println("in thiru");
	}
}
/*
class CalcImpl implements calca , Serializable
{
	@Override
	public void show()
	{
		System.out.println("In show");
	}
}
*/