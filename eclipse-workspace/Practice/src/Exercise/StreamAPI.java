package Exercise;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 *  stream is immutable , once on performing a specific operation on stream it cannot be re-used.
 *  original object / stream is never modified
 *  streams work on collections/arrays/IO to perform some operations and give the result
 * 
 */
public class StreamAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer>	nums	= Arrays.asList(25,13,25,25,67,78);
		//nums.forEach((n)->System.out.println("Using List " +n));
		
		List<String> str = "indra";
		Stream<Integer>	stream1	= nums.stream();
		
		//Stream<Integer> stream1 = nums.parallelStream();  will be same as above line but sequence of elements in list(nums) is not maintained
		
		//stream1.sorted();  will throw exception as we cannot reuse it as we have alread used in above line
		
		Stream<Integer> stream2	= stream1.sorted(); // this will work  as stream2 is not used before
		
		//stream1.forEach((n)->System.out.println("Using stream1 " +n)); will throw exception as stream1 is alread used in above line
		
		//stream2.forEach((n)->System.out.println("Using stream2 " +n));
		
		/* func object can be based to map function also instead of lambda
		Function<Integer,Integer> func = new Function<>()
				{
					@Override
					public Integer apply(Integer t) {
						
						return t*2;
					}
				};
				*/
		Stream<Integer> stream3	= stream2.filter((n)-> n >30);  // original list values are filtered and only values above 30 are selected
		Stream<Integer> stream4 = stream3.map((n)->{           // map is used to update values in the stream
			return n*2;
		});
		
		stream4.forEach((n)->System.out.println("using stream4 " +n));
		
		// Instead of all the above lines to achieve this , we can do it in single line
		
		nums.stream().sorted().filter((n)->n>30).map((n)->n*2).forEach((n)->System.out.println("Streams are awesome "+n));
		
		Predicate<Integer> filter = new Predicate() {

			@Override
			public boolean test(Object t) {
				return false;
			}
		};
		
		
		
	}

}
