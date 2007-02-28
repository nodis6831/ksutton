package edu.lmu.cs.ksutton.hw3;

import org.junit.Assert;
import org.junit.Test;

public class TrieNodeTester {
	
	@Test
	public void testConstructors(){
	
		TrieNode root = new TrieNode();
		
		root.add("apple");
		root.add("ape");
		root.add("something");
		root.add("someone");
		root.add("someplace");

		Assert.assertFalse(root.equals(null));
		Assert.assertFalse(root.getChild('a').equals(null));
		Assert.assertFalse(root.getChild('s').equals(null));
		Assert.assertTrue(root.getChild('c') == null);
		Assert.assertTrue(root.getChild('r') == null);
	}
	
	@Test
	public void testFind(){

		TrieNode root = new TrieNode();
		
		root.add("apple");
		root.add("ape");
		root.add("something");
		root.add("someone");
		root.add("someplace");
		
		Assert.assertEquals(root.find("apple"), 1);
		Assert.assertEquals(root.find("ape"), 1);
		Assert.assertEquals(root.find("something"), 1);
		Assert.assertEquals(root.find("someone"), 1);
		Assert.assertEquals(root.find("someplace"), 1);
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
		
		Assert.assertEquals(4, root.find("apple"));
		Assert.assertEquals(4, root.find("something"));
	}
}