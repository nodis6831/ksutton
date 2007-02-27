//package edu.lmu.cs.ksutton.hw3;

import org.junit.Test;
import static org.junit.Assert.*;


public class StringSearchTester {

	@Test
	public void testShiftTable(){
	
		HString h = new HString("abcdcdae");
		
		//System.out.println(h.toString());
		assertEquals(h.toString(), "abcdcdae\n[a, 6]\n[b, 1]\n[c, 4]\n[d, 5]\n[e, 7]\n");
	}
	
	@Test
	public void testMatch(){
		
		HString h = new HString("abc");
		//System.out.println(h.match("abcdabcadbcdabc"));
		assertEquals(h.match("abcdabcadbcdabc").toString(), "[0, 4, 12]");
		
		HString s = new HString("fox");
		//System.out.println(s.match("The quick brown fox jumped over a large log"));
		assertEquals(s.match("The quick brown fox jumped over a large log").toString(), "[16]");
		
	}
}
