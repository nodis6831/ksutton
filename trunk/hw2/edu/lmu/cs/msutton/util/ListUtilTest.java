package edu.lmu.cs.msutton.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

public class ListUtilTest {

	@Test
	public void testNodeCopy() {

		Node c = new Node(0);
		Node b = new Node(1, c);
		Node a = new Node(2, b);

		Node x = ListUtil.copy(a);

		System.out.println(a.toString() + " " + x.toString());
		
		assertNotSame(a, x);
		assertNotSame(b, x.next());
		//assertNotSame(c, x.next().next());
	}
	
	@Test
	public void testNodeConcat(){
		
		Node c = new Node(0);
		Node b = new Node(1, c);
		Node a = new Node(2, b);
		
		Node e = new Node(4);
		Node d = new Node(3,e);
		
		Node concatList = ListUtil.concat(a, d);
		
		assertEquals(a.getData(), concatList.getData());
		assertEquals(b.getData(), concatList.next().getData());
		
		a.setData(10);
		
		assertEquals(a.getData(), 10);
		
	}
}
