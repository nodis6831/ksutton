package edu.lmu.cs.ksutton.cmsi282.hw2;

import java.util.Random;

public class Select {

	public static void main(String args[]) {

		int nth = Integer.parseInt(args[0]);

		int[] a = NumberReader.readIntsAsArrayFromFile(args[1]);

		int b = partition(a, --nth);// getting back a partitioned enough array

		System.out.println(b);// reading the correct element to stdo

	}

	/**
	 * Modifies array a such that the value of a[0] before modification is
	 * placed at some index j with all items less than or equal to this value
	 * are to its left, and all items greater than it are to its right; returns
	 * j.
	 */
	public static int partition(int[] a, int nth) {
		
		if (nth <= 0 || a.length == 0){
			System.out.println(nth + " " + a.length);
			throw new IllegalArgumentException();
		}
		
		
		
		Random generator = new Random();

		int pivot = generator.nextInt(a.length);
		swap(a, 0, pivot);
		
		if (a.length == 0)
			return 0;
		int value = a[0];
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			while (a[j] > value)
				j--;
			while (i < j && a[i] <= value)
				i++;
			if (i < j) {
				swap(a, i, j);
			}
		}
		swap(a, 0, j);
		
		//TODO comments beyotch!
		
		if (j == nth)
			return a[j];//we've found it
		
		else if (j > nth) 
			return partition(splitIntArray(a, 0, j), nth);
		
		else
			return partition(splitIntArray(a, i, a.length - 1), nth - i);
		
		//return j;
	}

	// Helper routine to swap array items.
	private static void swap(int[] a, int i, int j) {
		int oldi = a[i];
		int oldj = a[j];
		a[i] = oldj;
		a[j] = oldi;
	}

	/**
	 * Returns a new array between i and j
	 * 
	 * @param a
	 *            The array to be split
	 * @param i
	 *            The beginning index
	 * @param j
	 *            The end index
	 * @return
	 */
	private static int[] splitIntArray(int[] a, int i, int j) {

		int[] newArray = new int[j - i + 1];

		for (int z = 0; z < newArray.length; z++) {
			newArray[z] = a[i];
			i++;
		}

		return newArray;

	}
}
