package Exercise;
import java.util.*;
public class WrapperClass {
   // string[] args , is there to receive command line arguments(ex: from command line to pass data )
	public static void main(String[] args) {
		
		Integer num = new Integer(10); // depricated.
		
		Integer num1 = Integer.valueOf(10); 
		int num2= num1; // auto-Unboxing object is converted to primitive data type.
		int num3 = num1.intValue(); // manual unboxing/unboxing
		
		// converting primitive to object is known as  boxing
		// converting object to primitive is known as un-boxing
		
		ArrayList lst = new ArrayList();
		lst.add(10); // autoboxing
		
		double d = 14.4;
		
		Double d1 = Double.valueOf(d); // autoboxing , d is primitive but now it's stored as object in d1
		
		Double dd  = 14.45; // auto boxing
		
		
		
		
		
		
		
		
	}

}
