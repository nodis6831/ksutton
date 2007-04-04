package edu.lmu.cs.ksutton.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;

public class SchoolSolver {

	/**
	 * hasStoodNextTo is a table of past standings-next-to. A true value at
	 * hasStoodNextTo[i][j]indicates that schoolgirl number i has stood next to
	 * schoolgirl j.
	 * 
	 * hasStoodNextTo[i][j] == hasStoodNextTo[j][i]
	 */
	protected static boolean[][] hasStoodNextTo;

	/**
	 * usedToday is an array of booleans that keeps track of whether or not the
	 * girl has already been placed in a slot for the day.
	 */
	protected static boolean[] usedToday;

	/**
	 * rows is quite simply the organization of schoolgirls into their
	 * respective rows.
	 * 
	 * rows[i][j] represents the the ith row at position j. (i = {0, 1, 2, 3, 4}
	 * and j = {0, 1, 2})
	 */
	// private static RowStack rows;
	
	/**
	 * The week object is a stack of stacks of stacks. Each week holds its own
	 * days which then holds in own rows stack. The stacks inside a stack make
	 * it easy to backtrack.
	 */

	private static WeekStack week = new WeekStack();

	private static int nodes = 0;

	public static void main(String[] args) {

		hasStoodNextTo = fillMatrixWithFalse();

		boolean dayFailed = false;

		while (week.size() <= 7) { // 7 days

			// Add a new empty RowStack to our DayStack
			week.push(new DayStack(15));

			DayStack currentDay = week.peek();
			SchoolgirlQueue girlQueue = currentDay.getSchoolgirlQueue();
			while (currentDay.size() < 5) { // 5 rows

				// we need to pop back
				//  this should be rare or should never happen
				if (dayFailed) {
					week.pop();
					week.peek().peek().pop();
					week.peek().peek().add(week.peek().getSchoolgirlQueue().dequeue());
					
					dayFailed = false;
					break;
				}

				// try to add three schoolgirls
				// days.peek().push(tryToAddNewRow(new Integer[] { 0, 1, 2 }));

				RowStack currentRow = currentDay.peek();

				while (currentRow.size() < 3) { // 3 girls to a row

					// we've already been through the girls once
					if (girlQueue.getFlag() == true) {

						// the current row is no good
						if (currentDay.size() == 1) {
							dayFailed = true;
						}

						girlQueue.enqueue(currentDay.pop());

						// step one back one row and pop
						girlQueue.enqueue(currentDay.peek().pop());

						// when we break, we'll reset the currentRow and try to
						// add the next girl in the queue. Hopefully we can
						// avoid
						// a freak bug where we get caught in an infinite loop
						break;
					}

					currentRow.push(girlQueue.dequeue());

					if (isRowOkay(currentRow)) { // march on
						girlQueue.setFlag(false);
					}

					else { // pop off and try adding the next
						girlQueue.enqueue(currentRow.pop());
					}
				}
			}
			// usedToday = returnArrayFullOfFalse(15);
			girlQueue = new SchoolgirlQueue(15);
		}

		printResults(); // TODO update printResults
	}

	/**
	 * A private helper function to test and see if the girls have previously
	 * stood next to eachother.
	 * 
	 * @param a
	 *            Girl 1
	 * @param b
	 *            Girl 2
	 * @param c
	 *            Girl 3
	 * @return Returns a filled Integer array of size 3 with the girls,
	 *         otherwise it returns null
	 */
	private static Integer[] checkTheseGirls(int a, int b, int c) {

		if (!hasStoodNextTo[a][b] && !hasStoodNextTo[b][c] && !usedToday[a]
				&& !usedToday[b] && !usedToday[c])
			return new Integer[] { a, b, c };

		return null;
	}

	/**
	 * Tiny helper function to make sure none of our incrementers are the same
	 */
	/*
	 * private static void assertIncrementers(int i, int j, int k) {
	 * Assert.assertFalse(i == j); // failsafes Assert.assertFalse(j == k);
	 * Assert.assertFalse(k == i); }
	 */

