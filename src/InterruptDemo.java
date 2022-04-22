import java.util.concurrent.TimeUnit;


public class InterruptDemo implements Runnable {
	
	public static void main(String[] args) throws InterruptedException {
		
		InterruptDemo runnableTask = new InterruptDemo();
		Thread thread = new Thread(runnableTask);
		thread.start();
		
		Thread.sleep(2000);
		
		System.out.println("in main() - interrupting other thread");
		thread.interrupt();
		
		thread.join();
		System.out.println("in main() leaving");
	}

	@Override
	public void run() {
		try {
			System.out.println("in run - about to work()");
			work();
			System.out.println("in run - back from work() - this line will not be executed");
		} catch (Exception e) {
			System.out.println("in run - interrupted in work() ");
			return;
		}
		System.out.println("in run() - doing stuff after nap");
		System.out.println("in run() - leaving normally");
		
	}
	
	public void work() throws InterruptedException {
		while(true) {
			System.out.println("working .... ");
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("isInterrupted() = " + Thread.currentThread().isInterrupted());
				
				TimeUnit.MILLISECONDS.sleep(1);
				
				System.out.println("this line won't be executed");
			}
		}
	}
}
