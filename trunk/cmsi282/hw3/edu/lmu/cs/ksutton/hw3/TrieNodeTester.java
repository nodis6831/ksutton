package edu.lmu.cs.ksutton.hw3;

import org.junit.Test;

public class TrieNodeTester {

	@Test
	public void testConstructors(){
	
		TrieNode root = new TrieNode();
		/*poppcock?
		TrieNode a = new TrieNode('a', root);
		TrieNode p = new TrieNode('p', a);
		TrieNode p2 = new TrieNode('p', p);
		TrieNode l = new TrieNode('l', p2);
		TrieNode e = new TrieNode('e', l, true);
		*/
		
		root.add("apple");
		root.add("ape");
		root.add("something");
		root.add("someone");
		root.add("someplace");
		
		System.out.println(root.toString());
	}
	
	@Test
	public void testFrequency(){
	
		TrieNode root = new TrieNode();
		root.add("apple");
		root.add("apple");
		root.add("apple");
		root.add("apple");
		
		root.add("something");
		root.add("something");
		root.add("something");
		root.add("something");
	}
}