	/**
	 * A recursive function that attempts to add new girls to the list. If it
	 * can't add the girl to the list, it calls itself again, incrementing the
	 * by the proper amount.
	 * 
	 * @param newRow
	 *            An int array of size 3
	 * @return
	 */
	/*
	private static Integer[] tryToAddNewRow(Integer[] newRow) {

		Integer[] attempt;

		for (int i = newRow[0], j = newRow[1], k = newRow[2]; i < 15 && j < 15
				&& k < 15;) {

			nodes++;

			if (usedToday[i] && i < 14)
				return tryToAddNewRow(new Integer[] { ++i, j, k });

			if (usedToday[j] && j < 14)
				return tryToAddNewRow(new Integer[] { i, ++j, k });

			if (usedToday[k] && k < 14)
				return tryToAddNewRow(new Integer[] { i, j, ++k });

			// whoops, j and k are equal
			if ((j == k || i == k) && k < 14)
				return tryToAddNewRow(new Integer[] { i, j, ++k });

			// assertIncrementers(i, j, k); // TODO make this smarter

			// we chose three that work
			if ((attempt = checkTheseGirls(i, j, k)) != null) {
				return attempt;
			}

			// we've reached the end of the line for k
			else if (k == 14 && j < 14) {
				return tryToAddNewRow(new Integer[] { i, ++j, i > 0 ? 0 : 1 });
			}

			// we need to increment i
			else if (j == 13 && k == 14) {
				return tryToAddNewRow(new Integer[] { ++i, 0, 1 });
			}

			// nothing's worked, we need to pop
			else if (i == 14 && j == 12 && k == 13) {

				// Pop off either a row or a day, depending on the case
				if (days.peek().size() > 1)
					days.peek().pop();

				else {
					days.pop();
					loadCurrentDaysPlacedSchoolgirls();
				}

				// Take the most recent row
				Integer[] peekArray = days.peek().peek();

				// Attempt to increment by 1
				tryToAddNewRow(new Integer[] { peekArray[0], peekArray[1],
						peekArray[2] + 1 });
			}

			else
				return tryToAddNewRow(new Integer[] { i, j, ++k });
			// TODO make sure I'm not missing any cases

		}

		return null;
	}
	*/

	private static boolean[][] fillMatrixWithFalse() {
		boolean[][] tmp = new boolean[15][15];

		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				tmp[i][j] = false;
			}
		}

		return tmp;
	}

	private static boolean[] returnArrayFullOfFalse(int size) {
		boolean[] tmp = new boolean[size];

		for (int i = 0; i < tmp.length; i++)
			tmp[i] = false;

		return tmp;
	}
	
	private static void printResults() {

		System.out.println(week);
		
		/*
		while (week.size() > 1) {
			System.out.println("Day " + Math.abs((days.size() - 8)));

			while (days.peek().size() > 0) {
				System.out.println(Arrays.toString(days.peek().pop()));
			}
			System.out.println();
			days.pop();
		}

		System.out.println(nodes);
		*/
	}

	/*
	private static void loadCurrentDaysPlacedSchoolgirls() {
		usedToday = returnArrayFullOfFalse(15);
		for (Integer[] a : days.peek()) {
			for (int i = 0; i < 3; i++) {
				usedToday[i] = true;
			}
		}
	}
	*/

	/**
	 * This messy private helper method returns whether or not r is a valid row
	 * 
	 * @param r
	 * @return
	 */
	private static boolean isRowOkay(RowStack r) {

		if (r.size() == 3) {
			if (hasStoodNextTo[r.elementAt(0).getIndex()][r.elementAt(1)
					.getIndex()]
					|| hasStoodNextTo[r.elementAt(1).getIndex()][r.elementAt(2)
							.getIndex()]
					|| hasStoodNextTo[r.elementAt(0).getIndex()][r.elementAt(2)
							.getIndex()])
				return false;
		}

		else if (r.size() == 2) {
			if (hasStoodNextTo[r.elementAt(0).getIndex()][r.elementAt(1)
					.getIndex()]
					|| hasStoodNextTo[r.elementAt(1).getIndex()][r.elementAt(0)
							.getIndex()])
				return false;
		}

		return true;
	}
}