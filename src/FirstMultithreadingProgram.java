
public class FirstMultithreadingProgram extends Thread {
	
	public static void main(String[] args) {
		
		// different kind of definition thread
		// 1-
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("I'm a new thread! My name is t1" + Thread.currentThread().getName());
				
			}
		});
		
		// 2-
		Thread t2 = new FirstMultithreadingProgram();
		
		// 3- lambda expression 
		Thread t3 = new Thread(() -> System.out.println("I'm a new thread! My name is t3" + Thread.currentThread().getName()));
		
		// 4- 
		Thread t4 = new Thread(FirstMultithreadingProgram::execute);
		
		
		System.out.println("Current thread name is " + Thread.currentThread().getName());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
	
	public static void execute() {
		System.out.println("I'm a new thread! My name is t4" + Thread.currentThread().getName());
	}
	
	@Override
	public void run() {
		System.out.println("I'm a new thread! My name is from override run method" + Thread.currentThread().getName());
	}

}
