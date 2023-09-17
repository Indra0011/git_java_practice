package Exercise;
import java.util.*;

/*
 * With generics only homogenous data can be stored in collections 
 * 
 */

public class Generics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList	arr = new ArrayList();
		arr.add(10);
		arr.add(30);
		//int num = arr.get(0);// since get returns object type, type casting is required
		
		ArrayList<Integer> arr1 = new ArrayList<Integer>();  // usage of generics to specify which type of data is stored
		arr1.add(10);
		arr1.add(20);
		//arr1.add("Indra");  // error since arr1 can only store integer type data
		
		int num1	= arr1.get(0);  // type casting is not required as we are already specifying its integer data.
		
		
		Learner l1 = new Learner("Indra",25);
		Learner l2 = new Learner("Naveen",30);
		Learner l3 = new Learner("Tejas",22);
		
		List<Learner> lst = new ArrayList<Learner>();  // only learner type can be stored in collection
		
		//List<Human> lst1 = new ArrayList<Learner>(); // in generics the child cannot be referenced through parent
		
		lst.add(l1);
		lst.add(l3);
		lst.add(l2);
		
		System.out.println(lst);
		
		//Custom generic class
		
		Generic<Integer> gint = new Generic<Integer>();  // custom generic class which accepts any type in this case integer. 
		//gint.ref = "Indra";
		gint.ref = 10; // custom class type variable can only have integers.
	}

}

class Learner extends Human
{
	private int age;
	private String name;
	
	public Learner(String name,int age)
	{
		this.name	= name;
		this.age	= age;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString()
	{
		return this.name + "-" + this.age;
	}
}
class Human
{
	
}

// custom generics

class Generic<T>
{
	T ref;
	public Generic(T ref)
	{
		this.ref	= ref;
	}
	public Generic()
	{
		
	}
	public T getRef()
	{
		return this.ref;
	}
	public void display()
	{
		System.out.println("Type of generic is " + ref.getClass().getName());
	}
}
interface Genre<T>
{
	
}

class Gen<T> implements Genre<T>
{
	
}