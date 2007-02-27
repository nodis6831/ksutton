package edu.lmu.cs.ksutton.hw3;

import java.util.ArrayList;

public class TrieNode {

	private Character c;

	private ArrayList<TrieNode> children;

	private TrieNode parent;

	private boolean end;

	private int count = 0; // For Concordance

	/**
	 * The root node constructor
	 */
	public TrieNode() {
		// TODO do we need to initialize c?
		c = null;
		children = new ArrayList<TrieNode>(0);
		parent = null; // root node
		end = false;
	}

	public TrieNode(char character, TrieNode p) {
		c = character;
		children = new ArrayList<TrieNode>(0);
		parent = p;
		end = false;
	}

	public TrieNode(char character, TrieNode p, boolean e) {
		c = character;
		children = new ArrayList<TrieNode>(0);
		parent = p;
		end = true;
	}

	/**
	 * A recursive add to add a String to our Trie
	 * 
	 * @param s
	 *            The string to be added
	 */
	public void add(String s) {

		// Last character of a word
		if (s.length() == 0) {
			end = true;
			count++;
		}

		else {
			Character curChar = s.charAt(0);

			// we need to create the first child then recurse
			if (/* parent != null && */getChild(curChar) == null) {
				children.add(new TrieNode(curChar, this));

			}

			/*
			 * else if (s.length() > 1 && parent != null) { // Create a child if
			 * it doesn't already exist if (getChild(c) == null){
			 * children.add(new TrieNode(c, this)); }
			 * 
			 * //Recurse getChild(c).add(s.substring(1)); }
			 */

			getChild(curChar).add(s.substring(1));
		}
	}

	/**
	 * A recursive method to output the frequency of a word inside the Trie
	 * 
	 * @param s
	 *            The string to find inside the Trie
	 * @return The number of times the word occurs in the Trie
	 */
	public int find(String s) {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		// TODO output all words in the Trie
		String toReturn = "";

		if (end == true) // we've reached a leaf
			return Character.toString(c) + "\t" + count + "\n";

		else {
			for (int i = 0; i < children.size(); i++) {
				if (parent != null) // child node
					toReturn += Character.toString(c)
							+ children.get(i).toString();
				else
					toReturn += children.get(i).toString();
			}
		}

		return toReturn;
	}

	/**
	 * @return The character at the current TrieNode
	 */
	public char getC() {
		return c;
	}

	/**
	 * @return The children of the current TrieNode
	 */
	public ArrayList<TrieNode> getChildren() {
		return children;
	}

	/**
	 * A brute force method that parses through the list of children in hopes of
	 * finding a match. Not the most efficient thing in the world, but if we
	 * assume a 26 character alphabet, we should be okay.
	 * 
	 * @return The child with the specific character, null otherwise
	 */
	public TrieNode getChild(Character c) {

		if (c == null)
			return null;

		for (int i = 0; i < children.size(); i++) {
			if (children.get(i).getC() == c)
				return children.get(i);
		}

		return null;// we didn't find what we were looking for
	}

	/**
	 * @return If we've reached an end or not
	 */
	public boolean isEnd() {
		return end;
	}

	/**
	 * @return The parent of the current TrieNode
	 */
	public TrieNode getParent() {
		return parent;
	}

}
