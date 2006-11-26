package edu.lmu.cs.msutton.math;

import junit.framework.TestCase;
import static edu.lmu.cs.msutton.math.MathUtil.intToBinary;

import org.junit.Test;

public class MathUtilTestCase extends TestCase {

	@Test
	public void testIntToBinary(){
		assertEquals(intToBinary(13),"1101");
		assertEquals(intToBinary(8), "1000");
		assertEquals(intToBinary(1), "1");
		assertEquals(intToBinary(0), "0");
	}
	
}
