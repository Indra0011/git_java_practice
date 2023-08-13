package Practice;

public class AccessModifiers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person indra = new Person();
		indra.setName("indra");
		System.out.println(indra.getName()); // will return null since the instance variable is not initialized instead the local variable is reassigned
		indra.setAge(25);
		System.out.println(indra.getAge());

	}

}

// encapsulation - binding of data with methods.
class Person
{
	private String name;
	private int    age;
	private int    mobileNo;
	
	
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		if (this.validateName(name))
		{
			name = name;               // Since parameter name and instance variable is same the local variable is given preference 
		}								// so in this case local variable(parameter) is reassigned with it's own value  
		else 
		{
			System.out.println(name + "name length is too small minimum length is 8");
		}		       
	}
	/** gets the age of a person */
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;                // this keyword will ensure that instance variable is selected instead of local variable when they have same name.
									   // this refers to current object (the object with which the method is called from)
	}  
	public int getMobileNum()
	{
		return mobileNo;
	}
	public void setMobile(int number)
	{
		mobileNo = number;     // Since the parameter name is different from instance variable the value will be properly assigned instance variable(against that object)
	}
	
	private boolean validateName(String name)
	{
		if (name.length() > 2)
		{
			return true;
		}
		return false;
	}
	
	
}
