package Practice;

public class SuperThisKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q classQ = new Q();
		classQ.show();
	}

}

class P
{
	int num = 10;  // instance variable
}

class Q extends P
{
	int num = 8;    // instance variable
	public void show()
	{
		int num = 7;              
		System.out.println(num);        // local variable is given preference then reference variable
		System.out.println(super.num);  // using super keyword we can refer to parent class instance variable
		System.out.println(this.num);    // using this keyword we can refer this classes instance variable
	}
	
}
