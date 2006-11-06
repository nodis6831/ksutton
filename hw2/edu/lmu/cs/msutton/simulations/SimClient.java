package edu.lmu.cs.msutton.simulations;


/**
 * The SimClient class as copied from the Data Structures book
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class SimClient {

	int id, arrivalTime=-1, startTime=-1, stopTime=-1;
	
	public SimClient(int id, int t){
		this.id = id;
		arrivalTime = t;
		System.out.println(this + " arrived at time " + t);
	}
	
	public int getStartTIme(){
		return startTime;
	}
	
	public int getStopTime(){
		return stopTime;
	}
	
	public void setStartTime(int t){
		startTime = t;
	}
	
	public void setStopTime(int t){
		stopTime = t;
	}
	
	public String toString(){
		return "Client " + id;
	}
}