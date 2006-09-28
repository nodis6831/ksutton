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
	double[] e = new double[] {0, -2.3, 10.5, 0,}; 

	ArrayPolynomial a = new ArrayPolynomial(d);
	ArrayPolynomial b = new ArrayPolynomial(e);

	@Test
	public void testToString() {
		assertEquals(a.toString(), "3.0 + 4.7X^2 + -8.2X^3 + -53.0X^4");
		assertEquals(b.toString(), "-2.3X^1 + 10.5X^2");
	}

	@Test
	public void testDerivative() {
		assertEquals(a.derivative().toString(), "4.7X^1 + -8.2X^2 + -53.0X^3");
		assertEquals(b.derivative().toString(), "-2.3 + 10.5X^1");
	}

	@Test
	public void testGetDegree() {
		assertEquals(a.getDegree(), 4);
		assertEquals(a.derivative().getDegree(), 3);
		assertEquals(b.getDegree(), 2);
		assertEquals(b.derivative().getDegree(), 1);
	}
	
	@Test
	public void testValueAt() {
		assertEquals(a.valueAt(0), 3.0);
		assertEquals(a.valueAt(1), -53.5);
	}
}
