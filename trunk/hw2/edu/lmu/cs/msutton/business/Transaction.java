package edu.lmu.cs.msutton.business;

/**
 * A Transaction class
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
class Transaction {
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