
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package elements;

import java.io.File;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a server.
 * @author leylayayladere
 * @version 1.0
 */
public class Server {
	
	/**
	 * Capacity of this <code>Server</code>.
	 */
	private long capacity;
	/**
	 * Current size of this <code>Server</code>.
	 */
	private long currentSize;
	/**
	 * Keeps track of all messages which are currently sent but not received. 
	 */
	private Queue<Message> msgs = new LinkedList<Message>();
	/**
	 * In order to check warning is made only once when %50 is achieved.
	 */
	boolean fifty = true;
	/**
	 * In order to check warning is made only once when %80 is achieved.
	 */
	boolean eighty = true; 
	
	/**
	 * Creates a <code>Server</code> with specified <code>capacity</code>.
	 * @param l <i>Unique<i> <code>capacity</code> of this <code>Server</code>.
	 */
	public Server(long capacity) {	
		this.capacity = capacity;
		this.setCurrentSize(0);

	}
	
	/**
	 * Prints the warnings about the <code>capacity</code>.
	 * @param printer Warnings are printed via this PrintStream. 
	 */
	public void checkServerLoad(PrintStream printer) {
		
		if(this.getCurrentSize() < this.getCapacity()/2) {
			fifty = true;
			eighty = true;
		}	
		if(this.getCurrentSize() >= this.getCapacity()/2. && this.getCurrentSize() < this.getCapacity()/100.*80) {
			if(fifty) {
				printer.println("Warning! Server is 50% full.");
				fifty = false;
				eighty = true;
			}
		}
		if(this.getCurrentSize() >= this.getCapacity()/100.*80 && this.getCurrentSize() < this.getCapacity()) {
			if(eighty) {
				printer.println("Warning! Server is 80% full.");
				eighty = false;
				fifty = true;
			}
		}
		if(this.getCurrentSize() >= this.getCapacity()) {
			printer.println("Server is full. Deleting all messages...");
			this.flush();
		}
	}
	
	/**
	 * Retrieves the value of an <code>currentSize</code> of this <code>Server</code>.
	 * @return A long data type.
	 */
	public long getCurrentSize() {
		return this.currentSize;
	}
	
	/** 
	 * Sets the value of an <code>currentSize</code> of this <code>Server</code>.
	 * @param l A variable of type long.
	 */
	public void setCurrentSize(long l) {
		this.currentSize = l;
	}
	
	/**
	 * Retrieves the value of an <code>capacity</code> of this <code>Server</code>.
	 * @return A long data type.
	 */
	public long getCapacity() {
		return this.capacity;
	}
	
	/** 
	 * Sets the value of an <code>capacity</code> of this <code>Server</code>.
	 * @param l A variable of type long.
	 */
	public void setCapacity(long l) {
		this.capacity = l;
	}
	
	/**
	 * Empties <code>msgs</code> <i>queue<i>.
	 */
	public void flush() {
		this.getMsgs().clear();
		this.setCurrentSize(0);
		this.fifty = true;
		this.eighty = true;
	}

	/**
	 * Retrieves the value of an  a <code>msgs</code> <i>queue<i>.
	 * @return A queue data type.
	 */
	public Queue<Message> getMsgs() {
		return msgs;
	}

	/** 
	 * Sets the value of a <code>msgs</code> <i>queue<i>.
	 * @param msgs A variable of type queue.
	 */
	public void setMsgs(Queue<Message> msgs) {
		this.msgs = msgs;
	}
	
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

