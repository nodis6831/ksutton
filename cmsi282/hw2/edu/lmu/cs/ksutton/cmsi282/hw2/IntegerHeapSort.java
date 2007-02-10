package edu.lmu.cs.ksutton.cmsi282.hw2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IntegerHeapSort {

	public static void main(String args[]) {

		// File reading taken from a tutorial at:
		// http://www.javapractices.com/Topic42.cjp

		NumberReader.readIntsFromFile(args[0]);

		IntHeap heap = new IntHeap(12);
		
		heap.add(13);
		heap.add(4);
		heap.add(81);
		heap.add(39);
		heap.add(1);
		heap.add(8);
		heap.add(49);
		heap.add(2);
		heap.add(3);
		heap.add(13);
		heap.add(88);
		heap.add(99);
		
		System.out.println(heap.toString());
		
		
	}

}