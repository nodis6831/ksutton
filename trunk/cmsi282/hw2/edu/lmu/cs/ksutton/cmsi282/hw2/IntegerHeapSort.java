package edu.lmu.cs.ksutton.cmsi282.hw2;

/**
 * Problem Set #2
 * Problem #3
 * 
 * The IntegerHeapSort uses the heap data structure and
 * heap sorting algorithm to quickly sort a file of integers.
 * 
 * The program should be invoked as follows:
 * 
 *     java IntegerHeapSort FILENAME
 *     
 * Where FILENAME is the complete filepath to a file full
 * of integers, one per line.
 * 
 * Caveat: The assignment asks to use the "<" to redirect the
 * file's contents into stdin. After some research, I couldn't
 * figure out how to do that exactly, so I created a class,
 * NumberReader.java that reads the data from the file.
 * 
 * @author Kelly Sutton
 *
 */
public class IntegerHeapSort {

	public static void main(String args[]) {

		// File reading taken from a tutorial at:
		// http://www.javapractices.com/Topic42.cjp

		System.out.println("Reading from file: " + args[0]);

		IntHeap heap = NumberReader.readIntsFromFile(args[0]);;

		while (heap.size() > 0){
			System.out.println(heap.remove());
		}
		
	}

}