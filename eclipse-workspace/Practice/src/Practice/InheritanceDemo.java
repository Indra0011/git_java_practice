package Practice;import java.util.Scanner;/* * IS  - A :- if class have an IS-A relationship then we can use inheritance(ex:- iphone14pro is a iphone14 (here we can extend iphone14 and use it's properties) * HAS - A :- if class have an HAS -A relationship we can create object of another class in our class and use ex:- human has a phone(create phone object in human and use) */
public class InheritanceDemo {
	public static void main(String[] args)
	{		Scanner sc = new Scanner(System.in);		System.out.println("Enter the two numbers to sum-up");		int num1 = sc.nextInt();		int num2 = sc.nextInt();		sc.close();
		Calculator calc = new Calculator();		System.out.println("The sum of "+calc.add(num1, num2));				//Single level Inheritance - CalcultorPro inherits Calculator class so we can use both add method from CalcultorPro by creating it's object		CalcultorPro calcPro = new CalcultorPro();		System.out.println("Single level : calcPro - The sum and subtract of num1: "+num1+ " num2: "+num2 +" is sum ="+calcPro.add(num1, num2)+				           " subract ="+calcPro.subtract(num1, num2));				// Multi-level inheritance		CalculatorProMax calcProMax = new CalculatorProMax();  // This calls the constructor and since super() call is present by default it calls the parent class constructor so-on		System.out.println("Multi-level : Addition:"+calcProMax.add(num1, num2)+" Subtraction:"+calcProMax.subtract(num1, num2)+				           " Multiplication:"+calcProMax.multiplication(num1,       num2));		
	}

}


