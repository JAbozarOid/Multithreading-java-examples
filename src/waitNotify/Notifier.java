package waitNotify;

import java.util.concurrent.TimeUnit;

public class Notifier implements Runnable{

	private Message message;
	
	public Notifier(Message m) {
		this.message = m;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + "started");
		
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				synchronized (message) {
					message.setMessage(name + "Notifier work done");
					//message.notify(); // notify one thread that is in waiting queue
					message.notifyAll(); // notify all threads that are in waiting queue
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Notifier finished work");
	}
}
