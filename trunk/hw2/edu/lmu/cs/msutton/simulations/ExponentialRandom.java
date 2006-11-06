/**
 * 
 */
package edu.lmu.cs.msutton.simulations;

import java.util.Random;

/**
 * The ExponentialRandom class as copied from the Data Structures
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class ExponentialRandom extends Random {

	private double mean;

	public ExponentialRandom(double mean) {
		super(System.currentTimeMillis());
		this.mean = mean;
	}

	public double nextDouble() {
		return -mean * Math.log(1.0 - super.nextDouble());
	}
	
	public int nextInt(){
		return (int)Math.ceil(nextDouble());
	}
}
