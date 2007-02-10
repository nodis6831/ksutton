package edu.lmu.cs.ksutton.cmsi282.hw2;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort {

	public static void main(String args[]) {

		NumberReader.readDoublesFromFile(args[0]);
		ArrayList<Double> masterlist = NumberReader
				.readDoublesFromFile(args[0]);
		;

		// all of the doubles will be 0.0 <= x < 100.0
		double rangeOfBucket = 100.0 / masterlist.size();

		// creating a new ArrayList of n buckets
		ArrayList[] buckets = new ArrayList[masterlist.size()];
		Arrays.fill(buckets, new ArrayList());

		double d;
		for (int i = 0; i < masterlist.size(); i++) {
			d = (Double) masterlist.get(i);
			buckets[(int) (d / rangeOfBucket)].add(d); // this mess discovers
														// the appropriate
														// bucket and dumps d in
														// it
		}

		// now we sort and spit out the list as we sort
		int k;
		for (k = 0; k < buckets.length - 1; k++)
			;
		{
			buckets[k] = insertionSort(buckets[k]); // insert sort each bucket
			System.out.println(buckets[k].toString() + "\n");
		}

	}

	/**
	 * Modified versino of InsertionSort found at
	 * http://www.samspublishing.com/articles/article.asp?p=31526&seqNum=4&rl=1
	 * 
	 * @param a
	 * @return
	 */
	public static ArrayList insertionSort(ArrayList a) {

		int in, out;

		for (out = 1; out < a.size(); out++) 
		{
			double temp = (Double) a.get(out); // remove marked item
			
			in = out; // start shifts at out
			
			// until one is smaller,
			while (in > 0 && (Double) a.get(in - 1) >= temp) 
			{
				a.set(in, a.get(in - 1));// shift item right
				in--; // go left one position
			}
			
			a.set(in, temp); // insert marked item
		} 

		return a;
	} 

}
