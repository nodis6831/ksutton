package edu.lmu.cs.msutton.math;

public class RatioImpl extends Ratio {

	private long num;

	private long den; // numerator and denominator

	/**
	 * A Ratio class
	 * 
	 * @param n
	 *            The numerator of the RatioImpl object
	 * @param d
	 *            The denominator of the RatioImpl object
	 */
	public RatioImpl(long n, long d) {
		if (d > 0 && gcf(n, d) == 1 || (gcf(n, d) == n)) {
			this.num = n;
			this.den = d;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Function from http://forums.dreamincode.net/showtopic18476.htm
	 * 
	 * @param u
	 *            First long
	 * @param v
	 *            Second long
	 * @return The greatest common factor (GCF)
	 */
	private long gcf(long u, long v) { // TODO test if this actually works
		int k = 0;
		if (u == 0)
			return v;
		if (v == 0)
			return u;
		while ((u & 1) == 0 && (v & 1) == 0) // while both u and v are even
		{
			u >>= 1; // shift u right, dividing it by 2
			v >>= 1; // shift v right, dividing it by 2
			k += 1; // add a power of 2 to the final result
		}
		do {
			if ((u & 1) == 0) // if u is even
				u >>= 1; // divide u by 2
			else if ((v & 1) == 0) // else if v is even
				v >>= 1; // divide v by 2
			else if (u >= v) // u and v are both odd
				u = (u - v) >> 1;
			else
				// u and v both odd, v > u
				v = (v - u) >> 1;
		} while (u > 0);
		return v << k; // returns v * 2^k
	}
}
