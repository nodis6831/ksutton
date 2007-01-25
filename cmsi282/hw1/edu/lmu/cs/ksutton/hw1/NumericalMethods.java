package edu.lmu.cs.ksutton.hw1;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumericalMethods {

	/**
	 * 
	 * @param n
	 *            index that is 0, 1, 2
	 * @return the nth number in the sequence: 0, 1, 1, 2, 3, 5, 8, 13, ...
	 */
	public static BigInteger fibonacci(int n) {

		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		BigInteger f = new BigInteger("-1");

		if (n < 0) {
			throw new IllegalArgumentException();
		}

		if (n == 0) {
			return a;
		}

		else if (n == 1) {
			return b;
		}

		else { // n > 2
			for (int i = 0; i <= n - 2; i++) {
				f = a.add(b);
				a = b;
				b = f;
			}
			return f;
		}
	}

	/**
	 * A recursive greatest common divisor method that uses Euclid's algorithm
	 * 
	 * @param m
	 * @param n
	 * @return the greatest common divisor of m and n
	 */
	public static BigInteger gcd(BigInteger m, BigInteger n) {
		if (m.mod(n).equals(new BigInteger("0"))) {
			return n;
		} else
			return gcd(n, m.mod(n));

	}

	/**
	 * A simple least common multiple function
	 * 
	 * @param m
	 * @param n
	 * @return the least common multiple of m and n
	 */
	public static BigInteger lcm(BigInteger m, BigInteger n) {
		if (m.equals(new BigInteger("0")) || n.equals(new BigInteger("0"))) {
			throw new IllegalArgumentException();
		}

		return (m.multiply(n)).divide(gcd(m, n)); // this mess gives you the
		// least common multiple.
		// http://en.wikipedia.org/wiki/Least_common_multiple

	}

	/**
	 * Uses a method of finding a square root within so that the square is
	 * within .0001 of the actual root
	 * 
	 * @param n
	 * @param x
	 * @return the nth root of x using my own generalization of Newton's methods
	 *         for finding square roots
	 */
	public static BigDecimal nthRoot( int n, BigDecimal x){
		BigDecimal errorFactor = new BigDecimal(".0001");
		
		BigDecimal a = new BigDecimal("0");
		BigDecimal b = new BigDecimal(x.toString()); // setting our start
														// values
		BigDecimal guess = b.subtract(a).divide(new BigDecimal("2"));
		
		//int k = 0;
		
		while ( guess.pow(n).subtract(x).abs().compareTo(errorFactor) > 0 /*&& k < 1000*/){ 
		//this mess checks to see if we're in .0001 of the root
			if (guess.pow(n).compareTo(x) > 0 ){
			//our guess.pow(n) is greater than x
				b = guess;
				guess = b.subtract(a).divide(new BigDecimal("2"));
			}
			
			else{ 
			//our guess.pow(n) is less than x
				a = guess;
				guess = b.subtract(a).divide(new BigDecimal("2"));
			}
			//k++;
		}
		
		return guess;
	}
}
