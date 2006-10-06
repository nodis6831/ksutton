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
	double[] a = new double[] { 3, 0, 4.7, -8.2, -53 };
	double[] b = new double[] {0, -2.3, 10.5, 0,};
	double[] c = new double[] { 0, 3, 0, 4.7, -8.2, -53, 0, 0 };
	double[] d = new double[0];
	double[] e = new double[] {0};
	
	Polynomial polyA = new ArrayPolynomial(a);
	Polynomial polyB = new ArrayPolynomial(b);
	Polynomial polyC = new ArrayPolynomial(a);
	Polynomial polyD = new ArrayPolynomial(c);
	Polynomial polyE = new ArrayPolynomial(d);
	Polynomial polyF = new ArrayPolynomial(e);
	Polynomial polyG = polyB;
//	TODO how did you test to see that the correct exception was being thrown??

	@Test
	public void testToString() {
		assertEquals(polyA.toString(), "3.0 + 4.7X^2 + -8.2X^3 + -53.0X^4");
		assertEquals(polyB.toString(), "-2.3X^1 + 10.5X^2");
		assertEquals(polyD.toString(), "3.0X^1 + 4.7X^3 + -8.2X^4 + -53.0X^5");
		assertEquals(polyF.toString(), "0");
		System.out.println(polyE.toString());
		//TODO polyE.toString() should throw exception
	}

	@Test
	public void testDerivative() {
		assertEquals(polyA.derivative().toString(), "4.7X^1 + -8.2X^2 + -53.0X^3");
		assertEquals(polyB.derivative().toString(), "-2.3 + 10.5X^1");
		assertEquals(polyD.derivative().toString(), "3.0 + 4.7X^2 + -8.2X^3 + -53.0X^4");
		//TODO polyE.derivative() and polyF.derivative() should throw exception
	}

	@Test
	public void testGetDegree() {
		assertEquals(polyA.getDegree(), 4);
		assertEquals(polyA.derivative().getDegree(), 3);
		assertEquals(polyB.getDegree(), 2);
		assertEquals(polyB.derivative().getDegree(), 1);
		assertEquals(polyD.getDegree(), 5);
		assertEquals(polyD.derivative().getDegree(), 4);
		assertEquals(polyF.getDegree(), 0);
	}
	
	@Test
	public void testValueAt() {
		assertEquals(polyA.valueAt(0), 3.0);
		assertEquals(polyA.valueAt(1), -53.5);
		assertEquals(polyF.valueAt(7), 0);
	}
	
	@Test
	public void testEquals() {
		assertEquals(polyG, polyB);
		assertEquals(polyA, polyC);		
	}
}
