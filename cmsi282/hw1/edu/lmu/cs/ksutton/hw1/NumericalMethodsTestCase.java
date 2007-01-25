package edu.lmu.cs.ksutton.hw1;

import java.math.BigInteger;
import java.math.BigDecimal;

import junit.framework.TestCase;

import org.junit.Test;

public class NumericalMethodsTestCase extends TestCase {

	@Test
	public void testFibonacci() {

		assertEquals(new BigInteger("0"), NumericalMethods.fibonacci(0));
		assertEquals(new BigInteger("1"), NumericalMethods.fibonacci(1));
		assertEquals(new BigInteger("1"), NumericalMethods.fibonacci(2));
		assertEquals(new BigInteger("2"), NumericalMethods.fibonacci(3));
		assertEquals(new BigInteger("3"), NumericalMethods.fibonacci(4));
		assertEquals(new BigInteger("5"), NumericalMethods.fibonacci(5));
		assertEquals(new BigInteger("8"), NumericalMethods.fibonacci(6));

	}

	@Test
	public void testGCD() {

		BigInteger a = new BigInteger("12");
		BigInteger b = new BigInteger("48");
		BigInteger c = new BigInteger("96");

		assertEquals(new BigInteger("12"), NumericalMethods.gcd(b, a));
		assertEquals(new BigInteger("12"), NumericalMethods.gcd(a, b));
		assertEquals(new BigInteger("12"), NumericalMethods.gcd(a, a));
		assertEquals(new BigInteger("12"), NumericalMethods.gcd(a, c));
		
		assertEquals(new BigInteger("48"), NumericalMethods.gcd(b, c));
	}
	
	@Test
	public void testLCM(){
		BigInteger a = new BigInteger("12");
		BigInteger b = new BigInteger("48");
		BigInteger c = new BigInteger("96");
		
		assertEquals(new BigInteger("48"), NumericalMethods.lcm(a, b));
		assertEquals(new BigInteger("48"), NumericalMethods.lcm(b, a));
		
	}
	
	@Test
	public void testNthRoot(){
		BigDecimal a = new BigDecimal("9");
		BigDecimal b = new BigDecimal("3");
		
		System.out.println(NumericalMethods.nthRoot(2, a));
	}

}
