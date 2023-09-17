package Exercise;
/*
 * producer and consumer problem  - inter thread communication (after producer produces the data it should notify consumer thread,
 * once the consumer thread consumes the data it should inform producer so that it can producer thread can produce more data).
 * 
 * inter thread communication is achieved through wait and notify and synchronized 
 * 
 * 
 */
public class ThreadingDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue    q = new Queue();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		
		p.start();
		c.start();
	}

}

class Producer extends Thread
{
	Queue q;
	
	public Producer(Queue data)
	{
		this.q= data;
	}
	@Override
	public void run()
	{
		int i = 1;
		while(true)
		{
			this.q.put(i++);
		}
	}
}

class Consumer extends Thread
{
	Queue q;
	public Consumer(Queue data)
	{
		this.q	= data;
	}
	@Override
	public void run()
	{
		while(true)
		{
			this.q.get();
		}
	}
}
class Queue
{
	// enabling communication between producer and consumer this class is used
	
	int x;
	boolean flag = false;
	
	synchronized public void put(int data)  // use Synchronized for inter thread communication
	{
		try
		{
			if(flag)
			{
				wait();
			}
			else
			{
				this.x	= data;
				System.out.println("I have produced the data to x "+this.x);
				flag = true;
				notify();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	synchronized public void get()
	{
		try
		{
			if(!flag)
			{
				wait();
				
			}
			else
			{
				System.out.println("I have consumed the data from x " + this.x);
				flag = false;
				notify();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
