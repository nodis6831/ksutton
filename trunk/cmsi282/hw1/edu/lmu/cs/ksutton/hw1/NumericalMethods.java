package edu.lmu.cs.ksutton.hw1;

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
}
