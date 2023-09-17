package Exercise;
/*
 *  synchronized key can be applied to run function and also block
 *  
 *  states of thread :- 
 *       1. new state
 *       2. runnable state(ready state) // during ready state the thread can go to dead if interrupt method is encountered
 *       3. running  state // during running state the thread can go to blocked state if sleep(),wait() method is encountered or
 *                          required resource is not available 
 *       4. dead state   // if task is completed thread will come to this state.
 *       5. blocked state   // if required resources are available or sleep timeout is completed the thread again goes to ready state. 
 *       
 *  Thread cannot be interrupted when it is in running state.
 *  Synchronized keyword is used to apply locks 
 *  to avoid deadlock synchronized keyword has to be used in proper order , else deadlock will be occured.
 *  
 *  grouping of threads and constructor in case of threads - to be explored 
 */
public class ThreadingDemo1 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		// Synchronized on a function , can be accomplished using join also.
		Car c2 = new Car();
		Thread t1 = new Thread(c2);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c2);
		
		t1.setName("Child1");
		t2.setName("Child2");
		t3.setName("Child3");
		
		//t1.start();
		//t1.join();  // if synchronized is used on the run function , then join is not required.
		//t2.start();
		//t2.join();
		//t3.start();
		//t3.join();
		
		// Synchronized on a block , which cannot be accomplished using join 
		
		Bike b1 = new Bike();
		Thread t4 = new Thread(b1);
		Thread t5 = new Thread(b1);
		Thread t6 = new Thread(b1);
		t4.setName("Child1");
		t5.setName("Child2");
		t6.setName("Child3");
		//t4.start();
		//t5.start();
		//t6.start();
		
		// deadlock 
		Library l = new Library();
		Thread t7 = new Thread(l);
		t7.setName("student1");
		Thread t8 = new Thread(l);
		t8.setName("student2");
		//t7.start();
		//t8.start();
		
		
		// priority of threads - daemon threads (deamon threads should be in infinite loop , (but it does not execute infinite time)
		
		WordPad word = new WordPad();
		Thread t9 = new Thread(word);
		Thread t10 = new Thread(word);
		Thread t11 = new Thread(word);
		
		// daemon threads execute only after the non daemon thread, 
		
		t9.setName("Typing");
		t10.setName("SpellCheck");
		t11.setName("AutoSave");
		
		t10.setDaemon(true);   // this should run only after typing so we will set them as daemon thread(after other thread finished work this has to be done atleast once)
		t11.setDaemon(true);   // daemon will execute at the end atleast once (at the end of other thread's have finished the work)
		
		t10.setPriority(3);
		t11.setPriority(2);
		
		t9.start();
		t10.start();
		t11.start();
		
	}

}

class Car implements Runnable
{
	@Override                  // concurrent execution of threads
	synchronized public void run() // since synchronized is used thread are sequentially executed one after the other 
									// without synchronized keyword they are executed in random order.(similiar to thread.join() method)
	{
		try
		{
			System.out.println(Thread.currentThread().getName() + " has entered the parking lot");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " has entered the car");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " has started to drive the car");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " has parked the car");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}

class Bike implements Runnable
{
	@Override
	public void run() 
	{
		try
		{
			System.out.println(Thread.currentThread().getName() + " has entered the parking lot");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " has entered the car");
			Thread.sleep(2000);
			synchronized(this)     // synchronized block can be applied to only below statements , above statements will be random(when one thread 
						// enters this block , another thread cannot access it till the block is released(executing all statements) by current thread
			{
				System.out.println(Thread.currentThread().getName() + " has started to drive the car");
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " has parked the car");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}

class Library implements Runnable
{
	String res1 = new String("Java");  // resources present in this class
	String res2 = new String("DSA");
	String res3 = new String("Spring boot");
	@Override
	public void run()
	{
		String tname = Thread.currentThread().getName();
		if("student1".equals(tname))
		{
			try
			{
				Thread.sleep(1000); // hypothetically student1 is searching for books
				synchronized(res1)   // this resource will be locked by only single thread
				{
					System.out.println("Student 1 has acquired "+res1);
					Thread.sleep(1000); // student searching for anther thread
					synchronized(res2)
					{
						System.out.println("Student 1 has acquired "+res2);
						Thread.sleep(1000);
						synchronized(res3) // apply lock to resources 
						{
							System.out.println("Student 1 has acquired "+res3);
						}
					}
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		else
		{
			try
			{
				Thread.sleep(1000); // hypothetically student1 is searching for books
				synchronized(res1)   // this resource will be locked by only single thread
				{
					System.out.println("Student 2 has acquired "+res1);
					Thread.sleep(1000); // student searching for anther thread
					synchronized(res2)
					{
						System.out.println("Student 2 has acquired "+res2);
						Thread.sleep(1000);
						synchronized(res3) // apply lock to resources 
						{
							System.out.println("Student 2 has acquired "+res3);
						}
					}
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}

class WordPad implements Runnable
{
	@Override
	public void run()
	{
		String tName = Thread.currentThread().getName();
		if("Typing".equals(tName))
		{
			this.typing();
		}
		else if("SpellCheck".equals(tName))
		{
			this.spellCheck();
		}
		else
		{
			this.autoSave();
		}
	}
	private void typing()
	{
		try
		{
			for(int i = 0; i< 3;i++)
			{
				System.out.println("Typing");
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Some problem in typing");
		}
	}
	private void spellCheck()
	{
		try
		{
			for(;;)
			{
				System.out.println("Spell checking");
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Some problem in spell check");
		}
	}
	private void autoSave()
	{
		try
		{
			for(;;)              // infinite loop , but this does not run infinite times as it's daemon thread
			{
				System.out.println("auto save");
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Some problem in auto save");
		}
	}
}
