
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package boxes;

import java.io.PrintStream;
import java.util.Iterator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import elements.Message;
import elements.Server;
import elements.User;

/**
 * Represents an inbox.
 * @author leylayayladere
 * @version 1.0
 */
public class Inbox extends Box {
	
	/**
	 * Keeps track of all messages which are currently received but not read. 
	 */
	private Stack<Message> unread = new Stack<Message>();
	/**
	 * Keeps track of all messages which are read. 
	 */
	private Queue<Message> read = new LinkedList<Message>();
	
	/**
	 * Creates a <code>Inbox</code> with specified <code>owner</code>.
	 * @param owner <code>User</code> of this <code>Inbox</code>.
	 */
	public Inbox(User owner) {
		super(owner);
	}
	
	/**
	 * Receives messages only which are sent from friends via <code>Server</code>.
	 * @param server Functions as the mechanism where all non-received messages are stored.
	 * @param time Stamp time receiving of the messages.
	 */
	public void receiveMessages(Server server, int time) {
		
		Iterator<Message> itr = server.getMsgs().iterator();	
		
		while(itr.hasNext()) {
			Message m = itr.next();
			if(m.getReceiver().getInbox().equals(this)) {
			if(m.getReceiver().isFriendWith(m.getSender())) {		
				unread.push(m);
				m.setTimeStampReceived(time);
				server.setCurrentSize(server.getCurrentSize() - m.getBody().length());			
				itr.remove();
				}
			}		
		}
		
	}
	
	/**
	 * Reads required number of messages.
	 * @param num Required number of messages.
	 * @param time Stamp time reading of the <code>Message</code>.
	 * @return An integer data type.
	 */
	public int readMessages(int num, int time) {
		
		int numOfMsgs = 0;
		
		if(num == 0) {
			while(!unread.empty()) {
				Message m = unread.pop();
				this.getRead().add(m);
				m.setTimeStampRead(time);
				time++;
				numOfMsgs++;
			}
		}
		
		while(num != 0) {
			if(!unread.empty()) {
				Message m = unread.pop();
				this.getRead().add(m);
				m.setTimeStampRead(time);
				time++;
				numOfMsgs++;
			}
			num--;
		}

		if(numOfMsgs > 1) {
			return numOfMsgs;
		}else{
			return 1;
		}
	}
	
	/**
	 * Reads messages which are sent from specified <code>User</code>.
	 * @param sender Required <code>User</code> who sent messages.
	 * @param time Stamp time reading of the <code>Message</code>.
	 * @return An integer data type.
	 */
	public int readMessages(User sender, int time) { 
		
		int numOfMsgs = 0;
		Stack<Message> temp = new Stack<Message>();
		
		while(!this.getUnread().empty()) {
			Message m = unread.pop();
			if(m.getSender().getId() == sender.getId()) {
				numOfMsgs++;
				this.getRead().add(m);
				m.setTimeStampRead(time);
				time++;
			}else {
				temp.add(m);
			}
		}
		
		while(!temp.empty()) {
			Message m = temp.pop();
			this.getUnread().add(m);
		}
		
		if(numOfMsgs > 1) {
			return numOfMsgs;
		}else{
			return 1;
		}
	}
	
	/**
	 * Reads a <code>Message</code> with specified id.
	 * @param msgId Id of the <code>Message</code>.
	 * @param time Stamp time reading of the <code>Message</code>.
	 */
	public void readMessage(int msgId, int time) {
		
		Stack<Message> temp = new Stack<>();
		
		while(!unread.empty()) {
			Message m = unread.pop();
		
			if(m.getID() == msgId) {
				m.setTimeStampRead(time);
				this.getRead().add(m);
				break;
			}
			temp.push(m);
		}
		
		while(!temp.empty()) {
			Message m = temp.pop();
			unread.push(m);
		}		

	}
	
	/**
	 * Retrieves the value of a <code>unread</code> <i>stack<i>.
	 * @return A stack data type.
	 */
	public Stack<Message> getUnread() {
		return this.unread;
	}
	
	/** 
	 * Sets the value of a <code>unread</code> <i>stack<i>.
	 * @param unread A variable of type stack.
	 */
	public void setRead(Stack<Message> unread) {
		this.unread = unread;
	}

	/**
	 * Retrieves the value of a <code>read</code> <i>queue<i>.
	 * @return A queue data type.
	 */
	public Queue<Message> getRead() {
		return this.read;
	}

	/** 
	 * Sets the value of a <code>read</code> <i>queue<i>.
	 * @param read A variable of type queue.
	 */
	public void setRead(Queue<Message> read) {
		this.read = read;
	}
	
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

