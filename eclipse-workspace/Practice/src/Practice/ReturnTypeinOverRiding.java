package Practice;
/*
 *   return type of a overridden method can be changed if return types haven is a relation ship (child class overridden method 
 *   extends parent class return type method
 */

public class ReturnTypeinOverRiding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// whenever we create an object the reference and object type should be same or reference can be parent of object type. 
		
		Plane cargo = new CargoPlane();  // object created is of type CargoPlane but assigned to Plane type reference (only if Plane type is
		                                 // parent of object, 
		
		cargo.parentmethod();            // parent method can be accessed 
		cargo.childmethod();			// child method cannot be accessed since object reference is Plane(parent)
		((CargoPlane)cargo).childmethod(); // using down casting we are able to access child method using parent reference. 
		/*
		 *  Down casting - temporarily changing type of parent reference to child type reference to access child class methods
		 *  up casting  - creating parent reference for child type object -> to achieve polymorphism
		 */
		
	}

}

class Plane
{
	void parentmethod()
	{
		
	}
}

class CargoPlane extends Plane
{
	void childmethod()
	{
		
	}
}

class Animal
{
	public Plane eat()
	{
		Plane p = new Plane();
		return p;
	}
}

class Tiger extends Animal
{
	@Override
	public CargoPlane eat()          // overridden method can have different return type if returntype object has IS-A relationship 
	{
		CargoPlane c = new CargoPlane();
		return c;
	}
}