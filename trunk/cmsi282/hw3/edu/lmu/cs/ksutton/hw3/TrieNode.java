package edu.lmu.cs.ksutton.hw3;

import java.util.HashMap;

public class TrieNode {

	private char c;
	private HashMap<Character, TrieNode> children;
	private TrieNode parent;
	private boolean end;
	
	/**
	 * The root node constructor
	 */
	public TrieNode(){
		//TODO do we need to initialize c?
		children = null;
		parent = null; //root node
		end = false;
	}
	
	public TrieNode(char character, TrieNode p){
		c = character;
		children = null;
		parent = p;
		end = false;
	}
	
	public TrieNode(char character, TrieNode p, boolean e){
		c = character;
		children = null;
		parent = p;
		end = true;
	}
	
	/**
	 * A recursive add to add a String to our Trie
	 * @param s The string to be added
	 */
	public void add(String s){
		
		//Last character of a word
		if (s.length() == 1)
			end = true;
		
		else if (s.length() > 1 || parent != null){
			c = s.charAt(0);//reading the current character
			
			//Create a child if it doesn't already exist
			if(children.get(s.charAt(0)) == null)
				children.put(s.charAt(0), new TrieNode(s.charAt(0), this));
				
				children.get(s.charAt(0)).add(s.substring(1));
			
		}	
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
	public HashMap<Character, TrieNode> getChildren() {
		return children;
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
