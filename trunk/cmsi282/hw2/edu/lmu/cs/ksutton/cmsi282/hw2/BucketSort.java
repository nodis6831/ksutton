package edu.lmu.cs.ksutton.cmsi282.hw2;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort {

	public static void main(String args[]) {
		
		NumberReader.readDoublesFromFile(args[0]);
		ArrayList<Double> masterlist = NumberReader.readDoublesFromFile(args[0]);;
		
		//all of the doubles will be 0.0 <= x < 100.0
		double rangeOfBucket = 100.0 / masterlist.size();
		
		//creating a new ArrayList of n buckets
		ArrayList[] buckets = new ArrayList[masterlist.size()];
		Arrays.fill(buckets, new ArrayList());
		
		
		double d;
		for(int i = 0; i < masterlist.size(); i++){
			d = (Double) masterlist.get(i); 
			buckets[(int)( d / rangeOfBucket )].add(d); //this mess discovers the appropriate bucket and dumps d in it
		}
		
		//now we sort and spit out the list as we sort
		int k;
		for (k = 0; k < buckets.length - 1; k++);{
			buckets[k] = insertionSort(buckets[k]); //insert sort each bucket
			System.out.println(buckets[k].toString() + "\n");
		}

	}

	
	
	/**
	 * Simple insert sort method
	 * Taken from the pseucode on the Insert Sort Wikipedia page
	 * http://en.wikipedia.org/wiki/Insert_sort
	 * @param a The list to be sorted
	 * @return An ArrayList object sorted in ascending order
	 */
	private static ArrayList insertionSort(ArrayList a){
		
		int i = 0;//the space in the list
		while (i < a.size() - 1) {//start filling in the smallest elements first
			
		    int j = a.size() - 1;
			while (j >= 0 && (Double) a.get(j) > (Double) a.get(i)) {//while the element we're dealing with, i, is bigger than j
				a.set(j, a.get(j-1)); //percolate the element down
				j--;
			}
			
			a.set(i+1, a.get(i));
	        i++;
	     }

		return a;
		
	}
}
