package edu.lmu.cs.msutton.math;

/**
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 */
public class MathUtil {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println("A(" + i + ", " + j + ") = " + A(i, j));
			}
		}
		System.out.println("A(3, 4) = " + A(3, 4));
		System.out.println("A(3, 5) = " + A(3, 5));
		System.out.println("A(3, 6) = " + A(3, 6));
		System.out.println("A(3, 7) = " + A(3, 7));
		System.out.println("A(3, 8) = " + A(3, 8));
		System.out.println("A(3, 9) = " + A(3, 9));
		System.out.println("A(4, 0) = " + A(4, 0));
		// Just testing some of the limits of this function. If x = 4, y cannot
		// be greater that 0 else I get a stack overflow error

	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 * 
	 */

	public static int A(int x, int y) {
		if (x == 0 && y >= 0)
			return y + 1;
		else if (y == 0 && x > 0)
			return A(x - 1, 1);
		else if (x > 0 && y > 0)
			return A(x - 1, A(x, y - 1));
		else
			throw new IllegalArgumentException(); // if x or y is less than 0
	}

	/*
	 * Problem 10.8
	 * 
	 * Write and test a recursive method that returns the maximum value among
	 * the n elements {a(sub)p, ..., a(sub)p+n-1} of a subsequence of integers,
	 * using at most lg n recursive calls. [Hint: use the divide-and-conquer
	 * strategy.]
	 */

	public int maxValueInSequence(int[] a) {
		return 0;
	}

	/*
	 * Problem 10.11
	 * 
	 * Write and test a recursive function that returns a string that contains
	 * the binary representation of a positive integer.
	 */

	/**
	 * This is the public entry method for converting an int to the requested
	 * binary String. It catches a 0 case that would have been difficult to
	 * account for otherwise.
	 */
	public static String intToBinary(int n) {
		if (n == 0)	return "0"; // the 0-case
		return intToBinaryHelper(n);
	}

	/**
	 * Helper method for the public intToBinary. The actual recursion occurs
	 * here. This method is a private method because the 0 would have added too
	 * much unnecessary complexity otherwise.
	 */
	private static String intToBinaryHelper(int n) {
		if (n == 0)	return ""; //base case
		return n % 2 == 1 ? intToBinaryHelper(n/2) + "1" : intToBinaryHelper(n/2) +"0";
	}
}
