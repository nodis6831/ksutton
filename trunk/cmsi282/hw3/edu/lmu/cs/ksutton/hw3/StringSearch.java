package edu.lmu.cs.ksutton.hw3;

import java.util.HashMap;

public class StringSearch {

}

/**
 * A String class that contains methods for using Horspool's algorithm 
 * @author Kelly Sutton
 */
class HString {
	
	private HashMap<Character, Integer> shiftTable;
	private String pattern;
	
	public HString(String s){
		
		pattern = s;
		shiftTable = computeShiftTable(pattern);
		
	}
	
	
	
	@Override
	public String toString() {
		String s = pattern + "\n";
		
		for(int i = 0; i < shiftTable.size(); i++){
			s = s + "[" + pattern.charAt(i) + ", " + shiftTable.get(pattern.charAt(i)) + "]\n";
		}
		
		return s;
	}



	private HashMap<Character, Integer> computeShiftTable(String pattern){
		
		HashMap<Character, Integer>returnMap = new HashMap<Character, Integer>();
		
		for (int i = 0; i < pattern.length(); i++){
			//Insert the int value into the map at the proper character
			returnMap.put(pattern.charAt(i), pattern.lastIndexOf(pattern.charAt(i)));
		}
		
		return returnMap;
	}
	
}
