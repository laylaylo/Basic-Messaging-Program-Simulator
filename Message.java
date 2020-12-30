
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package elements;

/**
 * Represents a message.
 * @author leylayayladere
 * @version 1.0
 */
public class Message {
	
	/**
	 * <i>Static<i> number of total messages in the program.
	 */
	static int numOfMessages=0;
	/**
	 * <i>Unique<i> <code>id</code> of each <code>Message</code>.
	 */
	private int id; 
	/**
	 * Text of this <code>Message</code>.
	 */
	private String body;
	/**
	 * Sender of this <code>Message</code>.
	 */
	private User sender;
	/**
	 * Receiver of this <code>Message</code>.
	 */
	private User receiver;
	/**
	 * Time stamp sending of this <code>Message</code>.
	 */
	private int timeStampSent;
	/**
	 * Time stamp reading of this <code>Message</code>.
	 */
	private int timeStampRead;
	/**
	 * Time stamp receiving of this <code>Message</code>.
	 */
	private int timeStampReceived;
	
	/**
	 * Creates a <code>Message</code> with specified parameters.
	 * @param sender <code>User</code> who sends the <code>Message</code>.
	 * @param receiver <code>User</code> who receives the <code>Message</code>.
	 * @param body Text content of <code>Message</code>.
	 * @param server Functions as the mechanism where all non-received messages are stored.
	 * @param time Stamp time sending of <code>Message</code>.
	 */
	public Message(User sender, User receiver, String body, Server server, int time) {
		this.setSender(sender);
		this.setReceiver(receiver);
		this.setBody(body);
		this.setTimeStampSent(time); 
		this.setID(numOfMessages);
		numOfMessages++;
		server.getMsgs().add(this); 
	}
	
	/**
	 * Retrieves the value of time stamp sending.
	 * @return An integer data type.
	 */
	public int getTimeStampSent() {
		return this.timeStampSent;
	}
	
	/** 
	 * Sets the value of time stamp sending.
	 * @param timeStampSent A variable of type integer.
	 */
	public void setTimeStampSent(int timeStampSent) {
		this.timeStampSent = timeStampSent;
	}
	
	/**
	 * Retrieves the value of time stamp reading.
	 * @return An integer data type.
	 */
	public int getTimeStampRead() {
		return this.timeStampRead;
	}

	/** 
	 * Sets the value of time stamp reading.
	 * @param timeStampRead A variable of type integer.
	 */
	public void setTimeStampRead(int timeStampRead) {
		this.timeStampRead = timeStampRead;
	}
	
	/**
	 * Retrieves the value of time stamp receiving.
	 * @return An integer data type.
	 */
	public int getTimeStampReceived() {
		return this.timeStampReceived;
	}

	/** 
	 * Sets the value of time stamp receiving.
	 * @param timeStampReceived A variable of type integer.
	 */
	public void setTimeStampReceived(int timeStampReceived) {
		this.timeStampReceived = timeStampReceived;
	}
	
	/**
	 * Retrieves the value of an <code>id</code>.
	 * @return An integer data type.
	 */
	public int getID( ) {
		return this.id;
	}
	
	/** 
	 * Sets the value of an <code>id</code>.
	 * @param id A variable of type integer.
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * Retrieves the value of a <code>body</code> of this <code>Message</code>.
	 * @return A String data type.
	 */
	public String getBody() {
		return this.body;
	}
	
	/** 
	 * Sets the value of a <code>body</code> of this <code>Message</code>.
	 * @param body A variable of type String.
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	/**
	 * If this <code>Message</code> is longer than <code>o</code>, return 
	 * positive number. Else if the <code>o</code> is longer, return negative number. Return 0 if both 
	 * messages have the same number of characters.
	 * @param o Compared <code>Message</code>.
	 * @return An integer data type. 
	 */
	public int compareTo(Message o) {
		if(this.body.length() > o.body.length()) {
			return 1;
		}else if(this.body.length() < o.body.length()){
			return -1;
		}else{
			return 0;
		}
	}
	
	/**
	 * Checks this <code>Message</code> whether is equal to object <code>o</code> or not.
	 * @param o Object which will be checked whether is equal to this <code>Message</code> or not.
	 * @return A boolean data type. True if they are equal, false they are not.
	 */
	public boolean equals(Object o) {
		if(o instanceof Message) {
			if(this.getID() == ((Message) o).getID()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}

	}
	
	/**
	 * Forms information about this <code>Message</code>.
	 * @return A String data type.
	 */
	public String toString() {
		String form = "\tFrom: " + this.getSender().getId() + " To: " + this.getReceiver().getId()	+ "\n\tReceived: ";
		if(this.getTimeStampReceived() != 0) {
			form += this.getTimeStampReceived();
		}
		form += " Read: ";
		if(this.getTimeStampRead() != 0) {
			form += this.getTimeStampRead();
		}
		form += "\n\t" + this.getBody();
		
		return form;
	}

	/**
	 * Retrieves the value of a <code>sender</code> of this <code>Message</code>.
	 * @return An object <code>User</code> data type.
	 */
	public User getSender() {
		return sender;
	}

	/** 
	 * Sets the value of an <code>sender</code> of this <code>Message</code>.
	 * @param sender A variable of type object <code>User</code>.
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}

	/**
	 * Retrieves the value of a <code>receiver</code> of this <code>Message</code>.
	 * @return An object <code>User</code> data type.
	 */
	public User getReceiver() {
		return receiver;
	}
	
	/** 
	 * Sets the value of an <code>receiver</code> of this <code>Message</code>.
	 * @param receiver A variable of type object <code>User</code>.
	 */
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

