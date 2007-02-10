package edu.lmu.cs.ksutton.cmsi282.hw2;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class NumberReaderTester {

	@Test
	public void testDoubleReader(){
		
		double[] a = NumberReader.readDoublesFromFile("/Users/mike/Documents/workspace/cmsi282hw2/edu/lmu/cs/ksutton/cmsi282/hw2/doubles.txt");
		
		double[] b = { 12.3, 1.0, 18.9, 45.6, 37.6, 99.99, 87.4, 20.0, 61.4, 78.2};
		
		assertEquals(Arrays.toString(a), Arrays.toString(b));
	}
		
}
