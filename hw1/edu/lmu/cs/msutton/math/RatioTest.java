package edu.lmu.cs.msutton.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Test cases for the Ratio interface and RatioImpl class
 * 
 * @author Garrett Shannon
 * @author Kelly Sutton
 * 
 */

public class RatioTest {

	@Test
	public void testGetters() {
		RatioImpl a = new RatioImpl(100, 1000);

		assertTrue(a.getNum() == 100);
		assertTrue(a.getDen() == 1000);
	}

	@Test
	public void testIdenticalRatios() {
		RatioImpl a = new RatioImpl(1, 1);
		RatioImpl b = new RatioImpl(1, 1);

		assertEquals(a, b);
	}

	@Test
	public void testZeroDenominator() {
		try {
			RatioImpl a = new RatioImpl(1, 0);
		} catch (IllegalArgumentException e) {
			assertNotNull(e);
		}
	}

}