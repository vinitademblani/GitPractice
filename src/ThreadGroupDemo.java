
public class ThreadGroupDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		Thread t1=new Thread("first");
		System.out.println(t1.getThreadGroup().getName());
		System.out.println(t1.getThreadGroup().getParent().getName());
		ThreadGroup tg=new ThreadGroup("First");
		Thread t2=new Thread(tg, "thread 2");
		System.out.println(t2.getThreadGroup().getName());
		System.out.println(t2.getThreadGroup().getParent().getName());
		System.out.println(t2.getPriority());
		tg.setMaxPriority(3);
		System.out.println(t2.getPriority());
		Thread t3=new Thread(tg,"Third");
		System.out.println(t3.getPriority());
		ThreadGroup tg1=new ThreadGroup(tg, "Second");
		System.out.println(tg.getParent().getName());
	}

}
