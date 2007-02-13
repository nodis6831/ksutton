package edu.lmu.cs.ksutton.cmsi282.hw2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;



/**
 * This is a (repetitive) helper class that reads 
 * values from a file into the data structures required for the assignment
 * 
 * @author Kelly Sutton
 *
 */
public class NumberReader {

	public static IntHeap readIntsFromFile(String f) {

		//System.out.println("The file name is " + f);
		BufferedReader input = null;

		try {

			IntHeap heap;

			input = new BufferedReader(new FileReader(f));
			String line = null;

			int i = 0;
			while ((line = input.readLine()) != null) { // we're just going
				// to
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
				if (!line.equals(""))
					heap.add(Integer.parseInt(line));
			}
			
			return heap;

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	public static int[] readIntsAsArrayFromFile(String f) {

		BufferedReader input = null;

		try {

			int[] a;

			input = new BufferedReader(new FileReader(f));
			String line = null;

			
			// we're just going to count the lines this time through
			int i = 0;
			while ((line = input.readLine()) != null) { 
				i++;
			}

			//BufferedReader counts the last line, so we subtract one
			a = new int[i]; 

			try {
				if (input != null)
					input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// now we reopen the file and load it into our array

			input = new BufferedReader(new FileReader(f));
			line = null;
			
			int j = 0;
			while ((line = input.readLine()) != null) {
				if (!line.equals("")){
					a[j] = Integer.parseInt(line);
					j++;
				}
			}

			System.out.println(Arrays.toString(a));
			return a;

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	public static ArrayList<Double> readDoublesFromFile(String f) {

		//System.out.println("The file name is " + f);
		BufferedReader input = null;

		try {

			ArrayList<Double> a;

			input = new BufferedReader(new FileReader(f));
			String line = null;

			//we're just going to count through lines
			int i = 0;
			while ((line = input.readLine()) != null) { 
				i++;
			}

			a = new ArrayList<Double>(i);// creating our new array of doubles

			try {
				if (input != null)
					input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// now we reopen the file and load it into our array

			input = new BufferedReader(new FileReader(f));
			line = null;

			i = 0;
			while ((line = input.readLine()) != null) {
				
				if (!line.equals("") ) {
					a.add(Double.parseDouble(line));
					i++;
				}
			}

			System.out.println(a.toString());
			return a;

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

}
