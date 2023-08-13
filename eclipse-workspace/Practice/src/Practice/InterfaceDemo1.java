package Practice;
/*
 * A class can extend another class and implement an interface together
 * Interface without any methods(empty) is called as marker interface/Tagged interface  (used in serializable / deserializable) implemented during runtime
 * inside an interface we can have an variable , by default it is public , static and final (constant)
 * from java 8 we can have body also in an interface by providing an default keyword
 * default(keyword , not same as not providing anything for a method) method in interface can be overided or skipped(since it's already defined).
 * we can also have static methods in the interface, (static methods can be hidden but not overridden).
 * 
 */
public class InterfaceDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

class Myclac extends calc implements cal
{
	@Override
	public void add()            
	{
		
	}
}
interface cal
{
	float pi = 3.14f; // actual signature is (final public static float pi = 3.24f;)
	final public static double constant = 10;  
	void add();
	default void sub()          // implementation can be provided in interface for a method using default method)
	{
		System.out.println();
	}
	public static void multi()
	{
		System.out.println();
	}
}
class calc
{
	void display()
	{
		
	}
}
