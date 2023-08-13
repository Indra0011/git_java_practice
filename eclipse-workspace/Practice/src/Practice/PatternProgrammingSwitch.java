package Practice;

public class PatternProgrammingSwitch {

	public static void main(String[] args) {
		
		int num = 045;  // if 0 is attached to integer literal it's octal values is taken (3bits for each number 4(100) 5(101) 100101 - 37
		int num1 = 0x45; // hexa decimal eachnumber is represented using 4 bits  4(0100) 5(0101) 01000101 - 69
		int num2 = 0b100101; // binary representation of a number
		System.out.println(num2);
		System.out.println(num);
		System.out.println(num1);
		switch(num) {
			case 11:
				System.out.println(num);
				break;
			case 10:
				System.out.println(num);
				System.out.println(num);
				break;
			case 12:
				System.out.println(num);
				break;
			default:
				System.out.println("default");
		}
	}

}
