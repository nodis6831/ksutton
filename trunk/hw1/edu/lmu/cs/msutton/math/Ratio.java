package edu.lmu.cs.msutton.math;

/**
 * A rather stupid Ratio interface
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

public interface Ratio {

	long getNum();
	long getDen();
	boolean equals(Object obj);
	String toString();
}
