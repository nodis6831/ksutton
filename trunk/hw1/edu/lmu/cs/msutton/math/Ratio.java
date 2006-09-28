package edu.lmu.cs.msutton.math;

/**
 * A rather stupid Ratio interface
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

public interface Ratio {

	public long getNum();
	public long getDen();
	public boolean equals(Object obj);
	public String toString();
}
