package Practice;
/*
 * Abstraction can be achieved using abstract(partial abstraction is also possible keyword and interface(only complete abstraction)
 * 1. abstract keyword can be used with the method 
 * 2. if any method has only signature but not implementation it's mandatory to have abstract keyword
 * 3. if there is atleast one abstract method in class then class should also be abstract
 * 4. abstract methods does not have implementatio*-n only declaration is present
 * 5. an abstract class may or may not have abstract methods , but if abstract method is present then class has to be abstract
 * 6. abstract class cannot be instantiated(incomplete class) , object cannot be created
 * 7. A child class inheriting abstract class can be instantiated 
 * 8. A variable cannot be declared as abstract, only methods and classes.
 * 9. An abstract class can have a constructor , but not abstract constructor.(since super() is present by default)
 * 10. final keyword can be applied to class, and final classes cannot be extended
 * 11. final keyword can be applied to methods , but unlike classes final method can be accessed in child classes
 * 12. final methods cannot be overrided in child classes
 * 13. final keyword can be applied to variable, then the variable value cannot be changed once intialized.
 * 14. abstract classes cannot be final , since abstract class has to be inherited to implement methods. (but syntax allows it)
 * 15. abstract methods cannot be final , as abstract methods has to be overrided.
 */

public class AbstractionAndFinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent2 par2 = new Parent2();  // abstract class cannot be instantiated
		Parent1_ext par1Ext = new Parent1_ext(); // Child class inheriting abstract class can be instantiated .
	}

}

class Parent
{
	abstract public void method1(); // error since class is not abstract
}

abstract class Parent1
{
	abstract public Parent1()             // abstract constructor can be present in abstract class , 
	                                     // as this constructor is called by super() method in child classes
	{
		
	} 
	public Parent1(int s)                // normal constructor's can be present in abstract class
	{
		
	}
	abstract public void display();       // even if one method is abstract class has to be abstract
	
	public int show()
	{
		return 10;
	}
}
abstract class Parent2                    // class can be abstract without having abstract methods
{
	public int show()
	{
		return 10;
	}
}

class Parent1_ext extends Parent1
{
	@Override
	public void display()                         // child class should implement abstract method of parent else error is thrown
	{
		System.out.println("display method");
	}
}

final class CannotInherit
{
	
}

class CannotInheritExt extends CannotInherit        // error since final classes cannot be inherited
{
	
}

class FinalEx
{
	int canChange = 10;
	final double cannotChange = 3.14;
	final public  void display()
	{
		System.out.println("Final method");
		cannotChange = 2.3;                   // final variable cannot be changed it behaves like constant variables
	}
}
class finalInherit extends FinalEx
{
	@Override
	public void display()                                   // cannot override final method.
	{
		
	}
	public void change()
	{
		canChange = 15;                                   //instance variable can be accessed
		
	}
}