package edu.lmu.cs.ksutton.hw3;

import java.util.HashMap;

public class Subsequence {

	/**
	 * This is the table that will hold our already solved problems. The answers
	 * will be stored in the following fashion:
	 * 
	 * key: "string1,string2" Where string1 and string2 are unique strings
	 * value: The greatest common subsequence
	 */
	private static HashMap<String, String> table = new HashMap<String, String>();

	private static final String string1 = "GATGCCCGATAGATAAATGCTTGTGCAACGATGCAAGGTGCAGTAAG";

	private static final String string2 = "AGGACTCTTCGATCGCTGGATAGCTAGCTGGATCGAACCTAGCTACGA";

	public static void main(String[] args) {

		System.out.println("Our Strings are:\n" + string1 + "\n" + string2
				+ "\n");
		
		System.out.println(lcs(string1, string2));

	}

	/**
	 * A recursive function that employs memoization and dynamic programming to
	 * quickly compute the LCS (Largest Common Subsequence)
	 * 
	 * @param s1
	 *            First String
	 * @param s2
	 *            Second String
	 * @return The greatest common subsequence between the two strings
	 */
	private static String lcs(String s1, String s2) {
		
		String ps1; //Prefix Strings
		String ps2;
		
		String found = table.get(s1 + "," + s2);
		if ( found != null )
			return found; //It's already been computed
		
		// s1 or s2 is empty
		 if ( s1.equals("") || s2.equals(""))
			return "";
		
		// The last characters are equal, we recurse
		if (lastChar(s1).equals(lastChar(s2)))
			return lcs(prefix(s1), prefix(s2)) + lastChar(s1);
		
		//The last characters are not equal, see if the greater
		//  subsequence results from prefix(s1) or prefix(s2)
		else{
		
			ps1 = prefix(s1);
			ps2 = prefix(s2);
		
			String lcs1 = lcs(ps1, s2);
			String lcs2 = lcs(s1, ps2);
			
			table.put(ps1 + "," + s2, lcs1); //Adding the values to our table
			table.put(s1 + "," + ps2, lcs2);

			//Subsequence not found in our table, we need to compute it
			//else{
			//	String longerSubsequence = lcs1.length() >= lcs2.length() ? lcs1 : lcs2;
			//}
			
			return lcs1.length() >= lcs2.length() ? lcs1 : lcs2;
			
		}

	}

	/**
	 * A nifty little helper method to cut down on clutter
	 * 
	 * @param s
	 * @return
	 */
	private static String lastChar(String s) {
		return Character.toString(s.charAt(s.length() - 1));
	}

	/**
	 * Private helper method that slurps in a string and returns everything but
	 * the last character. Returns the empty string if s has one or less
	 * characters.
	 * 
	 * @param s
	 *            A String
	 * @return s minus the last character
	 */
	private static String prefix(String s) {
		if (s.length() <= 1)
			return "";

		else
			return s.substring(0, s.length() - 1);
	}
}
