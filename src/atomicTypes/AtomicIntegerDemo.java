package atomicTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
	
	public static AtomicInteger counter = new AtomicInteger();
	
	public static void main(String[] args) throws InterruptedException {
		List<Thread> allThreads = new ArrayList<>();
		
		var numberOfIncrements = 1000;
		
		for (int i = 0; i < numberOfIncrements; i++) {
			var t = new Thread(AtomicIntegerDemo::increment);
			allThreads.add(t);
			t.start();
		}
		
		for (Thread thread : allThreads) {
			thread.join();
		}
		
		
		System.out.println(counter);
	}
	
	// this method does not have synchronize keyword and even synchronize block but it is thread safe and secure from any multithreading issues
	// because the counter type is atomic integer that support thread safe operations
	private static void increment() {
		counter.incrementAndGet();
	}
	

}
