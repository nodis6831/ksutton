package edu.lmu.cs.msutton.util;

/**
 * A quick class to test the recursive Fibonacci calls for exercise 10.6
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

public class Fibonacci {

	private static int counter = 0;
	
	public static void main(String args[]){
		System.out.println(fibonacci(8));
		System.out.println(counter);
	}
	
	
	private static int fibonacci(int n){
		counter++;
		if ( n < 1 ) return 0;
		if ( n < 3 ) return 1;	
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
}
