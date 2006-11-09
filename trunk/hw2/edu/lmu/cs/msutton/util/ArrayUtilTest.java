package edu.lmu.cs.msutton.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testReverse() {
		int[] a = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] b = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

		assert (Arrays.equals(b, ArrayUtil.reverse(a)));
	}

	@Test
	public void testFrequency() {
		int[] a = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		assertEquals(10, ArrayUtil.frequency(a, 0));

		int[] b = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertEquals(1, ArrayUtil.frequency(b, 1));

		int[] c = new int[] { 1, 1, 1, 1, 1, 2, 2, 4, 5 };
		assertEquals(5, ArrayUtil.frequency(c, 1));
		assertEquals(2, ArrayUtil.frequency(c, 2));
	}

	@Test
	public void testPartition() {
		int[] a = new int[] { 44, 99, 55, 88, 33, 66, 22, 77 };
		assertEquals(2, ArrayUtil.partition(a));
		int[] b = new int[] { 44, 99, 55, 88, 70, 66, 22, 77 };
		assertEquals(1, ArrayUtil.partition(b));
		int[] c = new int[] { 44, 99, 55, 88, 70, 66, 22, 77, 10, 9, 26, 13, 19 };
		assertEquals(6, ArrayUtil.partition(c));
		int[] d = new int[] { 44, 99, 55, 88, 70, 66, 22, 77, 10, 44 };
		assertEquals(3, ArrayUtil.partition(d));

	}
}
