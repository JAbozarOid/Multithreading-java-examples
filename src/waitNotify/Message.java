package waitNotify;

public class Message {

	// String object is an immutable object, once create object of type string I can't change it's state
	private String message;
	
	public Message(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
