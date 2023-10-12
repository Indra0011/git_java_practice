package Exercise;

import java.util.*;

/*
 * 
 */

public class Generics1 {

	public static void main(String[] args) {
		
		ArrayList human = new ArrayList(); // this is not specific to human object, we can add integer object as well	
		human.add(new Student1());  // any object can be added to human arraylist.
		
		ArrayList<Human1> human1 = new ArrayList();
		
		ArrayList<Student1> student1 = new ArrayList();
		
		human1 = student1; // error since generic does not allow child to store in parent(polymorphism)
		
		ArrayList<?> human2 = new ArrayList(); // using wildcard(?) when type is not known(any type of data can be assigned to human2)
		ArrayList<Student> student2 = new ArrayList();
		human2 = student2; // no error since we have used wildcard
		
		// upper bound - using extends
		
		ArrayList<? extends Human1> human3 = new ArrayList(); // type doesn't matter , all child classes of human and human1 class
		
		ArrayList<Student1> student3 = new ArrayList();
		
		human3 = student3;   // since student is child of human. 
		
		ArrayList<String> s = new ArrayList();
		human3 = s; // since string is not child of human or human
		
		
		// lower bound - using super
		
		ArrayList<? super Human1> human4 = new ArrayList(); // can store only parent of Human1 and human1
		
		human4 = student3; // error since student is not parent of human.
		
		ArrayList<Human1> human5 = new ArrayList();
		human5.add(new Human1());
		callSleep(human5);
		
		ArrayList<Student1> student5 = new ArrayList();
		student5.add(new Student1());
		callSleep(student5); // error since generics doesnt support polymorphism
		
		
		callSleeping(student5); // no error since we are using wild cards 


	}
	
	public static void callSleep(ArrayList<Human1> lst)
	{
		for(Human1 h:lst)
		{
			h.sleep();
		}
	}
	

	public static void callSleeping(List<? extends Human1> list)
	{
		for(Human1 h:list)
		{
			h.sleep();
		}
	}

}

class Human1
{
	public void sleep()
	{
		System.out.println("Human needs sleep");
	}
}
class Student1 extends Human1
{
	@Override
	public void sleep()
	{
		System.out.println("Student needs extra sleep");
	}
}
