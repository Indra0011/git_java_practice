package Practice;

// Method overloading
public class OOPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculator calc = new calculator();
		System.out.println(calc.add(10, 11));
		System.out.println(calc.add(10,23.5, 34));
	}

}

class calculator
{
	public int  add(int num1,int num2)
	{
		return num1+num2;
	}
	public double add(int num1,int num2,int num3)   // Method overloading (signature(method name and parameters) is different)
	{
		return num1+num2+num3;
	}
	public double add(double num1 , double num2,double num3) // Method overloading ( return type does not matter only method name and parameters)
	{
		return (num1+num2+num3);
	}
}