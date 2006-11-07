package edu.lmu.cs.msutton.util;

import java.util.Arrays;

/**
 * This class holds the answers to Exercise 3.9 and Problem 3.17
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
	public static int[] reverse(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[a.length - i - 1] = a[i];
		}
		return b;
	}

	/**
	 * As of right now, the best way we can think of to do this is to iterate
	 * through the array and count up the number of times the specified number
	 * occurs.
	 */
	public static int frequency(int[] a, int value) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == value)
				count++;
		}
		return count;
	}

	public static int partition(int[] a) {
		int pivot = a[0];
		int i = 1;
		int j = a.length - 1;
		int temp;

		while (i < j) {
			// Swaps a[i] and a[j] when a[i] > pivot and a[j] < pivot. Numbers
			// equal to the pivot are considered to be greater.
			if (a[i] > pivot && a[j] <= pivot) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				System.out.println(Arrays.toString(a));
				i++;
				j--;
			}
			while (a[i] <= pivot || a[j] > pivot) {
				if (i > a.length - 1 || j < 0)
					throw new IllegalStateException();
				if (a[j] >= pivot)
					j--;
				else
					i++;
			}

		}

		// Swaps a[0] and a[j]. Note this part is useless if all you need to do
		// is return the index because you know what the index of the first
		// number in the array needs to be so there is no point in actually
		// moving it there.

		temp = a[0];
		a[0] = a[i - 1];
		a[i - 1] = temp;
		System.out.println(Arrays.toString(a));
		return i - 1;

	}
}
