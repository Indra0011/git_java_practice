package Exercise;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
public class FileHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "C:\\Users\\indra.sena_clear\\Pictures\\InputOutput\\telsuko.txt";
		String directory = "C:\\Users\\indra.sena_clear\\Pictures\\InputOutput\\Telusko";
		try
		{
			File file1 = new File(file); // if specified exists in the folder 
			// then file1 will refer to that file.
			
			//file1.createNewFile(); // will create a file if it does not exist in the specified folder
			
			System.out.println(file1.exists());
			System.out.println(file1.getPath());
			
			File dir = new File(directory); // checks for folder with name Telusko
			System.out.println(dir.exists());
			//dir.mkdir(); // creates the telusko folder in specified path if it does not exists.
			
			System.out.println(dir.isDirectory());
			System.out.println(dir.isFile());
			
			//list all files/subfolders in a folder
			File file3 = new File("C:\\Users\\indra.sena_clear\\Pictures");
			String str[] = file3.list();   // files names are stored in the str.
			int count = 0;
			for(String f:str)
			{
				count++;
				System.out.println(f);
			}
			System.out.println("count of all files" +count);
			
			// writing to a file - once after  || db hits will be more as reading/writing is done character by character
			
			File dir1 = new File("C:\\Users\\indra.sena_clear\\Pictures\\InputOutput");
			File file4 = new File(dir1,"telusko.txt"); // opening connection to file , if file does not exist in folder it's created
			FileWriter fw = new FileWriter(file4,false);  // using filewriter to write  to a file, if true is passed then text is 
			// appended to existing file
			try
			{
				fw.write("Java \n Append");
			}
			finally
			{	
				fw.close();
			}
			System.out.println("Go and check the file in local system");
			
			//reading from a file
			
			File dir2 = new File("C:\\Users\\indra.sena_clear\\Pictures\\InputOutput");
			File file5 = new File(dir2,"telusko.txt");
			FileReader fr = new FileReader(file5);
			int i= fr.read();                     // gets the first character
			System.out.println("Reading a character from a file " + (char)i);  //type casting from int to char to display char
			
			while(i != -1)
			{
				System.out.print((char)i);
				i = fr.read();         // till end of file all characters are fetched one by one
			}
			
			// we can also read using character array
			char[] ch = new char[(int)file5.length()]; // since array size can only be int we are downcasting.
			fr.read(ch); // all characters are read to ch character array.
			for(char c:ch)
			{
				System.out.println(c);
			}
			
			fr.close();
			
			// reducing db hits by using buffered reader
			
			File dir6 =new File("C:\\Users\\indra.sena_clear\\Pictures\\InputOutput");
			File file6 = new File(dir6,"telusko.txt");
			FileWriter fw1 = new FileWriter(file6,false);
			BufferedWriter br = new BufferedWriter(fw1);
			
			br.write("Indra");
			br.newLine();
			br.write("is awesome");
			br.flush();			
			br.close();
			fw1.close();
			
			FileReader fr1 = new FileReader(file6);
			BufferedReader bw = new BufferedReader(fr1);
			String data = bw.readLine(); // reads line by line
			while(data != null)
			{
				System.out.print(data);
				data = bw.readLine();
			}
			
			bw.close();
			fr1.close();
			
			//try with resources concept (introduced in java 7) , we can also use try with finally instead of this
			
			try(BufferedReader bw9 = new BufferedReader(new FileReader(file6))) // this syntax will close the resource automatically 
			// instead manually closing it, (this because of Autocloasble interface which is implemented by these classes
			{
				
			}
			catch(Exception e)
			{
				
			}
			//using semi colon we can add many resources in the try with resource 
			try(FileReader fr11 = new FileReader(file6);BufferedReader bw9 = new BufferedReader(new FileReader(file6)))
			{
				
			}
			catch(Exception e)
			{
				
			}
			
			// print writer - can be used to store any type of data not only characters
			File dir7 = new File("C:\\Users\\indra.sena_clear\\Pictures\\InputOutput");
			File file7 = new File(dir7,"telusko.txt");
			
			PrintWriter pw = new PrintWriter(file7);
			pw.write(65);
			pw.write("\n");
			pw.println(45);
			pw.println("Test");
			pw.println(56.8);
			
			pw.close();
			
			// storing the data in a file securely using streams (in form of bytes) , so that when this file is transferred over
			// network , if hacked it cannot be understood.
			File dir8 = new File("C:\\Users\\indra.sena_clear\\Pictures\\InputOutput");
			File file8 = new File(dir7,"teluskoSerialize.txt");
			FileOutputStream fos = new FileOutputStream(file8);
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			Student s1 = new Student("Indra",25,990188);  // to securely store we have to implement serializable interface
			oos.writeObject(s1);
			oos.flush();
			oos.close();
			
			FileInputStream fis = new FileInputStream(file8);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student s = (Student)ois.readObject();
			System.out.println(s.name);
			System.out.println(s.rollno);  // 0 since the roll no is not participating in serialization and not stored in file
			ois.close();
			fis.close();
			
			// we have buffered input and buffered output stream here as well.
			/*
			File dir9 = new File("C:\\Users\\indra.sena_clear\\Pictures\\InputOutput");
			File file9 = new File(dir7,"teluskoSerialize.txt");
			FileInputStream fis9 = new FileInputStream(file9);
			BufferedOutputStream bos = new BufferedOutputStream(fis9);
			ObjectInputStream ois9 = new ObjectInputStream(fis);
			
			FileOutputStream fos9 = new FileOutputStream(file8);
			BufferedInputStream bis = new BufferedInputStream(fos9);
			ObjectOutputStream oos9 = new ObjectOutputStream(bis);	
			
			*/
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
		}

	}

}

class Student implements Serializable  // this is a marker interface (need not provide implementation
{
	String name;
	int age;
	transient int rollno;         // transient members will not participate in serialization(to achieve selective serialization)
	public Student(String name,int age,int rollno)
	{
		this.name = name;
		this.age  = age;
		this.rollno = rollno;
	}
	
}
