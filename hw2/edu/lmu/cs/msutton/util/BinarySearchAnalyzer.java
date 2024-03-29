package edu.lmu.cs.msutton.util;

import java.util.Arrays;
import java.util.Random;

/**
 * Project 3.1
 * @author Kelly Sutton
 * @author Garret Shannon
 */

/**
 * Write a program that empirically tests the theta(log n) complexity of the
 * binary search algorithm. For various array sizes n, generate a random array
 * of integers in the range 0 to 2n. (Thus, about half the numbers in that range
 * will be in the array, with possible duplication.) For each of these arrays,
 * sort the array, and then run the binary search for the target t, for each t
 * from 0 to 2n. On each of these runs, count the number k of iterations of the
 * algorithm's while loop. For each n, print n, the average of the 2n values of
 * k, and the value of log n. (The expresseion Math.log(n)/Math.log(2) returns
 * the binary logarithm of n.)
 * 
 * 
 */

public class BinarySearchAnalyzer {

	private static int[] randArray; // These need to be static so main() can

	// look at them

	private static int n = 1;

	public static void main(String[] args) {

		System.out.println("   n     average   log(n)");
		System.out.println("-------  ------- --------");

		while (true) {

			randArray = fillArrayWithIntsAndSort(randArray, n);// creating an
			// array
			// of size 2n
			int currentSearches = 0; // this will be divided by n later to
			// get the average
			for (int t = 0; t < 2 * n; t++) { // run the binary search, t is
				// the target
				// TODO fill with the s-word that needs to get done. Ask Ray.
				if (doBinarySearch(randArray, t) >= 0)
					currentSearches += doBinarySearch(randArray, t);
			}

			double average = (double) currentSearches / (2 * n);

			printResults(n, average); // prints n, the average, and binary log
			// of n
			n *= 2;// doubling n for the next run
		}
	}

	private static int[] fillArrayWithIntsAndSort(int[] a, int size) {

		int[] returnArray = new int[size];
		Random randIntGenerator = new Random();

		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = randIntGenerator.nextInt(size * 2);// filling the
			// array with
			// random ints
		}

		Arrays.sort(returnArray);// sorting the array in the proper order

		return returnArray;
	}

	/**
	 * Copied from the book, p. 86
	 * 
	 * @param a
	 * @param t
	 * @return the count of steps it took to complete the binary search
	 */
	private static int doBinarySearch(int[] a, int t) {

		int p = 0;
		int q = a.length - 1;

		while (p <= q) {// search the segment a[p..q]
			int i = (p + q) / 2; // index of element in the middle
			if (a[i] == t)
				return i;
			if (a[i] < t)
				p = i + 1; // search upper half
			else
				q = i - 1; // search lower half
		}

		return -p - 1; // not found
	}

	/**
	 * This is its separate function to reduce clutter and to make better once
	 * we figure out some formatting stuff
	 * 
	 * @param n
	 * @param ave
	 */
	private static void printResults(int n, double ave) {
		double log = Math.log(n) / Math.log(2);
		//System.out.println(n + "  " + ave + "  " + (Math.log(n) / Math.log(2)));
		System.out.printf( "%-7d  %-1.6f %-1.1f\n", n, ave, log);
	}

}
