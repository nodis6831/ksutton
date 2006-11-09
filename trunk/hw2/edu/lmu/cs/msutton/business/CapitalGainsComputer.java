package edu.lmu.cs.msutton.business;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

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

	public static void main(String[] args) {

		// TODO load data from an external file
		fetchData();
		// boughtTransactions = fetchTransactionData();
		// soldTransactions = fetchSoldTransactionData();

		// boughtTransactions = new Transaction[10]; //TMP!
		// soldTransactions = new Transaction[10]; //TMP!

		LinkedQueue bought = new LinkedQueue(); // #1

		for (Transaction t : boughtTransactions) { // #2
			bought.add(t);
		}

		LinkedQueue sold = new LinkedQueue(); // #3

		for (Transaction t : soldTransactions) { // #4
			sold.add(t);
		}

		int gains = 0; // #5

		while (!bought.isEmpty() && !sold.isEmpty()) { // #6
			Transaction buy = (Transaction) bought.first(); // #7
			Transaction sell = (Transaction) sold.first();

			if (buy.getShares() < sell.getShares()) { // #8 - we're selling
														// shares
				gains += buy.getShares()
						* (sell.getPricePerShare() - buy.getPricePerShare()); // #9
				
				bought.remove(); // #10
				
				sell.setShares(sell.getShares() - buy.getShares()); // #11 -
																	// doesn't
																	// this need
																	// to be
																	// done
																	// beforehand?
			} else { //we're selling(?)
				gains += sell.getShares()
						* (sell.getPricePerShare() - buy.getPricePerShare()); // #12
				sold.remove(); // #13

				if (buy.getShares() == sell.getShares()) { // #14
					bought.remove();
				} else {
					buy.setShares(buy.getShares() - sell.getShares());
				}
			}
		}

		System.out.println( gains );
	}
	/*
	private static void fetchData() {

		/*
		 * Portions of this block was **borrowed** from
		 * http://www.roseindia.net/xml/dom/createblankdomdocument.shtml
		 /
		boughtTransactions = new Transaction[100];
		soldTransactions = new Transaction[100];
		
		Document document;
		DateFormat dateParser = DateFormat.getDateInstance();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docParser = factory.newDocumentBuilder();
			document = docParser.parse(new File("./edu/lmu/cs/msutton/business/transactions.xml"));
			
			Node root = (Element) document.getFirstChild();
			//NodeList transList = root.getChildNodes();
			
			NodeList buyList = document.getDocumentElement().getElementsByTagName("buy");
			
			

			/*
			 * This loop fills in the boughtTransactions array with all of the "buys" made
			 /
			for(int i = 0; i < buyList.getLength(); i++){

				boughtTransactions[i].setShares( Integer.parseInt(((Element) buyList.item(i)).getAttribute("shares"))); //discovering the number of shares in the transaction
				boughtTransactions[i].setPricePerShare(Double.parseDouble(((Element) buyList.item(i)).getAttribute("price"))); // price
				boughtTransactions[i].setTransactionDate(dateParser.parse(((Element) buyList.item(i)).getAttribute("date"))); // date
				
			}
			
			
			NodeList sellList = document.getElementsByTagName("sell");
			
			/*
			 * This loops fills in the sellTransactions array with all of the "sells" made
			 /
			for(int i = 0; i < sellList.getLength(); i++){
				
				soldTransactions[i].setShares( Integer.parseInt(((Element) sellList.item(i)).getAttribute("shares"))); //discovering the number of shares in the transaction
				soldTransactions[i].setPricePerShare(Double.parseDouble(((Element) sellList.item(i)).getAttribute("price"))); // price
				soldTransactions[i].setTransactionDate(dateParser.parse(((Element) sellList.item(i)).getAttribute("date"))); // date
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	*/
	private static void fetchData(){
		
		boughtTransactions = new Transaction[]{
			new Transaction(100, 25.00, "2005-03-15"),
			new Transaction(200, 20.00, "2005-08-15")
		};
	
		soldTransactions = new Transaction[]{
			new Transaction(60, 30.00, "2005-03-15"),
			new Transaction(240, 50.00, "2005-10-15")
		};
	}

	/*
	 * Begin private classes
	 */
	private static class LinkedQueue implements Queue {
		private CGCNode head = new CGCNode(null);

		private int size;

		public LinkedQueue() {
			size = 0;
		}

		public void add(Object object) {
			head.prev = head.prev.next = new CGCNode(object, head.prev, head);
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

		public int size() {
			return size;
		}
	}

	private static class CGCNode {
		Object object;

		CGCNode prev = this, next = this;

		CGCNode(Object object) {
			this.object = object;
		}

		CGCNode(Object object, CGCNode prev, CGCNode next) {
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
	private static class Transaction {
		private int shares;

		private double pricePerShare;

		private String transactionDate;

		public Transaction(int s, double p, String d) {
			shares = s;
			pricePerShare = p;
			transactionDate = d;
		}
		
		public Transaction() {
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

		public void setPricePerShare(double d){
			pricePerShare = d;
		}
		/**
		 * @return the shares
		 */
		public int getShares() {
			return shares;
		}

		public void setShares(int s) {
			shares = s;
		}

		/**
		 * @return the transactionDate
		 */
		public String getTransactionDate() {
			return transactionDate;
		}
		
		public void setTransactionDate(String d){
			transactionDate = d;
		}

	}
}
