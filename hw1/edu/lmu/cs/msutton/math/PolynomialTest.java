package edu.lmu.cs.msutton.math;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 */
public class PolynomialTest {
	double[] d = new double[] { 3, 0, 4.7, -8.2, -53 };

	@Test
	public void testToString() {
		ArrayPolynomial a = new ArrayPolynomial(d);
		assertEquals(a.toString(), "3.0 + 4.7X^2 + -8.2X^3 + -53.0X^4");

	}
}
