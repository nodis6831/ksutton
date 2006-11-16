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
}
