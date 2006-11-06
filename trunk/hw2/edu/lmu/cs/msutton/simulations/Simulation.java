package edu.lmu.cs.msutton.simulations;

import java.util.Queue;

import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * Simulation program, copied from the Data Structures book 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class Simulation {

	static int numServers;
	static int numClients;
	static int meanServiceTime;
	static int meanInterarrivalTime;
	static Server[] servers;
	static Client[] clients;
	static Queue queue = new ArrayQueue();
	static java.util.Random randomArrival;
	static java.util.Random randomService;
	
	public static void main(String[] args){
		init(args);
		//	See Listing 6.3 on page 187
	}
	
	static void init(String[] args){
		if (args.length < 4){
			System.out.println("Usage: java Simulation <numServers> " + " <numClients> <meanServiceTime> <meanInterarrivalTime>");
			System.out.println(" e.g.: java Simulation 3 100 12 4");
			System.exit(0); //Isn't this a huge no-no? Thanks book.
		}
		
		numServers = Integer.parseInt(args[0]);
		numClients = Integer.parseInt(args[1]);
		meanServiceTime = Integer.parseInt(args[2]);
		meanInterarrivalTime = Integer.parseInt(args[3]);
		servers = new Server[numServers];
		clients = new Client[numClients];
		randomService = new ExponentialRandom(meanServiceTime);
		randomArrival = new ExponentialRandom(meanInterarrivalTime);
		queue = new ArrayQueue();
		
		for (int j = 0; j < numServers; j++){
			servers[j] = new SimServer(j, randomService.nextInt());
		}
		
		System.out.println("\t\tNumber of servers = " + numServers );
		System.out.println("\t\tNumber of clients = " + numClients );
		System.out.println("\t\tMean service time = " + meanServiceTime );
		System.out.println("\t\tMean interarrival time = " + meanInterarrivalTime );
		
		for (int j = 0; j < numServers; j++){
			System.out.println("Mean service time for " + servers[j] + " = " + servers[j].getMeanServiceTime());
		}
	}

	private class Server{
		
	}
	

	private class Client{
		
	}
}


