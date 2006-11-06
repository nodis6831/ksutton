package edu.lmu.cs.msutton.business;

/**
 * Queue interface as copied from the Data Structures book
 * 
 * The <code>Queue</code> interface specifies the basic operations of FIFO
 * containers
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

public interface Queue {

	/**
	 * Adds the specified element to the back of this queue
	 * 
	 * @param object the element to be added to this queue
	 */
	public void add(Object object);
	
	/**
	 * Returns the element at the front of this queue
	 * 
	 * @return the element at the front of this queue
	 * @throws IllegalStateException if this queue is empty
	 */
	public Object first();
	
	/**
	 * Removes and returns the element at the front of this queue.
	 * 
	 * @return the element at the front of this queue
	 * @throws IllegalStateException if this queue is empty
	 */
	public Object remove();
	
	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of element in this queue.
	 */
	public int size();
	
	
}
