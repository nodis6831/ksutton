/**
 * 
 */
package edu.lmu.cs.msutton.business;

class CGCNode {
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