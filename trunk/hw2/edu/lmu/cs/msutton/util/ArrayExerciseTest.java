package edu.lmu.cs.msutton.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
	
	@Test
	public void testPartition() {
		int[] a = new int[] {44, 99, 55, 88, 33, 66, 22, 77};
		assertEquals(2, ArrayExercise.partition(a));
		int[] b = new int[] {44, 99, 55, 88, 70, 66, 22, 77};
		assertEquals(1, ArrayExercise.partition(b));
		int[] c = new int[] {44, 99, 55, 88, 70, 66, 22, 77, 10, 9, 26, 13, 19};
		assertEquals(6, ArrayExercise.partition(c));
		//TODO hangs when the pivot number occurs more than once
		int[] d = new int[] {44, 99, 55, 88, 70, 66, 22, 77, 10, 44};
		assertEquals(3, ArrayExercise.partition(d));
		
	}
}
