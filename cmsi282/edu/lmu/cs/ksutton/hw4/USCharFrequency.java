package edu.lmu.cs.ksutton.hw4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;


/**
 * 
 * @author Kelly Sutton
 */
public class USCharFrequency {

	public static void main(String[] args) {

		CharTrieNode root = new CharTrieNode();
		String line;
		String[] words; // the words that make up the line

		File f = new File("./america.txt"); //TODO actually read from stdin
		try {
			//InputStreamReader converter = new FileReader(f);
			
			InputStreamReader converter = new InputStreamReader(System.in);
			
			//BufferedReader in = new BufferedReader(converter);
			BufferedReader in = new BufferedReader(converter);

			// TODO add each word to our Trie

			while (true) {

				try {

					line = in.readLine();

					// Prepare the line
					line = line.toLowerCase(); // we only want to deal with lower case
					line = line.replaceAll("[!?,;:*'.\"-()/]", ""); // remove all punctuation
					
					
					words = line.split(" ");// break up the line into individual words

					for (String w : words) {
						root.add(w);
					}

				} catch (Exception e) {
					break;
				}
				// TODO output results
			}

			System.out.println("The documents being used are: The Declaration of Independence, the U.S. Constitution, and Thomas Paine's \"Common Sense\"\n");
			System.out.println("The alphabet of these three documents is:\n" + root.getAlphabet() + "\n");
			System.out.println("The relative frequencies of the characters are:\n" + root.printCharFrequencies());
		} catch (Exception e) {
			System.out.println("We're FUBAR");
		}
	}
}
