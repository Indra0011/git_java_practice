package Practice;

public class InheritanceWithPrivate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human indra = new Human();
		System.out.println(indra);  // since indra holds the address of the object in heap area the address is printed.(but if toString method is overridden in
		                            // Human class then that  return value is printed

	}

}

class Human
{
	public int age;
	private String name = "Ramma";
	protected double height;
	public void display()
	{
		System.out.println("This is a display method in human");
	}
	
	@Override
	public String toString()         // toString() method is part of object class(this class is inherited by other clases by default) 
	{
		return name;
	}
}
class Student extends Human
{
	public void show()
	{
		super.age = 10;                     // Since age is a public instance variable it can be accessed in child class
		name = "Indra";               // name is private instance variable it can cannot be accessed in child class
		height = 6.7;                 // height is a protected instance variable it can be accessed in child class
		System.out.println("Age "+age+" height" + height+" Name "+name);
	}
}
