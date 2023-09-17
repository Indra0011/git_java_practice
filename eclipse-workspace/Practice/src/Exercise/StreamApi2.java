package Exercise;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/*
 * eager evaluation 
 * 
 * lazy evaluation - streams use lazy evaluation, only when there is a terminal function (foreach) no methods in the stream are called(filter,map,sorted)
 * 
 * that is the reason "In predicate" is not printed when foreach is not used. as we are not using the computed value the system does not compute it all 
 * though we are calling these methods in stream.
 * 
 * any function which does not return stream is a terminal function.
 * 
 * findfirst() will return an optional integer in this case, so the null value should be handled as it returns optional
 * 
 */
public class StreamApi2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Arrays.asList(25,14,68,36,74);
		
		Predicate<Integer> filter = new Predicate<Integer>()   
				{
					@Override
					public boolean test(Integer t) {
						
						System.out.println("in predicate");
						return t > 30;
						
					}
			
				};
		
		
		nums.stream().sorted().filter(filter).map((n)->n*2);  // test method in predicate is not called even on calling filter ,"In
		                                                        // predicate" is not printed.
		
		//nums.stream().sorted().filter(filter).map((n)->n*2).forEach((n)->System.out.println("number " + n));
		
		Optional<Integer> num = nums.stream().sorted().filter(filter).map((n)->n*2).findFirst();
		
		if (num.isPresent())   // to avoid null pointer exception
		{
			System.out.println(num.get().toString());
		}
		
		// we can also add orElse at endo of findfirst, so if no value exists then orelse will be return(it's not optional as we are 
		// returning something.
		
		Integer	num1 = nums.stream().sorted().filter(filter).map((n)->n*2).findFirst().orElse(0);
		System.out.println(num1);  // no null pointer exception in this case.
		
		//if we need to find the sum of values after map then reduce can be used , reduce will take all values and in output gives
		// only one value
		BinaryOperator<Integer> biop = new BinaryOperator<Integer>()  // we can pass biop as well to reduce 
				{

					@Override
					public Integer apply(Integer t, Integer u) {
						// TODO Auto-generated method stub
						return t + u;
					}
			
				};
		
		Integer sum = nums.stream().sorted().filter(filter).map((n)->n*2).reduce(0,(t,u)->t+u); // 0 is to specify starting sum
		
		System.out.println(sum);
		
		//

	}
	
}
