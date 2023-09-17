package Practice;
/*
 *  Interface :- Using interface we can achieve complete abstraction
 *  we cannot create object for an interface
 *  Implements keyword is used to implement an interface from a class.
 *  in the class which implements interface either we have to give implementation for all methods or make class abstract
 *  one class can implement multiple interfaces.
 *  one interface cannot implement another interfaces.
 *  one interface can extend another multiple interfaces ( when exteneded interface is implemented by class it has to implement both the interface methods)
 *  
 *  can be used to achieve loose coupling(by using concept of runtime polymorphism)
 *  
 */
public class InterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalculator mc1 = new MyCalculator(); // object and reference are of same type
		Calculators mc2 = new MyCalculator(); // object is of type class and reference is of type interface is also possible
		

	}

}

interface Calculators
{
	void add();  // all the methods in interface methods are public abstract even if we don't specify :- public abstract void add();
	void sub(); 
	public abstract void multi();
}

interface Calculators1
{
	void division();
	void modulus();
}
interface CalculatorsExted extends Calculators,Calculators1
{	
	
}

class MyCalculator implements Calculators
{
	@Override
	void add()       // error because we cannot reduce the visibility of method when overriding (in this case from public to default ) visibility reduced
	{
		
	}
	@Override
	public void sub()
	{
		
	}
	public void multi()
	{
		
	}
	public void division()
	{
		
	}
}

class MyCalculatorsMulti implements Calculators,Calculators1 // one class can implement multiple interfaces 
{
	public void add()
	{
		
	}
	public void sub()
	{
		
	}
	public void multi()
	{
		
	}
	public void division()
	{
		
	}
	public void modulus()
	{
		
	}

}
class MyCalculators implements Calculators  // error since implementation is not provided
{
	                           
}
abstract class MyCalculator1 implements Calculators  // no error as class is abstract and implmentation is not provided
{
	
}