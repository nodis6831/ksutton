package edu.lmu.cs.ksutton.hw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TextFrequency {

	public static void main(String[] args) {
		
		TrieNode root = new TrieNode();
		String line;
		String[] words; //the words that make up the line
		
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);

		// TODO add each word to our Trie

		while (true) {

			try {

				line = in.readLine();
				
				//Prepare the line
				line = line.toLowerCase();//we only want to deal with lower case
				line = line.replaceAll("!", "");//remove all punctuation
				
				words = line.split(" ");//break up the line into individual words
				
				for (String w : words){
					root.add(w);
				}
				
			} catch (Exception e) {
				break;
			}
			// TODO output results
		}
		
		System.out.println("Hello");
		System.out.println(root.toString());
	}
}
