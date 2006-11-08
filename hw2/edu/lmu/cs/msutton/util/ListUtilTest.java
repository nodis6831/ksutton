package edu.lmu.cs.msutton.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ListUtilTest {

	@Test
	public void testNodeCopy() {

		Node c = new Node(2);
		Node b = new Node(1, c);
		Node a = new Node(0, b);

		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		
		Node x = ListUtil.copy(a);
		assertNotNull(x);
		assertNotNull(x.next());
		assertNotNull(x.next().next());
		
		//System.out.println(a.toString() + " " + x.toString());
		
		assertNotSame(a, x);
		assertNotSame(b, x.next());
		assertNotSame(c, x.next().next());
		
		assertEquals(a.getData(), 0);
		assertEquals(b.getData(), 1);
		assertEquals(c.getData(), 2);
		assertEquals(x.getData(), 0);
		assertEquals(x.next().getData(), 1);
		assertEquals(x.next().next().getData(), 2);
	}
	
	@Test
	public void testNodeConcat(){
		
		Node c = new Node(2);
		Node b = new Node(1, c);
		Node a = new Node(0, b);
		
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNull(c.next());
		
		Node e = new Node(4);
		Node d = new Node(3,e);
		
		assertNotNull(d);
		assertNotNull(e);
		assertNull(e.next());
		
		Node concatList = ListUtil.concat(a, d);
		
		assertNotSame(concatList, a);
		
		assertEquals(a.getData(), concatList.getData());
		assertEquals(b.getData(), concatList.next().getData());
		
		a.setData(10);
		
		assertEquals(a.getData(), 10);
		assertTrue(a.getData() != concatList.getData());
		
		/*
		 * Test to make sure the concat worked correctly
		 */
		Node concatListIterator = concatList;
		for (int i = 0; concatListIterator.next() != null; i++){
			assertEquals(concatListIterator.getData(), i);
			concatListIterator = concatListIterator.next();
		}
		
	}
	
	@Test
	public void testNodeMerged() {
		
	}
}
