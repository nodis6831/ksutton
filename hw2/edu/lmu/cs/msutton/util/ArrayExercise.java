package edu.lmu.cs.msutton.util;

/**
 * 
 * @author Garrett Shannon
 * @author Kelly Sutton
 * 
 */
public class ArrayExercise {

	/**
	 * First of all swap is complete crap because you are passing a copy of the
	 * array unless a is static which it isnt. Why does this book suck so much?
	 * un-w00t. Second of all n needs to stop at the halfway point of the array;
	 * as it is written now the code reverses the array and then reverses it
	 * back to the way it was. The new code simply returns a new array by
	 * copying the contents of the original array into the new array in reverse
	 * order.
	 */
	public int[] reverse(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[a.length - i - 1] = a[i];
		}
		return b;
	}

}
