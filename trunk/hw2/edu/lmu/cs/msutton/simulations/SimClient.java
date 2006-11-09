package edu.lmu.cs.msutton.simulations;


/**
 * The SimClient class as copied from the Data Structures book
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class SimClient implements Client{

	int id;
	int arrivalTime = -1;
	int startTime = -1;
	int stopTime = -1;
	
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
	
	public int getTotalServiceTime(){
		return stopTime - startTime;
	}
	
	public int getWaitTime(){
		return startTime - arrivalTime;
	}	
	
	public int getArrivalTime(){
		return arrivalTime;
	}
	
	public String toString(){
		return "Client " + id;
	}
}