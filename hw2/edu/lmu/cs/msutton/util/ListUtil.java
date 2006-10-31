package edu.lmu.cs.msutton.util;

/**
 * Problem 4.5
 * 
 * @author Kelly Sutton
 * @author Garret Shannon
 */
public class ListUtil {

	/*
	 * @return a new list that is a duplicate of the specified list
	 */
	Node copy(Node list) {

		Node node;
		Node node2;
		
		try{ //list is more than one Node long
			node2 = new Node(list.next().getData()); // a placeholder to link
			// to
			
			node = new Node(list.getData(), node2);
		}
		
		catch (Exception e){
			return new Node(list.getData());
		}
		
		while (list.next() != null) {
			/*
			 * generating a completely new Node object linked to a Node object
			 * created from list.next() and linked to null
			 */
			node2 = new Node(list.getData(), new Node(list.next().getData()));
			
			/* move onto to the next Node object */
			list = list.next();
			node2 = node2.next();
		}

		return node;

	}

	/**
	 * The Node class as copied from our Data Structures with Java book (the
	 * lame one).
	 * 
	 * @author Data Structures book
	 */
	private class Node {
		private int data;

		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null; // TODO is this safe/what it's supposed to do?
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public Node next() {
			return next;
		}
	}

}
