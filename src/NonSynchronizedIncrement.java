import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NonSynchronizedIncrement {
	
	public static int counter;
	
	public static void main(String[] args) throws InterruptedException {
		List<Thread> allThreads = new ArrayList<>();
		
		var numberOfIncrements = 1000;
		
		for (int i = 0; i < numberOfIncrements; i++) {
			var t = new Thread(NonSynchronizedIncrement::increment);
			allThreads.add(t);
			t.start();
		}
		
		for (Thread thread : allThreads) {
			thread.join();
		}
		
		/**
		 * when all threads did incremented we can print our variable
		 * if run the program multiple times the result is not always 1000!! and it is an issue
		 * That's because at some moment of time two threads enter this method simultaneously and both thread read the same value of counter variable and each thread might increment
		 * In fact one thread overwrite increment result from other thread and we got lost update
		 * How to solve this issue?
		 * we need to synchronized access of different threads to our critical section where we are perform nonAtomic operation
		 * To solve this issue we need to control concurrent access to the critical area the key is "Synchronized keyword"
		 * Please see the class SynchronizedIncrement.java
		 */
		
		System.out.println(counter);
	}
	
	// this method is a critical section
	private static void increment() {
		counter++;
	}
}
