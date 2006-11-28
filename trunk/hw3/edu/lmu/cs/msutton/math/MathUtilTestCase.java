package edu.lmu.cs.msutton.math;

import static edu.lmu.cs.msutton.math.MathUtil.intToBinary;
import static edu.lmu.cs.msutton.math.MathUtil.maxValueInSequence;
import static edu.lmu.cs.msutton.math.MathUtil.subArray;
import junit.framework.TestCase;

import org.junit.Test;

public class MathUtilTestCase extends TestCase {

	@Test
	public void testIntToBinary() {
		assertEquals(intToBinary(13), "1101");
		assertEquals(intToBinary(8), "1000");
		assertEquals(intToBinary(1), "1");
		assertEquals(intToBinary(0), "0");
		assertEquals(intToBinary(54273854), "11001111000010011100111110");
	}

	@Test
	public void testSubArray() {
		int[] a = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] b = subArray(a, 0, 5);
		int[] c = subArray(a, 5, 10);
		int[] d = subArray(a, 5, 5);

		for (int i = 0; i < b.length; i++) {
			assertEquals(a[i], b[i]);
		}
		for (int k = 0; k < c.length; k++) {
			assertEquals(a[k + 5], c[k]);
		}

		assertEquals(5, d[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMaxValueInSequence() {
		int[] a = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] b = new int[] { 13, 54, 76, 101, 98, 54, 33, 21 };
		int[] c = new int[] {1};

		assertEquals(maxValueInSequence(a),10);
		assertEquals(maxValueInSequence(b),101);
		assertEquals(maxValueInSequence(c),1);
		
	}
}
