package Practice;

public class SuperThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C classc = new C();

	}

}

class A
{
	public A()
	{
		this(10);  // this,super method is used in constructor
		System.out.println("A");
	}
	public A(int a)
	{
		System.out.println("int a");
	}
}
class B extends A
{
	public B()
	{
		this(10);
		System.out.println("B");
	}
	public B(int b)
	{
		System.out.println("int b");	
	}
}
class C extends B
{
	public C()
	{
		this(10);
		System.out.println("c");
	}
	public C(int c)
	{
		super();
		System.out.println("int c");
	}
}
