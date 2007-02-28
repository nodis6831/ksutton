package edu.lmu.cs.ksutton.hw3;

import java.util.ArrayList;

public class TrieNode {

	private Character c;

	private ArrayList<TrieNode> children;

	private TrieNode parent;

	private boolean end;

	private int count = 0; // For Concordance
	
	ArrayList<String> concordances = null;
		

	/**
	 * The root node constructor
	 */
	public TrieNode() {
		// TODO do we need to initialize c?
		c = null;
		children = new ArrayList<TrieNode>(0);
		parent = null; // root node
		end = false;
		concordances = new ArrayList<String>();
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
			count++; // Concordance
		}

		else {
			Character curChar = s.charAt(0);

			// we need to create the first child then recurse
			if (getChild(curChar) == null)
				children.add(new TrieNode(curChar, this));

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
		

		else if (getChild(s.charAt(0)) != null){
			if(s.length() == 1){
				return getChild(s.charAt(0)).find("");
			}
			else
				return getChild(s.charAt(0)).find(s.substring(1));
		}
		else
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

		if(isRoot())
		{
			for(String s : concordances){
				readOut += s;
			}
		}
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

	/**
	 * A helper method that recurses up the tree to the last found end node
	 * 
	 * @return
	 */
	public TrieNode findLastEnd() {
		if (end == true || parent == null)
			return this;
		else
			return parent.findLastEnd();
	}

	public TrieNode findLastMultiChildNode() {

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
		if (parent == null)
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
	public boolean isLeaf(){
		return children.size() == 0;
	}
	
	public String printUp(){
		if (!isRoot())
			return parent.printUp() + Character.toString(c);
		else
			return "";
	}
	
	private void buildConcordances(){
		
		if(!isRoot() && end == true){	
			getRoot().addConcordance(printUp() + "\t" + count + "\n");
		}
		
		//if (end == true){ // we've reached a leaf
		//	 readOut += tmp + "\t" + count + "\n";//	+ findLastMultiChildNode().getParent().printCharactersBackToRoot();
			// tmp = findLastMultiChildNode().toString();
		//}
		if(children.size() > 0){
			for (int i = 0; i < children.size(); i++) {
				//if (!isRoot()){ // child node
					children.get(i).toString();
				//}
				//else //isRoot()
					//readOut += children.get(i).toString();
			}
		}

		//return readOut;
	}
	
	/**
	 * @return The root node
	 */
	private TrieNode getRoot(){
		if(isRoot())
			return this;
		else
			return parent.getRoot();
	}
	
	public void addConcordance(String s){
		if(isRoot())
			concordances.add(s);
		else
			throw new IllegalArgumentException("Non-root nodes do not have concordance arrays");
	}
}
