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
		
		/*
		 * list is only one Node
		 */
		if (list.next() == null){
			return new Node(list.getData());
		}
		
		Node returnNode = new Node(list.getData(), list.next());
		Node returnListIteratorNode = returnNode;
		Node iteratorNode = list;

		while (iteratorNode.next() != null) {
			/*
			 * generating a completely new Node object linked to a Node object
			 * created from list.next() and linked to null
			 */
			returnListIteratorNode.setNext(new Node(iteratorNode.next().getData(), iteratorNode.next().next()));

			/* move onto to the next Node object */
			
			iteratorNode = iteratorNode.next();
			returnListIteratorNode = returnListIteratorNode.next();
		}
		return returnNode;
	}

	/**
	 * Problem 4.8
	 * 
	 * @return a new list that contains a copy of list1, followed by a copy of
	 *         list2
	 */
	public static Node concat(Node list1, Node list2) {

		Node result = copy(list1);
		// Node b = copy(list2); //Making sure we're not playing with the
		// original Nodes in memory

		Node iteratorNode = result;

		while (true) {

			if (iteratorNode.next() == null) {
				iteratorNode.setNext(copy(list2)); // This madness appends a
				// copy of list2
				break;
			}
			iteratorNode = iteratorNode.next();
		}

		return result;
	}

	public static Node merged(Node list1, Node list2) {
		
		Node result = new Node(list1.getData() <= list2.getData() ? list1.getData() : list2.getData());
		//figure out which list has the smallest number
		while (list1.next() != null | list2.next() != null) {
			result.setData(list1.getData() <= list2.getData() ? list1.getData() : list2.getData());
		}

		return result;
	}
}
