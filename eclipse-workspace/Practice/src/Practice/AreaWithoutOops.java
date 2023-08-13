package Practice;
import java.util.Scanner;
/*
 * without inheritance , abstract,final,polymorphism(runtime)
 */
public class AreaWithoutOops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle rect = new Rectangle();
		rect.input();
		rect.compute();
		rect.display();
		
		Square squ = new Square();
		squ.input();
		squ.compute();
		squ.display();
		
		Circle cir = new Circle();
		cir.input();
		cir.compute();
		cir.display();
	}

}

class Rectangle
{
	float length;
	float breadth;
	double area;
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length and breadth of rectangel");
		length = sc.nextFloat();
		breadth = sc.nextFloat();
	}
	public void compute()
	{
		area = length * breadth;
	}
	public void display()
	{
		System.out.println("area of rectangle "+ area);
	}
}

class Square
{
	float length;
	double area;
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of square");
		length = sc.nextFloat();
	}
	public void compute()
	{
		area = length * length;
	}
	public void display()
	{
		System.out.println("area of square "+ area);
	}
}
class Circle
{
	float radius;
	double pi = 3.14;
	double area;
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius of circle");
		radius = sc.nextFloat();
	}
	public void compute()
	{
		area = pi*(radius*radius);
	}
	public void display()
	{
		System.out.println("area of circle "+ area);
	}
}
