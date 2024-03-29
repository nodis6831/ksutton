package edu.lmu.cs.msutton.simulations;

/**
 * A Client interface as copied from the Data Structures book
 * @author KellySutton
 * @author Garrett Shannon
 */

public interface Client {

	public void setStartTime(int t);
	public void setStopTime(int t);
	/**
	 * @return The time the Client was served
	 */
	public int getTotalServiceTime();
	public int getArrivalTime();
	
	/**
	 * @return startTime - arrivalTime
	 */
	public int getWaitTime();
	
	public int getStopTime();
}
