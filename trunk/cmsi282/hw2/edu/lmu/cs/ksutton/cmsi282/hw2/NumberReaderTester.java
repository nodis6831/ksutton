package edu.lmu.cs.ksutton.cmsi282.hw2;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class NumberReaderTester {

	@Test
	public void testDoubleReader(){
		
		ArrayList a = NumberReader.readDoublesFromFile("/Users/mike/Documents/workspace/cmsi282hw2/edu/lmu/cs/ksutton/cmsi282/hw2/doubles.txt");
		
		ArrayList b = new ArrayList();
		b.add(12.3);
		b.add(1.0);
		b.add(18.9);
		b.add(45.6);
		b.add(37.6);
		b.add(99.99);
		b.add(87.4);
		b.add(20.0);
		b.add(61.4);
		b.add(78.2);
		
		assertEquals(a.toString(), b.toString());
	}
		
}
