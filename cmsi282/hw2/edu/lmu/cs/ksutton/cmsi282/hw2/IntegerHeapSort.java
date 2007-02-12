package edu.lmu.cs.ksutton.cmsi282.hw2;


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