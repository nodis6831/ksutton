package edu.lmu.cs.msutton.util;

/**
 * Problem 4.5
 * 
 * @author Kelly Sutton
 * @author Garret Shannon
 */
public class ListUtil {

	/**
	 * @return a new list that is a duplicate of the specified list
	 */
	public static Node copy(Node list) {

		Node node;
		Node node2;

		try { // list is more than one Node long
			node2 = new Node(list.next().getData()); // a placeholder to link
			// to

			node = new Node(list.getData(), node2);
		}

		catch (Exception e) {
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
	 * Problem 4.8
	 * 
	 * @return a new list that contains a copy of list1, followed by a copy of
	 *         list2
	 */
	public static Node concat(Node list1, Node list2) {

		Node returnList = copy(list1);
		// Node b = copy(list2); //Making sure we're not playing with the
		// original Nodes in memory

		Node iteratorNode = returnList;

		while (true) { // looking two ahead

			if (iteratorNode.next() == null) {
				iteratorNode.setNext(copy(list2)); // This madness appends a
													// copy of list2
				break;
			}
		}

		return returnList;
	}
	
	public static Node merged(Node list1, Node list2){
		Node result;
		return result;
	}
}
