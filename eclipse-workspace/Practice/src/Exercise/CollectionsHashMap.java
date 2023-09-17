package Exercise;
import java.util.*;
import java.util.Map.Entry;
/*
 * if any object is part of hashmap , then  garbage collector does not clean it even if that object is reference less. 
 * (object has to be key not value, when key of hashmap is set to null and garbage collector runs(system.gc()) it is cleaned in weakhashMap)
 * for the above reason weakhashmap is used , where garbage collector will clean object if object in hashmap is reference less
 *  HashMap                       				HashTable 							TreeMap
 *  
 *  1. Can have null as key					Cannot have null as key
 */
public class CollectionsHashMap {

	public static void main(String[] args) {

		HashMap map1 = new HashMap();
		map1.put(10, "Indra");
		map1.put(10, "West");  // data is replaced when same key is used
		
		map1.put("Indra", 10);
		Animal a = new Animal();
		map1.put(a,"This a animal");
		map1.put(null, "this is null");
		
		System.out.println(map1);
		System.out.println("get only values from map " +map1.values() );
		Collection col = map1.values(); // gets values from map
		Iterator itr1	= col.iterator(); // iterate only through values
		while(itr1.hasNext())
		{
			System.out.println("Iterator values "+itr1.next());
		}
		
		Set s	= map1.keySet();  // gets keys from map
		Iterator itr2	= s.iterator();
		while(itr2.hasNext())
		{
			System.out.println("Iterator keys "+itr2.next());
			System.out.println("values from keys "+map1.get(itr2.next()));  // get value from key
		}
		
		
		Set ent = map1.entrySet();
		Iterator	itr3 = ent.iterator();
		while(itr3.hasNext())
		{
			Map.Entry pair	= (Entry)itr3.next();
			System.out.println(pair.getKey());
			System.out.println(pair.getValue());
			System.out.println("Iterator key -values "+itr3.next());
		}
		
		
		HashMap<Integer,String> map2 = new HashMap<>();  // Hash maps with generics
		
		//map2.put("Indra", 10);	// gives error as generic is specified where only Integer can be as key
		
		LinkedHashMap	map3 = new LinkedHashMap(); // order of insertion is maintained
		
		map3.put(1, "first");
		map3.put(2, "Second");
		map3.put(3, "Third");
		
		System.out.println(map3);
		
		TreeMap		map4 	= new TreeMap();  // data is sorted based on the key
		map4.put(2, "second");
		map4.put(1, "first");
		map4.put(3,"third");
		
		System.out.println(map4);
		
		
		
		
	}
	

}

class Animal
{
	int age;
	String behaviour;
}
