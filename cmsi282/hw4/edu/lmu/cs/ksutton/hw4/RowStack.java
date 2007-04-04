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
		addAdjacents(item);
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
		eraseAdjacents(peek());
		return super.pop();
	}

	private void addAdjacents(Schoolgirl girl) {

		// this nastiness logs the students walking next to each other
		for (Schoolgirl s : (Schoolgirl[]) this.toArray()) {
			SchoolSolver.hasStoodNextTo[girl.getIndex()][s.getIndex()] = true;
			SchoolSolver.hasStoodNextTo[s.getIndex()][girl.getIndex()] = true;
		}
	}

	/**
	 * Flips the values to false for the corresponding cells in hasStoodNextTo
	 * 
	 * @param oneRow
	 */
	private void eraseAdjacents(Schoolgirl girl) {
		
		// this nastiness undoes addAdjacents
		for (Schoolgirl s : (Schoolgirl[]) this.toArray()) {
			SchoolSolver.hasStoodNextTo[girl.getIndex()][s.getIndex()] = false;
			SchoolSolver.hasStoodNextTo[s.getIndex()][girl.getIndex()] = false;
		}
	}
}
