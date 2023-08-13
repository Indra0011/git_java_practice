package Practice;
/*
 * Visibility(access specifier) of a method can be increased on overriding but not decreased.
 */
public class VisibilityAccessmodifier {
	public void visibility()
	{
		System.out.println("Visibility");
	}
	private void VisibilityIncrease()
	{
		System.out.println("Increase visibility");
	}
	private void returntype()
	{
		
	}
}

class Visibility extends VisibilityAccessmodifier
{
	void visibility()                     // Since parent class method is public and this method is default it gives error
	{
		System.out.println("Visibility of a overiding method cannot be be reduced");
	}
	void VisibilityIncrease()               // No error since visibility of default is more than protected.
	{
		System.out.println("Visibility is increased");
	}
	
	@Override
	private void returntype()                      // private methods cannot be overridden
	{
		
	}
}
