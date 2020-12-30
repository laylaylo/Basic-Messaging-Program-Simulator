
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package boxes;

import java.util.LinkedList;
import java.util.Queue;

import elements.Message;
import elements.User;

/**
 * Represents an outbox.
 * @author leylayayladere
 * @version 1.0
 */
public class Outbox extends Box {
	
	/**
	 * Keeps track of all messages which are sent. 
	 */
	private Queue<Message> sent = new LinkedList<Message>();
	
	/**
	 * Creates a <code>Outbox</code> with specified <code>owner</code>.
	 * @param owner <code>User</code> of this <code>Outbox</code>.
	 */
	public Outbox(User owner) {
		super(owner);
	}

	/**
	 * Retrieves the value of a <code>sent</code> <i>queue<i>.
	 * @return A queue data type.
	 */
	public Queue<Message> getSent() {
		return sent;
	}

	/** 
	 * Sets the value of a <code>sent</code> <i>queue<i>.
	 * @param sent A variable of type queue.
	 */
	public void setSent(Queue<Message> sent) {
		this.sent = sent;
	}
	
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

