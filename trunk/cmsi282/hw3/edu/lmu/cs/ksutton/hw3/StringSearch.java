//package edu.lmu.cs.ksutton.hw3;

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
				
				//Do a string match
				ArrayList<Integer> matches = pattern.match(line);
				
				//If found, output line number(i) and index for each
				for ( int j = 0; j < matches.size(); j++){
					System.out.println("Match found at line " + i + " and index " + matches.get(j));
				}
				
			} catch (Exception e) {
				break;
			}
		}
	}

}