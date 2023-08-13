

package Practice;
// Class name is in PascalCase
// variables  is in camelCase
// method names in camelCase


public class ClassesAndObjects 
{
	Dog nun; // Instance reference variable
	public static void main(String[] args)
	{
		Dog  roxy = new Dog();   // local reference variable
		roxy.age = 12;
		roxy.showAge();
		Dog  boxy = new Dog();
		boxy.setName("boxy");
		boxy.showName();
		boxy.age = 30;
		System.out.println(boxy.name+"'s age is "+boxy.getAge());

	}

}

class Dog
{
	String name;
	int    age;
	float height;
	char colour;
	
	void setName(String _name)
	{
		name = _name;
	}
	int getAge()
	{
		return age;
		
	}
	
	void showAge()
	{
		char colour = 10;
		System.out.println(colour);
		System.out.println("my dogs age is "+age);
	}
	void showName()
	{
		System.out.println("My dogs name is "+name);
	}
	
}

