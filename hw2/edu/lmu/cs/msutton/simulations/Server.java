package edu.lmu.cs.msutton.simulations;

/**
 * Server interface copied from Data Structures book, p. 187
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public interface Server {

	public int getMeanServiceTime();
	public int getStopTime();
	public boolean isIdle();
	public void startServing(Client client, int t);
	public void stopServing(int t);

}
