package edu.lmu.cs.msutton.util;

public class Node {
	/**
	 * The Node class as copied from our Data Structures with Java book (the
	 * lame one).
	 * 
	 * @author Data Structures book
	 */

	private int data;

	private Node next;

	public Node(int i) {
		data = i;
		next = null; // TODO is this safe/what it's supposed to do?
	}

	public Node(int i, Node n) {
		data = i;
<<<<<<< .mine
		this.next = next;
=======
		next = n;
>>>>>>> .r196
	}

	public int getData() {
		return data;
	}
	
	public void setData(int i){
		data = i;
	}

	public Node next() {
		return next;
	}
	
	public void setNext(Node node){
		next = node;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + data;
		result = PRIME * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Node other = (Node) obj;
		if (data != other.data)
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}

	@Override
	public String toString(){
		return Integer.toString(data);
	}

}
