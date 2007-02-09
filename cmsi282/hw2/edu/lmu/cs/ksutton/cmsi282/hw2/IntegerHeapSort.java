package edu.lmu.cs.ksutton.cmsi282.hw2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class IntegerHeapSort {

	public static void main(String args[]) {

		// File reading taken from a tutorial at:
		// http://www.javapractices.com/Topic42.cjp

		System.out.println("The file name is " + args[0]);
		BufferedReader input = null;

		try {

			IntHeap heap;

			input = new BufferedReader(new FileReader(args[0]));
			String line = null;

			int i = 0;
			while ((line = input.readLine()) != null) { // we're just going to
														// count the lines this
														// time through
				i++;
			}

			heap = new IntHeap(i); // creating our new heap.

			try {
				if (input != null)
					input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// now we reopen the file and load it into our array

			input = new BufferedReader(new FileReader(args[0]));
			line = null;

			while ((line = input.readLine()) != null) {
				heap.add(Integer.parseInt(line));
			}

			System.out.println(heap.toString());

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (input != null)
					input.close();
			}

			catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

class IntHeap {

	private int[] a; // the heap

	private int size;

	public IntHeap(int s) {

		a = new int[s];
		size = s;

	}

	/**
	 * Adds an int to the heap and readjusts the heap
	 * 
	 * @param x
	 *            The int to add to the heap
	 */
	public void add(int x) {

		a[size + 1] = x;

		size++;
		reheap_up();

	}

	/**
	 * 
	 * @return The top-most element of the heap
	 */
	public int remove() {

		int top = a[1];

		if (a[2] > a[3]) {
			a[1] = a[2];
		}

		else
			// a[2] < a[3]
			a[1] = a[3];

		size--;
		reheap_down();

		return top;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Arrays.toString(a);
	}

	/**
	 * Recursive method that reorganizes the heap, should be called every time
	 * an object is added or removed from the heap.
	 */
	private void reheap_down() {

		int i = 0;

		while (2 * i + 1 < size) {
			int child = 2 * i + 1;

			// since we're pushing a number down, we want to do the swapping
			// with the smallest number
			if (child < size && a[child] > a[child + 1])
				child++;

			// the number is as far down as it needs to go
			if (a[i] < a[child])
				break;

			else {
				swapInts(child, i);// we've found the smallest numbered child
									// and we're swapping
				i = child;// now we move on to see if we need to go any lower
			}
		}

	}

	/**
	 * Recursive method that reorganizes the heap, should be called every time
	 * an object is added or removed from the heap.
	 */
	private void reheap_up() {

		int i = size - 1;

		while (i > 1) {
			if (parent(i) > a[i]) {
				swapInts(i, indexOfParent(i));
			}

			i = indexOfParent(i);
		}

	}

	/**
	 * 
	 * @param i
	 *            The index of the item in question
	 * @return The index of the parent
	 */
	private int indexOfParent(int i) {
		return i / 2;
	}

	/**
	 * 
	 * @param i
	 *            The index of the child
	 * @return The parent's data
	 */
	private int parent(int i) {
		return a[indexOfParent(i)];
	}

	/**
	 * Swaps the values at the two indeces of the array
	 * 
	 * @param i
	 * @param j
	 */
	private void swapInts(int i, int j) {

		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;

	}

}