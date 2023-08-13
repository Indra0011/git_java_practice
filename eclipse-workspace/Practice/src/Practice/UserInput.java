package Practice;
import java.util.Scanner;
public class UserInput {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter you're name");
		String name = scan.next();
		System.out.println("The entered name is " + name);
		scan.close();

	}

}
