package waitNotify;

public class Demo {
	
	public static void main(String[] args) throws InterruptedException{
		Message message = new Message("process it");
		Reader reader1 = new Reader(message);
		
		new Thread(reader1,"REDEAR 1 ").start();;
		
		Reader reader2 = new Reader(message);
		new Thread(reader2,"REDEAR 2 ").start();;
		
		Notifier notifier = new Notifier(message);
		new Thread(notifier, "NOTIFIER ").start();
		
		System.out.println("All the threads are started");
	}
}
