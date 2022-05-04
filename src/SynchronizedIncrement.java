import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SynchronizedIncrement {
	
	public static int counter;
	
	public static void main(String[] args) throws InterruptedException {
		List<Thread> allThreads = new ArrayList<>();
		
		var numberOfIncrements = 1000;
		
		for (int i = 0; i < numberOfIncrements; i++) {
			var t = new Thread(SynchronizedIncrement::increment);
			allThreads.add(t);
			t.start();
		}
		
		for (Thread thread : allThreads) {
			thread.join();
		}
		
		// with the synchronized keyword always the result is 1000
		System.out.println(counter);
	}
	
	// synchronized keyword added to this critical method
	private synchronized static void increment() {
		counter++;
	}
}
