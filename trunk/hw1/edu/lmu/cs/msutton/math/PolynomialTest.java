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

	ArrayPolynomial a = new ArrayPolynomial(d);

	@Test
	public void testToString() {
		assertEquals(a.toString(), "3.0 + 4.7X^2 + -8.2X^3 + -53.0X^4");

	}

	@Test
	public void testDerivative() {
		assertEquals(a.derivative().toString(), "4.7X^1 + -8.2X^2 + -53.0X^3");
	}

	@Test
	public void testGetDegree() {
		assertEquals(a.getDegree(), 4);
		assertEquals(a.derivative().getDegree(), 3);
	}
}
