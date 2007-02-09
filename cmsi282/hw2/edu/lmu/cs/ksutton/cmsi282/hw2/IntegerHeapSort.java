package edu.lmu.cs.ksutton.cmsi282.hw2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IntegerHeapSort {

	public static void main(String args[]) {

		// File reading taken from a tutorial at:
		// http://www.javapractices.com/Topic42.cjp

		//readFromFile(args[0]);

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

	private static IntHeap readFromFile(String f) {

		System.out.println("The file name is " + f);
		BufferedReader input = null;

		try {

			IntHeap heap;

			input = new BufferedReader(new FileReader(f));
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

			input = new BufferedReader(new FileReader(f));
			line = null;

			while ((line = input.readLine()) != null) {
				heap.add(Integer.parseInt(line));
			}

			System.out.println(heap.toString());
			return heap;

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
		return null;

	}
}