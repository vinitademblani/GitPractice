import java.text.SimpleDateFormat;
import java.util.Date;

class ThreadLocalTest implements Runnable
{
	public static final ThreadLocal<SimpleDateFormat> dateFormat=new ThreadLocal<SimpleDateFormat>()
	{
		@Override
		public SimpleDateFormat initialValue()
		{
			System.out.println("Initializing simple date format for "+Thread.currentThread().getName());
			return new SimpleDateFormat("dd/mm/YYYY");
			
		}
	};

	public void run() 
	{
		System.out.println("Thread run method started for "+Thread.currentThread().getName());
		System.out.println(dateFormat.get().toPattern());
		System.out.println(dateFormat.get().format(new Date()));
	}
}
public class ThreadLocalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLocalTest demo=new ThreadLocalTest();
		Thread t1=new Thread(demo,"Thread 1");
		Thread t2=new Thread(demo,"thread 2");
		t1.start();
		t2.start();

	}

}
