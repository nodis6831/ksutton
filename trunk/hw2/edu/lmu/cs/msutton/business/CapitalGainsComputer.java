package edu.lmu.cs.msutton.business;

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

	public static Transaction[] boughtTransactions;

	public static Transaction[] soldTransactions;

	public static void main(String[] args) {

		fetchData(); // In a perfect world, this would read data from a file
		System.out.println(computeCapitalGains());

	}

	/*
	 * Frustration set in and deadlines are approaching. We're going to abandon
	 * this XML-sickness for now.
	 * 
	 * 
	 * private static void fetchData() {
	 *  /* Portions of this block was **borrowed** from
	 * http://www.roseindia.net/xml/dom/createblankdomdocument.shtml /
	 * boughtTransactions = new Transaction[100]; soldTransactions = new
	 * Transaction[100];
	 * 
	 * Document document; DateFormat dateParser = DateFormat.getDateInstance();
	 * try { DocumentBuilderFactory factory = DocumentBuilderFactory
	 * .newInstance(); DocumentBuilder docParser = factory.newDocumentBuilder();
	 * document = docParser.parse(new
	 * File("./edu/lmu/cs/msutton/business/transactions.xml"));
	 * 
	 * Node root = (Element) document.getFirstChild(); //NodeList transList =
	 * root.getChildNodes();
	 * 
	 * NodeList buyList =
	 * document.getDocumentElement().getElementsByTagName("buy");
	 * 
	 * 
	 *  /* This loop fills in the boughtTransactions array with all of the
	 * "buys" made / for(int i = 0; i < buyList.getLength(); i++){
	 * 
	 * boughtTransactions[i].setShares( Integer.parseInt(((Element)
	 * buyList.item(i)).getAttribute("shares"))); //discovering the number of
	 * shares in the transaction
	 * boughtTransactions[i].setPricePerShare(Double.parseDouble(((Element)
	 * buyList.item(i)).getAttribute("price"))); // price
	 * boughtTransactions[i].setTransactionDate(dateParser.parse(((Element)
	 * buyList.item(i)).getAttribute("date"))); // date
	 *  }
	 * 
	 * 
	 * NodeList sellList = document.getElementsByTagName("sell");
	 *  /* This loops fills in the sellTransactions array with all of the
	 * "sells" made / for(int i = 0; i < sellList.getLength(); i++){
	 * 
	 * soldTransactions[i].setShares( Integer.parseInt(((Element)
	 * sellList.item(i)).getAttribute("shares"))); //discovering the number of
	 * shares in the transaction
	 * soldTransactions[i].setPricePerShare(Double.parseDouble(((Element)
	 * sellList.item(i)).getAttribute("price"))); // price
	 * soldTransactions[i].setTransactionDate(dateParser.parse(((Element)
	 * sellList.item(i)).getAttribute("date"))); // date
	 *  }
	 *  } catch (Exception e) { System.out.println(e.getMessage()); } }
	 */
	private static void fetchData() {


	}

	static int computeCapitalGains() {

		if (boughtTransactions == null || soldTransactions == null)
			throw new IllegalStateException();

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
			} else {
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

		return gains;
	}
}
