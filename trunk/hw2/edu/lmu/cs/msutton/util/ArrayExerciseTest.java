package edu.lmu.cs.msutton.util;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class ArrayExerciseTest {

	@Test
	public void testFrequency() {
		int[] a = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		assertEquals(10, ArrayExercise.frequency(a, 0));

		int[] b = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertEquals(1, ArrayExercise.frequency(b, 1));

		int[] c = new int[] { 1, 1, 1, 1, 1, 2, 2, 4, 5 };
		assertEquals(5, ArrayExercise.frequency(c, 1));
		assertEquals(2, ArrayExercise.frequency(c, 2));
	}
}
