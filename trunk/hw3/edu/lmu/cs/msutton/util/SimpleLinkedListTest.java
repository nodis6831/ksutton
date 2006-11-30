package edu.lmu.cs.msutton.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SimpleLinkedListTest {

	@Test
	public void testFrequency() {
		SimpleLinkedList list = new SimpleLinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(4);

		assertEquals(list.frequency(4), 2);
		assertEquals(list.frequency(3), 1);
		assertEquals(list.frequency(0), 0);
	}

	@Test
	public void testRemoveOdd() {
		SimpleLinkedList list = new SimpleLinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);

		list.removeOdd();

		assertEquals(list.get(0), 2);
		assertEquals(list.get(1), 4);
		assertEquals(list.get(2), 6);
	}

}
