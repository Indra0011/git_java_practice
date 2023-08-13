package Practice;
/*
 * 1. compile time polymorphism can be achieved using method overloading
 * 2. run time polymorphism - using parent reference it can be achieved
 * using parent reference we can access overridden methods of child classes but not specilized method of child classes.
 */

public class Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Lion lion = new Lion();                 //
		lion.eat();								//
		lion.running();							//
												
		Monkey monkey = new Monkey();		    //
		monkey.eat(); 							// This is not runtime polymorphism since the same methods are invoked multiple times
		monkey.running();                       //
		
		Deer deer = new Deer();                 //
		deer.eat();                             //
		deer.running();                         //
		
		/*
		 * Runtime polymorphism we created Forest class and a method which accepts reference of type Animals(parent class as it can be
		 * assigned with child class object as well. using this reference we can call child class method appropriately based on child object passed.
		 * Can be done without forest class as well
		 */
		Forest forest = new Forest();
		Animals lions = new Lion();
		forest.permit(lions);
		Animals monkeys = new Monkey();
		forest.permit(monkeys);
		
		
	}

}

// to achieve runtime polymorphism
class Forest
{
	public void permit(Animals ref)
	{
		ref.eat();
		ref.running();
	}
}
class Animals
{
	public void eat()
	{
		System.out.println("Animal eats");
	}
	public void running()
	{
		System.out.println("Animal runs");
	}
}
class Lion extends Animals
{
	@Override
	public void eat()
	{
		System.out.println("Tiger eats");
	}
	@Override
	public void running()
	{
		System.out.println("Tiger runs");
	}
}
class Monkey extends Animals
{
	@Override
	public void eat()
	{
		System.out.println("mokey eats");
	}
	@Override
	public void running()
	{
		System.out.println("Moneky runs");
	}
}
class Deer extends Animals
{
	@Override
	public void eat()
	{
		System.out.println("deer grazes");
	}
	@Override
	public void running()
	{
		System.out.println("Deer hops");
	}
}