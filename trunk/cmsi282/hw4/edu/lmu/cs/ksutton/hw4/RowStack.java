package edu.lmu.cs.ksutton.hw4;

import java.util.Stack;

import org.junit.Assert;

public class RowStack extends Stack<Schoolgirl> {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Stack#push(java.lang.Object)
	 */
	@Override
	public Schoolgirl push(Schoolgirl item) {
		//addAdjacents(item);
		return super.push(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Stack#pop()
	 */
	@Override
	public synchronized Schoolgirl pop() {
		// TODO this should reverse any changes made to hasStoodNextTo
		//eraseAdjacents(peek());
		return super.pop();
	}

	/* (non-Javadoc)
	 * @see java.util.Vector#toString()
	 */

	@Override
	public synchronized String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
