package Practice;
import java.util.Scanner;
/*
 * Array is an indexed based datastructure to store large values of homogenous data
 * Array is treated as an object ( memory is allocated for array in heap area since it's an object)
 * 
 */

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[] = new int[5];  // ar is an array of integer 20 bytes of memory is allocated in heap (since int is 4 bytes and array size is 5)
		ar[0] = 10;
		
		// data can be initialized directly 
		int arr[] = {10,20 };
		Scanner sc = new Scanner(System.in);
		
		// to give user input to array
		for(int i=0;i < 5; i++)
		{
			System.out.println("Enter marks of %1 student "+i);
			ar[i] = sc.nextInt();
		}
		
		System.out.println("Array elements are" + ar); // address of array is printed since ar is an object
		System.out.println("1d array length is "+ar.length);
		for(int i = 0; i<ar.length;i++)
		{
			System.out.println("the marks of %1th student is %2 "+ar[i]);
		}
		
		
		// Two dimensional array
		int d2[][] = new int[5][5]; 
		int d21[][] = {                             // syntax for directly assigning data to 2d array
				{
					10,20,30
				},
				{
					30,20,10
				}
		};
		for(int i = 0; i < d2.length; i++)         // use array.length to get the length of an array , length is not a method
		{
			for(int j = 0; j < d2[0].length; j++)
			{
				d2[i][j] = i*j;
			}
		}
		for(int i = 0; i < d2.length; i++)
		{
			for(int j = 0; j<d2[0].length;j++)           // to get length of inner array , d2[0] since all the subarrays have same length
			{
				System.out.println("The value of 2d array is "+d2[i][j]);
			}
		}
		
		//Jagged array - sub array has varying length
		int jarr[][]= new int[3][];    // size for outer array is specified, if inner array has varying length assign the length separately
		jarr[0] = new int[2];  // varying length of subarray 
		jarr[1] = new int[3];
		for (int i = 0; i < jarr.length;i++)
		{ 
			for(int j = 0; j<jarr[i].length;i++)  // jarr[i] is given not jarr[0] because subarrays have varying length
			{
				jarr[i][j] = sc.nextInt();
			}
		}
		
		// array with string char float double
		char ch[] = new char[5];
		String s[] = new String[2];
		double d[] = new double[] {      // another syntax for assigning elements
				10,20
		};
		
		
	}

}
