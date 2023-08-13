package Practice;

import java.util.Arrays;

/*
 *  We can create an array of our custom class well
 *  memory is contigousouly allocated for arrays( if required continous memory is not available in ram , memory error is thrown
 *  array size is fixed , if we change in backend new array is created in memory 
 *  java has utility class to support additional funcationalities ex:- like sorting array
 *  
 */
public class ArraysAdvanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		student s[] = new student[4];  // creates an array of type student
		
		s[0] = new student();			// each element of array contains address of student object , without this below line will give error
		
		s[0].rollNo = 10;
		s[0].name = "Indra";
		System.out.println("Student roll number"+s[0].rollNo);
		
		// using parent reference we can store heterogenous data 
		Object obj[] = new Object[2]; // by default all classes inherit object class
		obj[0] = new student();
		obj[1] = new dog();
		
		//obj[1].age // but members are not accessible since object class reference isn't aware of these members.(but overridden methods can be accessed
		
		// Enhanced for loop
		for(student arr:s)
		{
			System.out.println("Student elements"+arr.name);
		}
		
		// for  two dimension array , enhanced for loop
		int arr[][] = new int[5][2];
		for(int ar[]:arr)    
		{
			for (int a:ar)
			{
				
			}
		}
		Arrays.sort(arr);        // Arrays is an utility class and sort is an static method , accessed without object.
		
	}

}

class student
{
	int rollNo;
	String name;
}
class dog
{
	int age;
}
