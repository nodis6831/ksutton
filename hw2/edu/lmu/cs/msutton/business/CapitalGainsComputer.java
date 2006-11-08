package edu.lmu.cs.msutton.business;

import java.util.Date;

/**
 * Project 6.1
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

/**
 * Implement and test Algorithm 6.1 on page 180. You can use the LinkedQueue
 * class in Listing 6.2 on page 182 or the ArrayQueue class from Problem 6.1 on
 * page 196. Alternatively, you can extend the java.util.ArrayList to an
 * implementation of the Queue interface. Use the Transaction class shown in
 * Figure 6.12 to define objects to be stored in the queues. Load your bought
 * and sold queues from data stored in external files.
 */

public class CapitalGainsComputer {

	private static Transaction[] boughtTransactions;
	private static Transaction[] soldTransactions;
	
	public static double main(String[] args){
		
		//TODO load data from an external file
		fetchData();
		//	boughtTransactions = fetchTransactionData();
		//	soldTransactions = fetchSoldTransactionData();
		
		//boughtTransactions = new Transaction[10];	//TMP!
		//soldTransactions = new Transaction[10];	//TMP!
		
		LinkedQueue bought = new LinkedQueue();				// #1
		
		for (Transaction t: boughtTransactions){			// #2
			bought.add(t);
		}
		
		LinkedQueue sold = new LinkedQueue(); 				// #3
			
		for (Transaction t: soldTransactions){				// #4
			sold.add(t);
		}
		
		int gains = 0;										// #5
		
		while( !bought.isEmpty() && !sold.isEmpty() ){		// #6
			Transaction buy = (Transaction) bought.first(); // #7
			Transaction sell = (Transaction) sold.first();
			
			if (buy.getShares() < sell.getShares()){					// #8 - we're selling shares
				gains += buy.getShares() * (sell.getPricePerShare() - buy.getPricePerShare()); // #9
				bought.remove(); // #10
				sell.setShares(sell.getShares() - buy.getShares()); // #11 - doesn't this need to be done beforehand?
			}
			else{
				gains += sell.getShares() * (sell.getPricePerShare() - buy.getPricePerShare()); // #12
				sold.remove(); // #13
				
				if( buy.getShares() == sell.getShares()){ // #14
					bought.remove();
				}
				else{
					buy.setShares(buy.getShares() - sell.getShares());
				}
			}
		}
		
		return gains;
	}
	
	private static void fetchData(){
		
	}
	
	/*
	 * Begin private classes
	 */
	private static class LinkedQueue implements Queue {
		private Node head = new Node(null);

		private int size;

		public LinkedQueue(){
			size = 0;
		}
		
		public void add(Object object) {
			head.prev = head.prev.next = new Node(object, head.prev, head);
			++size;
		}

		public Object first() {
			if (size == 0) {
				throw new IllegalStateException("the queue is empty");
			}
			return head.next.object;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public Object remove() {
			if (size == 0) {
				throw new IllegalStateException("the queue is empty");
			}
			
			Object object = head.next.object;
			head.next = head.next.next;
			head.next.prev = head;
			--size;
			return object;

		}

		public int size(){
			return size;
		}
	}

	private static class Node {
		Object object;

		Node prev = this, next = this;

		Node(Object object) {
			this.object = object;
		}

		Node(Object object, Node prev, Node next) {
			this.object = object;
			this.prev = prev;
			this.next = next;
		}
	}
	
	/**
	 * A Transaction class
	 *
	 * @author Kelly Sutton
	 * @author Garrett Shannon
	 */
	private static class Transaction{
		private int shares;
		private final double pricePerShare;
		private final Date transactionDate;
		
		public Transaction(int s, double p, Date d){
			shares = s;
			pricePerShare = p;
			transactionDate = d;
		}

		public Transaction(){
			shares = 0;
			pricePerShare = 0;
			transactionDate = null;
		}
		
		/**
		 * @return the pricePerShare
		 */
		public double getPricePerShare() {
			return pricePerShare;
		}

		/**
		 * @return the shares
		 */
		public int getShares() {
			return shares;
		}

		public void setShares(int s){
			shares = s;
		}
		
		/**
		 * @return the transactionDate
		 */
		public Date getTransactionDate() {
			return transactionDate;
		}
		
		
	}
}
