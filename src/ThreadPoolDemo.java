import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable
{
	private int id;
	public Processor(int id)
	{
		this.id=id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("started "+id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("completed "+id);
		
	}
	
}
public class ThreadPoolDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executor=Executors.newCachedThreadPool();
		//Executors.newSingleThreadExecutor()
		for(int i=0;i<5;i++)
		{
		executor.execute(new Processor(i));
		}
		executor.shutdown();
		System.out.println("Task submitted");
		executor.awaitTermination(7, TimeUnit.SECONDS);
		//System.out.println("task Completed");
		//executor.shutdownNow();
		System.out.println(executor.isTerminated());
		System.out.println(executor.isShutdown());
		

	}

}
