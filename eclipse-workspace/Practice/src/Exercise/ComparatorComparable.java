package Exercise;
import java.util.*;
/*
 * Comparator and comparable
 * 
 * 
 */

public class ComparatorComparable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee	emp1 = new Employee("Indra",28,3);
		Employee	emp2 = new Employee("Naveen",5,2);
		Employee	emp3 = new Employee("Tejas",45,1);
		
		System.out.println(emp1);
		
		ArrayList emp	= new ArrayList();
		emp.add(emp1);
		emp.add(emp2);
		emp.add(emp3);
		System.out.println("Before sort "+emp);
		//Collections.sort(emp);  // cannot sort as the elements in the collection are complex data(object of type employee) 
		//to overcome comparable/compartor is used
		
		Alpha1 al	= new Alpha1(); // implements the comparator interface in which the field to be used for comparison is specified
		
		Collections.sort(emp, al);
		
		System.out.println("After sort id"+emp);
		
		Comparator<Employee> comp = (Employee ref1,Employee ref2) -> { // instead of separate class(alpha1) we can use lambda as it funcational interface
			if(ref1.getAge() > ref2.getAge())                  // using comparator , target class(Employee) need not be accessible
			{
				return 1;
			}
			return -1;
		};
		Collections.sort(emp, comp);
		System.out.println("After sort age"+emp);
		
		// comparable interface :- target class should be accessible to implement comparable interface	
		System.out.println("Comparable");
		Employee1	emp4 = new Employee1("Indra",28,3);
		Employee1	emp5 = new Employee1("Naveen",5,2);
		Employee1	emp6 = new Employee1("Tejas",45,1);
		
		ArrayList cemp	= new ArrayList();
		cemp.add(emp5);
		cemp.add(emp6);
		cemp.add(emp4);
		
		System.out.println(cemp);
		Collections.sort(cemp);
		
		System.out.println(cemp);
		
		
	}

}
class Employee1 implements Comparable<Employee1>
{
	private String name;
	private int age;
	private int id;
	
	public Employee1(String name,int age,int id)
	{
		this.name	= name;
		this.age	= age;
		this.id		= id;
	}
	
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
	public int getId()
	{
		return this.id;
	}
	
	@Override
	public String toString()
	{
		return this.name +"-" +this.age +"-"+this.id;
	}

	@Override
	public int compareTo(Employee1 emp) {       
		if(this.id > emp.getId())
		{
			return 1;
		}
		return -1;
	}
	
}

class Employee
{
	private String name;
	private int age;
	private int id;
	
	public Employee(String name,int age,int id)
	{
		this.name	= name;
		this.age	= age;
		this.id		= id;
	}
	
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
	public int getId()
	{
		return this.id;
	}
	
	@Override
	public String toString()
	{
		return this.name +"-" +this.age +"-"+this.id;
	}
	
}

// since comparator is funcational interface we can also implement using lambdas
class Alpha1 implements Comparator<Employee>
{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		if(emp1.getId() > emp2.getId())
		{
			return 1;
		}
		return -1;
	}
	
}