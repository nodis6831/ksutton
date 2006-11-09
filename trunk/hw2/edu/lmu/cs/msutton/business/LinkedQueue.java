/**
 * 
 */
package edu.lmu.cs.msutton.business;

class LinkedQueue implements Queue {
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