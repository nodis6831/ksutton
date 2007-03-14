package edu.lmu.cs.ksutton.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class CharTrieNode {

	private Character c;

	private ArrayList<CharTrieNode> children;

	private CharTrieNode parent;

	private boolean end;

	private int count = 0; // For Concordance

	ArrayList<String> concordances = null;

	HashMap<Character, Integer> charMap;

	/**
	 * The root node constructor
	 */
	public CharTrieNode() {
		// TODO do we need to initialize c?
		c = null;
		children = new ArrayList<CharTrieNode>(0);
		parent = null; // root node
		end = false;
		concordances = new ArrayList<String>();
		charMap = new HashMap<Character, Integer>();
	}

	public CharTrieNode(char character, CharTrieNode p) {
		c = character;
		children = new ArrayList<CharTrieNode>(0);
		parent = p;
		end = false;
		charMap = null;
	}

	public CharTrieNode(char character, CharTrieNode p, boolean e) {
		c = character;
		children = new ArrayList<CharTrieNode>(0);
		parent = p;
		end = true;
		charMap = null;
	}

	/**
	 * A recursive add to add a String to our Trie
	 * 
	 * @param s
	 *            The string to be added
	 */
	public void add(String s) {

		// We're just counting characters
		count++;

		// Last character of a word
		if (s.length() == 0) {
			end = true;
		}

		else {
			Character curChar = s.charAt(0);

			// if the character isn't in the chars ArrayList
			if (getRoot().charMap.get(curChar) == null)
				getRoot().charMap.put(curChar, 1);// add the character to the
			// array
			else
				// increment the count of characters by 1
				getRoot().charMap.put(curChar,
						getRoot().charMap.get(curChar) + 1);

			// we need to create the first child then recurse
			if (getChild(curChar) == null)
				children.add(new CharTrieNode(curChar, this));

			getChild(curChar).add(s.substring(1));
		}
	}

	/**
	 * A recursive method to output the frequency of a word inside the Trie
	 * 
	 * @param s
	 *            The string to find inside the Trie
	 * @return The number of times the word occurs in the Trie. 0 If the word
	 *         does not occur
	 */
	public int find(String s) {
		if (s.length() == 0)
			return count;

		else if (getChild(s.charAt(0)) != null) {
			if (s.length() == 1)
				return getChild(s.charAt(0)).find("");
			else
				return getChild(s.charAt(0)).find(s.substring(1));
		} else
			return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String readOut = "";

		buildConcordances();
		Collections.sort(concordances);

		if (isRoot())
			for (String s : concordances)
				readOut += s;

		return readOut;

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
	public ArrayList<CharTrieNode> getChildren() {
		return children;
	}

	/**
	 * A brute force method that parses through the list of children in hopes of
	 * finding a match. Not the most efficient thing in the world, but if we
	 * assume a 26 character alphabet, we should be okay.
	 * 
	 * @return The child with the specific character, null otherwise
	 */
	public CharTrieNode getChild(Character c) {

		if (c == null)
			return null;

		try {
			for (int i = 0; i < children.size(); i++)
				if (children.get(i).getC() == c)
					return children.get(i);
		} catch (Exception e) {
			return null;// we didn't find what we were looking for
		}
		return null;
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
	public CharTrieNode getParent() {
		return parent;
	}

	/**
	 * A helper method that recurses up the tree to the last found end node
	 * 
	 * @return
	 */
	public CharTrieNode findLastEnd() {
		if (isEnd() || isRoot())
			return this;
		else
			return parent.findLastEnd();
	}

	public CharTrieNode findLastMultiChildNode() {

		if (c == null)
			return null;
		if (children.size() > 1)
			return this;
		else
			return parent.findLastMultiChildNode();
	}

	/**
	 * Recursive helper method used by toString() for printing stuff out
	 * correctly
	 * 
	 * @param t
	 *            The current TrieNode
	 * @return A String containing all the characters from the current node back
	 *         up to the root
	 */
	public String printCharactersBackToRoot() {
		if (isRoot())
			return "";
		else
			return parent.printCharactersBackToRoot() + Character.toString(c);
	}

	/**
	 * @return True iff the TrieNode is root, false otherwise
	 */
	public boolean isRoot() {
		return parent == null ? true : false;
	}

	/**
	 * @return True iff the TrieNode has no children
	 */
	public boolean isLeaf() {
		return children.size() == 0;
	}

	public String printUp() {
		if (!isRoot())
			return parent.printUp() + Character.toString(c);
		else
			return "";
	}

	/**
	 * @param s
	 *            The string to add to the concordance
	 */
	public void addConcordance(String s) {
		if (isRoot())
			concordances.add(s);
		else
			throw new IllegalArgumentException(
					"Non-root nodes do not have concordance arrays");
	}

	public String printChars() {

		String s = "";
		if (isRoot()) {
			for (Character curChar : charMap.keySet()) {
				s += curChar + "\n";
			}
			return s;
		}
		return "";
	}

	/**
	 * @return Returns an unsorted HashMap<Character, Integer> of the alphabet
	 *         of the Trie
	 */
	public Set<Character> getAlphabet() {
		return isRoot() ? charMap.keySet() : null;
	}

	public String printCharFrequencies() {

		if (isRoot()) {

			HashMap<Integer, Character> h = new HashMap<Integer, Character>();

			String s = ""; // our return string

			// Creating a "mirror" of our charMap HashMap
			// This is probably _very_ expensive
			for (Character curChar : getAlphabet()) {
				h.put(charMap.get(curChar), curChar);
			}

			ArrayList<Integer> ints = getSortedFrequencies(h);

			// Now access the frequencies in descending order and add
			// to our return string
			for (int i = 0; i < ints.size(); i++) {
				s += ints.get(i) + " " + h.get(ints.get(i)) + "\n";
			}

			return s;
		}
		return null;
	}

	/**
	 * @return The frequencies in descending order
	 */
	private ArrayList<Integer> getSortedFrequencies(
			HashMap<Integer, Character> h) {
		
		ArrayList<Integer> ints = new ArrayList<Integer>(h.keySet());

		Collections.sort(ints);
		Collections.reverse(ints);

		return ints;
	}

	private void buildConcordances() {

		if (!isRoot() && isEnd())
			getRoot().addConcordance(printUp() + " " + count + "\n");

		if (children.size() > 0)
			for (int i = 0; i < children.size(); i++)
				children.get(i).buildConcordances();

	}

	/**
	 * @return The root node
	 */
	private CharTrieNode getRoot() {
		if (isRoot())
			return this;
		else
			return parent.getRoot();
	}

}
