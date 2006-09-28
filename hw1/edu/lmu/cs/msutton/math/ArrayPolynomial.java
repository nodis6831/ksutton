package edu.lmu.cs.msutton.math;

import java.util.Arrays;

/**
 * A class representing a single variable polynomial with real number
 * coefficients using an array. When creating the ArrayPolynomial, you must use
 * an array of doubles where the index of each element represents the power of
 * the x term to which it is a coefficient.
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 */
public class ArrayPolynomial implements Polynomial {

	private double[] coefficients;

	/**
	 * 
	 * @param coefficients
	 *            polynomial coefficients
	 */
	public ArrayPolynomial(double[] coefficients) {
		this.coefficients = new double[coefficients.length];
		System.arraycopy(coefficients, 0, this.coefficients, 0,
				coefficients.length);
		// TODO do we need a defensive copy?
	}

	/**
	 * 
	 * @return the derivative
	 */
	public ArrayPolynomial derivative() {
		double[] derivative = new double[this.coefficients.length - 1];
		System
				.arraycopy(this.coefficients, 1, derivative, 0,
						derivative.length);
		return new ArrayPolynomial(derivative);
	}

	/**
	 * 
	 * @return the degree
	 */
	public int getDegree() {
		int i = (this.coefficients.length - 1);
		while (this.coefficients[i] == 0.0) {
			i--;
		}
		return i;
		// TODO Better way to do this?
	}

	/**
	 * 
	 * @param d
	 *            number to evaluate at
	 * @return value of the polynomial
	 */
	public double valueAt(double d) {
		double sum = 0; // TODO better way to do this?
		for (int i = 0; i < coefficients.length; i++) {
			sum += (Math.pow(d, i)) * coefficients[i];
		}
		return sum;
	}

	/**
	 * Returns a brief description of the Card. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical: "Polynomial: 3 + -2.32X^1 + 7.002X^2 + -33X^3 +
	 * 5X^5" Note* It skips coefficients of zero
	 */
	@Override
	public String toString() {
		StringBuffer buffer;
		if (coefficients[0] == 0.0) {
			buffer = new StringBuffer();
		} else {
			buffer = new StringBuffer(coefficients[0] + " + ");
		}
		for (int i = 1; i < coefficients.length - 1; i++) {
			if (coefficients[i] == 0.0) {
			} else {
				buffer.append(coefficients[i] + "X^" + i + " + ");
			}
		}
		if (coefficients[coefficients.length - 1] == 0) {
			buffer.setLength(buffer.length() - 3);
		} else {
			buffer.append(coefficients[coefficients.length - 1] + "X^"
					+ (coefficients.length - 1));
		}
		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + Arrays.hashCode(coefficients);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ArrayPolynomial other = (ArrayPolynomial) obj;
		if (!Arrays.equals(coefficients, other.coefficients))
			return false;
		return true;
	}

}
