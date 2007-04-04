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

	private void addAdjacents(Schoolgirl row) {

		Assert.assertTrue(row.length == 3);

		// this nastiness logs the students walking next to each other
		for (int i = 0; i < 2; i++) {
			SchoolSolver.hasStoodNextTo[row[i]][row[i + 1]] = true;
			SchoolSolver.hasStoodNextTo[row[i + 1]][row[i]] = true;
		}

		// logging that we've used this girl already today
		for (int j = 0; j < 3; j++) {
			SchoolSolver.usedToday[j] = true;
		}
	}

	/**
	 * Flips the values to false for the corresponding cells in hasStoodNextTo
	 * 
	 * @param oneRow
	 */
	private void eraseAdjacents(Schoolgirl row) {

		assert row.length == 3;

		// this nastiness undoes addAdjacents
		for (int i = 0; i < 2; i++) {
			SchoolSolver.hasStoodNextTo[row[i]][row[i + 1]] = false;
			SchoolSolver.hasStoodNextTo[row[i + 1]][row[i]] = false;
		}

		for (int j = 0; j < 3; j++) {
			SchoolSolver.usedToday[j] = false;
		}
	}

}
