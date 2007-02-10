package edu.lmu.cs.ksutton.cmsi282.hw2;

import java.util.Arrays;

public class Select {

	/**
	 * 
	 * @param a
	 *            the array
	 * @param nth
	 * 			  the nth smallest number that needs to be found
	 * @return the index j after partitioning the array so that all the elements
	 *         that are less than a[0] jave been moved left of position j and
	 *         all elements greater moved to the right and a[0] then moved to
	 *         position j
	 */
	private static int partition(int[] a, int nth) {
		
		if (nth > a.length)
			throw new IllegalArgumentException();
		
		Random generator = new Random();
		
		int pivot = generator.nextInt(a.length + 1);
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
		
		//return i - 1;//old way
		
		//new way
		if (i - 1 == nth) //we've found the nth smallest number 
			return a[i-1];
			
		else if (i-1 > nth) //j ended up on the left, j is our new 0, we adjust nth and recurse
			return partition(/*the array from j to a.length*/, a.length - nth); //divide and conquer
			
		else //j ended up on the right, we know that the nth is still somewhere on the left
			return partition(/*the array from 0 to */, nth);
			
	}	
	
}
