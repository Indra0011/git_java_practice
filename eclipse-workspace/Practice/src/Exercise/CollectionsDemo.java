package Exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * 
 */

public class CollectionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// List Interface
		
		List list = new ArrayList(); // follows dynamic array data structure(size can grow or shrink dynamically)
		list.add(10);            // ArrayList can store both homogeneous and heterogenous data
		list.add(20);            // data is stored as object, ArrayList implements List interface
		list.add(30);
		list.add("Indra");
		
		System.out.println(list);
		
		List list1 = new ArrayList();         // List is a parent of ArrayList., list1 cannot access specialized methods of ArrayList class
		
		list1.add(1);
		list1.add(20);
		
		System.out.println(list1);
		list1.add(0, 2);                // inserts data at specific index,already present data is shifted to next index
		System.out.println(list1);
		
		list1.add(list) ;                 // one list can be added to another list
		System.out.println(list1);
		
		// ArrayList class , implements List interface
		
		ArrayList list2 = new ArrayList();
		
		list2.add(10);
		list2.add(20);
		
		System.out.println(list2);
		System.out.println(list2.contains(5));  
		System.out.println(list2.indexOf(20)); // if the data does not exist it returns -1
		
		// Linked list - follows doubly linked list data structure
		LinkedList	list3 = new LinkedList();
		list3.add(10);
		list3.add(5);
		list3.addFirst(7);
		list3.addLast(7);
		
		System.out.println(list3);
		
		//ArrayDeque  - follows double ended queue data structure
		
		ArrayDeque ad = new ArrayDeque();
		ad.add(10);
		ad.add(20);
		ad.add(20);
		ad.add(30);
		
		System.out.println(ad);
		
		//PriorityQueue	- minheap data structure , and implements queue interface , can store only homogenous data, duplicates allowed
		// order of insertion is not maintained
		
		PriorityQueue pq = new PriorityQueue();
		
		pq.add(20);
		pq.add(30);
		pq.add(10);
		pq.add(100);
		System.out.println(pq);
	
		// follows binary search tree , implements SortedSet interface
		
		TreeSet set = new TreeSet(); // inorder traversal(give ascending order) duplicate elements are not allowed
		// in a balanced binary search tree time complexity is O(logn) .
		set.add(100);
		set.add(20);
		set.add(40);
		set.add(70);
		
		System.out.println(set);  // All the elements are sorted
		System.out.println(set.ceiling(70)); // if 70 is found it will return 70 ,  if not found it will return higher object than 70
		System.out.println(set.higher(70)); // higher function returns value higher than 70 even if 70 is found
		
		System.out.println(set.floor(70));  // if 70 is found it will return 70 , else lower value than 70 is returned
		System.out.println(set.lower(70));  // will return lower value than 70 , even if 70 is found
		 
		HashSet hset = new HashSet();     // index based insertion is not allowed
										  // does not maintain order of insertion
		hset.add(10);						// implements set interface , duplicates are not allowed, efficient for search operations.
		hset.add(80);
		hset.add(20);
		hset.add(60);
		
		System.out.println(hset);
		
		LinkedHashSet	lhs = new LinkedHashSet();  // same as hashset but order of insertion is maintained
		
		lhs.add(10);                               // it is subclass of hashset
		lhs.add(80);
		lhs.add(20);
		lhs.add(60);
		System.out.println(lhs);
		
		//Iterable 
		
		ArrayList arry = new ArrayList();
		
		arry.add(10);
		arry.add(20);
		arry.add(70);  // ArrayList will store 10 , 20 ,70 in the form of object class object
		
		Object obj = arry.get(1);
		
		//Integer inte = arry.get(1); // since it's returning object class object (parent) , but we are storing in child class 
		// we can downcast it to avoid error
		
		Integer inte1 = (Integer)arry.get(1); // downcasting
		
		for(int i = 0 ; i < arry.size();i++)
		{
			Object obj1 = arry.get(i);            // fetching data present in collection(index based access)
		}
		
		// for collections where index based access is not possible we can use enhanced for loop
		
		for(Object obj2:arry)      
		{
			System.out.println("for each " +obj2);
		}
		
		// Iterator  : iterator.hasnext() : checks if data exists (initially iterator points to -1)
		//  iterator.next() moves to the next element and gets data.
		Iterator itr = arry.iterator(); // ArrayList class implements Iterator interface and this function will return object of that class
										// Here parent (Iterator) is assigned child class reference(class implementing Iterator interface)
		
		while(itr.hasNext())
		{
			System.out.println("Iterator "+itr.next());
		}
		
		ListIterator	lItr	= arry.listIterator(arry.size());  // this interface extends Iterator interface and includes some specialized methods
		
		while(lItr.hasPrevious()) // traversing collection in reverse order
		{
			System.out.println("Reverse Iterator " + lItr.previous());
			//arry.add(20);  // fails because concurrent modification is not allowed in iterator , where as in for loop infinte times it executes(drawback)
			// above line fails fast, instead of inifinte loop like for loop
		}
		
		// we can also avoid concurrent modification by using concurrent package
		
		CopyOnWriteArrayList carry = new CopyOnWriteArrayList(); // same as arraylist but this does not allow concurrent modification
		carry.add(20);
		carry.add(30);
		carry.add(40);
		
		Iterator itr1 = carry.iterator();
		while(itr1.hasNext())
		{
			System.out.println("Copy on write "+itr1.next());
			carry.add(80);  // does not throw exception like arrayList , this is fail safe without exception and restrict concurrent modification.
		}
		
		// collections class, (there is also collection interface )//collections is a utility class
		
		LinkedList	l1 = new LinkedList();
		l1.add(40);
		l1.add(30);
		l1.add(79);
		System.out.println(l1);
		Collections.sort(l1); // sorts data in linkedlist l1
		System.out.println(l1); 
		
		l1.forEach((Object n)->System.out.println("for each " +n));
		
		
		

	}

}
