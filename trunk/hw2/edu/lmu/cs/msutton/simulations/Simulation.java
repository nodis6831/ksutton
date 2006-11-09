package edu.lmu.cs.msutton.simulations;


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
	static int nextArrivalTime = 0;
	static Server[] servers;
	static Client[] clients;
	static BoundedQueue queue;
	static java.util.Random randomArrival;
	static java.util.Random randomService;

	
	public static void main(String[] args){
		init(args);
		
		//	from page 187
		int nextClient = 0;
		for (int t=0; ; t++){
			if (t == nextArrivalTime){
				Client client = clients[nextClient++] = new SimClient(nextClient, t);
				queue.enqueue(client);
				nextArrivalTime = t + randomArrival.nextInt();
			}
			for( int j = 0; j < numServers; j++){
				Server server = servers[j];
				if (t == server.getStopTime()){
					server.stopServing(t);
				}
				if (server.isIdle() && !queue.isEmpty()){
					Client client = (SimClient)queue.dequeue();
					server.startServing(client, t);
				}
			}
		}
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
		queue = new BoundedQueue(numClients);//TODO should this just be an ArrayQueue? Where do we find that?
		
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
		
		/*
		 * Computing average client wait time and average total time in system
		 */
		int totalClientWaitTime = 0;
		int totalClientTimeInSystem = 0;
		int numClients = 0;
		/*for (Client c : clients){
			totalClientWaitTime += c.getWaitTime();
			totalClientTimeInSystem += c.getStopTime() - c.getArrivalTime() ;
			numClients++;
		}
		int averageClientWaitTime = totalClientWaitTime / numClients;
		int averageClientTimeInSystem = totalClientTimeInSystem / numClients;
		
		System.out.println("\t\tAverage time client waited in queue = " + averageClientWaitTime);
		System.out.println("\t\tAverage time client spent in system = " + averageClientTimeInSystem);
		
		 */
		
		/*
		 * Computing average total time that a client spends in the system
		 */
	}
	
}


