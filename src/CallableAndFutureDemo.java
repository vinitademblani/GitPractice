import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class FactorialCalculator implements Callable<Long>
{
	private int number;
	
	public FactorialCalculator(int number) {
		super();
		this.number = number;
	}

	@Override
	public Long call() throws Exception {
		
		return calculateFactorial(number);
	}

	private Long calculateFactorial(int n) throws InterruptedException {
		long result=1;
		while(number!=0)
		{
			result=result*n;
			n=n-1;
			Thread.sleep(10);
		}
		return result;
	}
}
public class CallableAndFutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		
		ExecutorService service=Executors.newSingleThreadExecutor();
		Future<Long> result10=service.submit(new FactorialCalculator(10));
		System.out.println("submitted callable task to find factorial of 10");
		
		Future<Long> result15=service.submit(new FactorialCalculator(15));
		System.out.println("submitted callable task to find factorial of 15");
		
		Future<Long> result20=service.submit(new FactorialCalculator(20));
		System.out.println("submitted callable task to find factorial of 20");
		
		System.out.println("Calling the get method of the Future task to return factorial of 10");
		if(result10.isDone())
		{
		long factorial10=result10.get();
		System.out.println("factorial of 10 is "+factorial10);
		}
		
		System.out.println("Calling the get method of the Future task to return factorial of 15");
		if(result15.isDone())
		{
		long factorial15=result15.get();
		System.out.println("factorial of 15 is "+factorial15);
		}
		System.out.println("Calling the get method of the Future task to return factorial of 20");
		/*if(result20.isDone())
		{*/
		long factorial20=result20.get(100,TimeUnit.SECONDS);
		System.out.println("factorial of 20 is "+factorial20);
		/*}*/
	}

}


