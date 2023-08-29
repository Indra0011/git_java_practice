package Exercise;
import java.util.Scanner;
/*
 * main thread - > line of execution
 * by default jvm creates the main thread with 5 priority to start execution.(name and priority can be changed)
 * 
 * Two ways to create threads in java
 * 1. by extending Thread class
 * 2. by implementing runnable interface(has only one abstract method)
 * 
 * thread scheduler to manage threads even main thread
 * 
 * when ever new thread is created , in runtime stack a new stack is created and this thread is assigned to that stack frame 
 * Race condition :- thread scheduler will only take cpu time cycle as most important and does not bother which activity should be performed ,
 * and all threads try for cpu always.
 */

public class ThreadingDemo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		Thread thread = Thread.currentThread();  // gets the current thread(main thread in this case)
		String tName = thread.getName();
		int tpriority	= thread.getPriority();
		System.out.println("Thread name and priority is "+ tName + " " + tpriority);
		
		thread.setName("Indra");  // we can change the main thread name
		thread.setPriority(1);     // it's also possible to change priority of main thread
		tName =thread.getName();
		tpriority	= thread.getPriority();
		System.out.println("Thread name and priority is "+ tName + " " + tpriority);
		
		Banking b = new Banking();
		
		Numbers num = new Numbers();
		
		Alpha a = new Alpha();
		// when a class extends the thread class , below thread object are not required . when object of that class extending thread is 
		// created automatically threads are created.(even class which extend thread class needs to have run method)
		// 
		Thread t1 = new Thread(b); // new thread is created (will only execute run method of runnable interface)
		Thread t2 = new Thread(num);
		Thread t3 = new Thread(a);  // total 4 threads : 1 - JVM , 3 we created
		
		System.out.println("is t1 thread alive " + t1.isAlive());  // only when thread is handed to thread scheduler(after start method)
		
		t1.start();         // this will call the run method of the class (which has implemented runnable interface)
		t2.start();        // these threads are randomly executed by the thread scheduler
		t3.start();
		System.out.println("Is t1 thread alive after invoking start method "+t1.isAlive());
		//b.start() in case thread class is extended , instead of starting thread object,  b is child class object
		// instead of start of run method(b.run() is directly called then main thread will execute them in order(single thread programming) since thread scheduler can only 
		// control when object.start() is used 
        
		t1.join(); //  To make the main thread wait(wait till t1 thread complete and join with main thread)
		t2.join();
		t3.join();
		System.out.println("All threads finished completed- can close resources and main thread ended"); // this is executed at the end after all three threads are completed
			// since join will make the main thread wait till it is completed.
		
		// multiple threads with single run ,(multiple threads can execute single run method)
		MultiThreadSingleRun m = new MultiThreadSingleRun();
		Thread t4 = new Thread(m);
		Thread t5 = new Thread(m);
		Thread t6 = new Thread(m);
		t4.setName("Numbers");
		t5.setName("Alpha");
		t6.setName("Special");
		t4.start();
		t5.start();
		t6.start();
		
	}

}

class Banking implements Runnable
{
	@Override
	public void run()
	//public void print()
	{
		System.out.println("Activity 1 started");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the accout Num");
		int accNum = sc.nextInt();
		System.out.println("Enter password");
		int pwd = sc.nextInt();
		System.out.println("Activity 1 Ended");

	}
}

class Alpha implements Runnable                      // to implement multiple threads
{
	@Override
	public void run()
	//public void printalpha()throws Exception
	{
		System.out.println("Activity 2 started");
		for(int i = 65;i<75;i++)
		{
			System.out.println((char)i); //type casting to alphabet
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Activity 2 Ended");
		
		
	}
}
class Numbers implements Runnable
{
	@Override
	public void run()
	{
		System.out.println("Activity 3 started");
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
		}
		System.out.println("Activity 3 Ended");
		
	}
}

class MultiThreadSingleRun implements Runnable
{
	@Override
	synchronized public void run()    // when synchronized is used only one thread is finished and then next thread executes the run method
	{
		String tName = Thread.currentThread().getName();     // where run method is called from multiple threads
		switch(tName)
		{
		case "Special":
			this.special();
			break;
		case "Numbers":
			this.numbers();
			break;
		case "Alpha":
			this.alphabets();
			break;
			
		}
	}
	
	public void numbers()
	{
		System.out.println("Numbers-multithreading");
	}
	public void alphabets()
	{
		System.out.println("Alphabets-multithreading");
	}
	public void special()
	{
		System.out.println("&%$-multithreading");
	}
}