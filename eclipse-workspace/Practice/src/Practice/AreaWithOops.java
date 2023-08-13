package Practice;
import java.util.Scanner;
public class AreaWithOops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Geometry g = new Geometry();
		Rectangles rect = new Rectangles();
		Squares sq = new Squares();
		Circles cir = new Circles();
		
		g.permit(rect);
		g.permit(cir);
		g.permit(sq);

	}

}
class Geometry
{
	public void permit(Shapes ref)              // to implement polymorphism
	{
		ref.input();
		ref.compute();
		ref.display();
	}
}

abstract class Shapes
{
	double area;
	abstract public void input();
	abstract public void compute();
	public void display()
	{
		System.out.println(this.area);
	}
}
class Rectangles extends Shapes
{
	float length;
	float breadth;
	
	@Override
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the lenght and breadth");
		this.length = sc.nextFloat();
		this.breadth = sc.nextFloat();
	}
	
	@Override
	public void compute()
	{
		this.area = this.length * this.breadth;
	}
}
class Squares extends Shapes
{
	float length;
	
	@Override
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the lenght");
		this.length = sc.nextFloat();
	}
	@Override
	public void compute()
	{
		this.area = this.length * this.length;
	}
}
class Circles extends Shapes
{
	float radius;
	final double pi = 3.14;
	
	@Override
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius");
		this.area = sc.nextFloat();
		
	}
	@Override
	public void compute()
	{
		this.area = this.pi * (this.radius * this.radius);
	}
}