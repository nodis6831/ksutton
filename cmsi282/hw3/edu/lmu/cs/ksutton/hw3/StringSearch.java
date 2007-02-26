package edu.lmu.cs.ksutton.hw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class StringSearch {

	static InputStreamReader converter = new InputStreamReader(System.in);

	static BufferedReader in = new BufferedReader(converter);

	public static void main(String[] args) {

		int i = 0;
		
		HString pattern = new HString(args[0]);
		String line;
		
		while (true) { // we'll continue until we run out of lines
			i++;
			try {
				
				line = in.readLine();
				// TODO Do a string match
				ArrayList<Integer> matches = pattern.match(line);
				// TODO If found, output line number(i) and index for each
				for ( int j = 0; j < matches.size(); j++){
					System.out.println("Match found at line " + i + " and index " + matches.get(j));
				}
				
			} catch (Exception e) {
				break;
			}
		}
	}

}

/**
 * A String class that contains methods for using Horspool's algorithm
 * 
 * @author Kelly Sutton
 */
class HString {

	private HashMap<Character, Integer> shiftTable;

	private String pattern;

	public HString(String s) {

		pattern = s;
		shiftTable = computeShiftTable(pattern);

	}

	/**
	 * Returns an array filled with the index numbers of the matches of the
	 * pattern within the String. The user should determine how many matches
	 * there are by taking the length of the array returned
	 * 
	 * @param The
	 *            string to be search through
	 * @return An ArrayList<Integer> with each value representing the index of a match
	 *         _inside the input string_.
	 */
	public ArrayList<Integer> match(String s) {

		ArrayList<Integer> returnArray = new ArrayList<Integer>();
		
		int i = 0;//the position of the first letter in our pattern

		//position in the pattern of the character we are looking at
		int j = pattern.length() - 1;		
		
		//We loop and add any matches to our returnArray
		while( i <= s.length() - 1){
			
			//We match
			if ( pattern.charAt(j) == (s.charAt(i+j))){
				
				//We're at the last character! We've got a match!
				if(i == j)
					returnArray.add(i);
					
				//We still have characters to go!
				else
					j--;
			}
			
			//We don't match, shift by appropriate value
			else{
				i += shiftTable.get((pattern.charAt(j)));
				j = pattern.length() - 1; //we look at the last character again
			}
		}
		
		return returnArray;
	}

	@Override
	public String toString() {
		String s = pattern + "\n";

		for (int i = 0; i < shiftTable.size(); i++) {
			s = s + "[" + pattern.charAt(i) + ", "
					+ shiftTable.get(pattern.charAt(i)) + "]\n";
		}

		return s;
	}

	private HashMap<Character, Integer> computeShiftTable(String pattern) {

		HashMap<Character, Integer> returnMap = new HashMap<Character, Integer>();

		for (int i = 0; i < pattern.length(); i++) {
			// Insert the int value into the map at the proper character
			returnMap.put(pattern.charAt(i), pattern.lastIndexOf(pattern
					.charAt(i)));
		}

		return returnMap;
	}

}
