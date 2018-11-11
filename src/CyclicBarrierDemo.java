import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
class TechLead extends Thread
{
	private String name;
	private int delay;
	private CyclicBarrier barrier;
	public TechLead(String name, int delay, CyclicBarrier barrier) {
		super();
		this.name = name;
		this.delay = delay;
		this.barrier = barrier;
	}
	@Override
	public void run()
	{
		try {
			Thread.sleep(delay);
		
		System.out.println(Thread.currentThread().getName()+" recruited developer");
		System.out.println(Thread.currentThread().getName()+" waiting for other tech leads to finish");

			barrier.await();
			System.out.println("All finished recruiting "+Thread.currentThread().getName()+" giving offer letter to developer");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CyclicBarrier barrier=new CyclicBarrier(3);
		TechLead t1=new TechLead("developer 1", 2000, barrier);
		TechLead t2=new TechLead("developer 2", 2000, barrier);
		TechLead t3=new TechLead("developer 2", 2000, barrier);
		t1.start();
		t2.start();
		t3.start();
		System.out.println("no work for HR manager");
		

	}

}
