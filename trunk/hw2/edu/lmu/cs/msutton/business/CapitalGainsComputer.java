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

	
	/*
	 * Begin private classes
	 */
	private class LinkedQueue implements Queue {
		private Node head = new Node(null);

		private int size;

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
}
