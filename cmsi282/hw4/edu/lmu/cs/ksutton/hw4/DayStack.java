package edu.lmu.cs.ksutton.hw4;

import java.util.Stack;

public class DayStack extends Stack<RowStack> {

	/**
	 * Each day needs its own queue. We can't have clones!
	 */
	private SchoolgirlQueue queue;
	
	/**
	 * Constructor that sizes the queue correctly
	 * @param girls Number of girls to be added to the queue
	 */
	public DayStack(int girls){
		queue = new SchoolgirlQueue(girls); 
	}
	
	public SchoolgirlQueue getSchoolgirlQueue(){
		return queue;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Stack#pop()
	 */
	/**
	 * I'm adding in some safety to make sure that we always reset the
	 * hasStoodNextTo table in case of a pop
	 */
	@Override
	public synchronized RowStack pop() {

		// while (peek().peek() != null) { // peek().peek() is an Integer[]
		// peek().pop(); // popping things off one at a time,
		// guaranteeing our table will be reset
		// }
		return super.pop();
	}

}
