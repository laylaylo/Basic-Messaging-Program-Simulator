
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package boxes;

import elements.User;

/**
 * Represents a parent box class includes inbox and outbox.
 * @author leylayayladere
 * @version 1.0
 */
public class Box {
	
	/**
	 * Owner of this <code>Box</code>.
	 */
	private User owner;
	
	/**
	 * Creates a <code>Box</code> with specified <code>owner</code>.
	 * @param owner <code>User</code> of this <code>Box</code>.
	 */
	public Box(User owner) {
		this.setOwner(owner);
	}

	/**
	 * Retrieves the value of <code>owner</code>.
	 * @return An object <code>User</code> data type.
	 */
	public User getOwner() {
		return owner;
	}
	
	/** 
	 * Sets the value of <code>owner</code> of this <code>Box</code>.
	 * @param owner A variable of type object <code>User</code>.
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

