package Practice;
/*
 * Anything within double quotes("") it's a string object(in java string is considered as object memory is allocated in heap area)
 * Two types string objects :- 1. mutable string object 2. immutable string object
 * 1. to create mutable string we use (stringbuffer,stringbuilder classes) 
 * 2. to create a immutable string we use String class.
 * -> in heap area separate area is present called string constant pool(scp) in scp duplicates are not allowed
 * -> string comparison operators 
 *     1. == : reference of string object is compared
 *     2. equals() : value of string object is comparted
 *     3. equalsIgnoreCase()  
 *     4. compareTo() : will be compared character to character(lexicographically
 *-> garbage collector will not manage string constant pool , memory in scp is re-allocated only when jvm ends execution.
 *     if one character also increases beyond capacity new capacity is allocated based on this formula (oldcapacity * 2 + 2)
 */
public class StringsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "good morning"; // memory is created in scp only
		String text2 = "good morning";
		String text1 = new String("good morning"); // memory is created in heap and a copy is created in scp
		String text3 = new String("good morning");
		System.out.println(text.equals(text1));
		System.out.println(text == text1);  
		System.out.println(text==text2);
		System.out.println(text1==text3); // since for in heap duplicates are allowed text3 will have different reference.
		int res = text.compareTo(text3);
		System.out.println(res);
		
		//Concatenation - > using concat() or + operator
		
		String firstName = "Indra";
		System.out.println(firstName);
		firstName.concat("Sena");
		System.out.println(firstName); // "Indra" is printed since this is immutable declaration , string is not changed.
		firstName = firstName.concat(" Sena");  // variable is re-assigned 
		System.out.println(firstName);
		
		String test = new String("Indra"); // memory is created in the heap area and copy is maintianed in scp without any reference.
		test.concat("Reddy");
		System.out.println(test);
		
		test = 100 + test + "Reddy" + 100;
		System.out.println(test);
		
		// Inbuilt methods
		test.toLowerCase();
		test.toUpperCase();
		test.charAt(2);
		test.substring(2,7);
		boolean check = test.contains("A"); // true / false
		test.indexOf('a');
		test.length();
		char ch[] = test.toCharArray();
		for(char c:ch)
		{
			System.out.println(c);
		}
		String s[] = test.split("r");
		
		// mutable string - string buffer and string builder class is used
		StringBuffer sb = new StringBuffer("Indra");
		sb.append(" Sena");          // same sb object is changed unlike immutable where new string is created
		System.out.println(sb);
		
		StringBuilder sb1 = new StringBuilder("Ramma");
		sb1.append("Devi");
		System.out.println(sb1.capacity());    // default capacity of stringBuffer object and builder is 16, (oldcapacity * 2 + 2)
		
		StringBuffer b1 = new StringBuffer("Reddy");
		StringBuffer b2 = new StringBuffer("Reddy");
		System.out.println(b1.equals(b2)); // o/p false // since in stringbuffer class the equals method is not overridden from object class , whereas in string class its overridden to compare values
		System.out.println(b1.compareTo(b2)); // o/p :-  0
		
		// final vs mutability :- final does not have effect on mutability of stringbuffer(string does not become immutable).
		
		final StringBuffer b3 = new StringBuffer("Choti");  // final has impact on reference variable(address cannot be changed of final variable) not value
		System.out.println(b3);
		b3.append("Tendulkar");  // becuase of above reason we are able to append to string
		System.out.println(b3);       
		
		b3 = new StringBuffer("Indra"); // error since address of final variable cannot be changed.
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
