import java.util.concurrent.CountDownLatch;

class Worker extends Thread
{	
	private int delay;
	private CountDownLatch latch;
	public Worker(int delay, CountDownLatch latch,String name) {
		super(name);
		this.delay = delay;
		this.latch = latch;
	}
	@Override
	public void run()
	{
		try {
			Thread.sleep(delay);
			latch.countDown();
			System.out.println(Thread.currentThread().getName()+" has finished");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		// creating the task that waits for 4 threads before the main thread starts its execution
CountDownLatch latch=new CountDownLatch(4);
Worker w1=new Worker(1000,latch,"Worker-1");
Worker w2=new Worker(2000,latch,"Worker-2");
Worker w3=new Worker(3000,latch,"Worker-3");
Worker w4=new Worker(4000,latch,"Worker-4");
w1.start();
w2.start();
w3.start();
w4.start();
//main task wait for 4 threads
latch.await();
System.out.println(Thread.currentThread().getName()+" has finished");
//This will have no effect  as it will not stop the main thread again and will not even raise any exception
latch.await();
System.out.println(Thread.currentThread().getName()+" has started running again");
	}

}
