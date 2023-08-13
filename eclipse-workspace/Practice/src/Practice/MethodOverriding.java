package Practice;
/*
 * Method overloading is compile time polymorphism
 * method overriding is run time polymorphism
 */
public class MethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPhone myPhone = new IPhone();
		myPhone.call();
		PixelPhone pix = new PixelPhone();
		pix.call();

	}

}
class Phone
{
	public void call()
	{
		System.out.println("Phone");
	}
}
class IPhone extends Phone
{
	public void call()                     // subclass method overriding parent class call method
	{
		super.call();                      // Using super keyword we can call parent class method
		System.out.println("IPhone");
	}
}
class PixelPhone extends Phone
{
	@Override                              // When this annotation is used parent class should have this method else an error is thrown (in this case change c in Call to lowercase
	public void Call()                     // @Override tells that our intention is to override the parent method
	{
		
		System.out.println("Pixel");
	}
}
