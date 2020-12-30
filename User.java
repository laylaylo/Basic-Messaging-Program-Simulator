
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package elements;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

import boxes.Inbox;
import boxes.Outbox;

/**
 * Represents a user.
 * @author leylayayladere
 * @version 1.0
 */
public class User {
	
	/**
	 * <i>Unique<i> <code>id</code> of each <code>User</code>.
	 */
	private int id;
	/**
	 * Inbox object belongs to this <code>User</code>.
	 */
	private Inbox inbox;
	/**
	 * Outbox object belongs to this <code>User</code>.
	 */
	private Outbox outbox;
	/**
	 * Keeps track of all users who are currently friends with this <code>User</code>.
	 */
	private ArrayList<User> friends = new ArrayList<User>();
	
	/**
	 * Creates a <code>User</code> with specified <code>id</code>.
	 * @param id <i>Unique<i> <code>id</code> of this <code>User</code>.
	 */
	public User(int id) {	
		this.setId(id);
		this.inbox = new Inbox(this);
		this.outbox = new Outbox(this);
	}
	
	/**
	 * Adds <code>User</code> <code>other</code> to <code>friends</code> <i>list<i> of this <code>User</code> and vice versa.
	 * @param other <code>User</code> who become friend with this <code>User</code>.
	 */
	public void addFriend(User other) {
		this.getFriends().add(other);
		other.getFriends().add(this);
	}
	
	/**
	 * Removes <code>User</code> <code>other</code> from <code>friends</code> <i>list<i> of this <code>User</code> and vice versa.
	 * @param other <code>User</code> who ends friendship with this <code>User</code>.
	 */
	public void removeFriend(User other) {
		this.getFriends().remove(other);
		other.getFriends().remove(this);
	}
	

	/**
	 * Checks this <code>User</code> whether is friend with <code>other</code> <code>User</code> or not. 
	 * @param other <code>User</code> who will be checked whether is friend with this <code>User</code> or not.
	 * @return A boolean data type. True if this <code>User</code> is friend with <code>other</code> <code>User</code>, false if she/he is not.
	 */
	public boolean isFriendWith(User other) {	
		if(this.getFriends().contains(other)) { 
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Sends <code>Message</code> which contains <code>body</code> text from this <code>User</code> to <code>receiver</code> through <code>server</code>.
	 * @param receiver <code>User</code> who receives <code>Message</code>.
	 * @param body Text content of <code>Message</code>.
	 * @param time Stamp time sending of <code>Message</code>.
	 * @param server Functions as the mechanism where all non-received messages are stored.
	 */
	public void sendMessage(User receiver, String body, int time, Server server) {
		Message m = new Message(this, receiver, body, server, time);
		this.getOutbox().getSent().add(m);
		server.setCurrentSize(server.getCurrentSize() + m.getBody().length());
	}

	/**
	 * Retrieves the value of an <code>id</code>.
	 * @return An integer data type.
	 */
	public int getId() {
		return id;
	}

	/** 
	 * Sets the value of an <code>id</code>.
	 * @param id A variable of type integer.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieves the value of a <code>inbox</code> of this <code>User</code>.
	 * @return An object <code>Inbox</code> data type.
	 */
	public Inbox getInbox() {
		return inbox;
	}

	/** 
	 * Sets the value of an <code>inbox</code> of this <code>User</code>.
	 * @param inbox A variable of type object <code>Box</code>.
	 */
	public void setInbox(Inbox inbox) {
		this.inbox = inbox;
	}

	/**
	 * Retrieves the value of a <code>outbox</code> of this <code>User</code>.
	 * @return An object <code>Outbox</code> data type.
	 */
	public Outbox getOutbox() {
		return outbox;
	}


	/** 
	 * Sets the value of an <code>outbox</code> of this <code>User</code>.
	 * @param outbox A variable of type object <code>Box</code>.
	 */
	public void setOutbox(Outbox outbox) {
		this.outbox = outbox;
	}

	/**
	 * Retrieves the value of a <code>friends</code> <i>list<i>.
	 * @return A list data type.
	 */
	public ArrayList<User> getFriends() {
		return friends;
	}

	/** 
	 * Sets the value of a <code>friends</code> <i>list<i>.
	 * @param friends A variable of type list.
	 */
	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}
	
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

