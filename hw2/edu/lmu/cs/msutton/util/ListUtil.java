package edu.lmu.cs.msutton.util;

/**
 * @author Kelly Sutton
 * @author Garret Shannon
 */
public class ListUtil {

	/**
	 * Problem 4.5
	 * 
	 * @param list
	 *            the list
	 * @return a new list that is a duplicate of the specified list
	 */
	public static Node copy(Node list) {
		if (list == null)
			return null;
		else
			return new Node(list.getData(), copy(list.next()));
	}

	/**
	 * Problem 4.8
	 * 
	 * @param list1
	 *            the first list
	 * @param list2
	 *            the second list
	 * @return a new list that contains a copy of list1, followed by a copy of
	 *         list2
	 */
	public static Node concat(Node list1, Node list2) {
		if (list1 == null && list2 == null)
			return null;
		else if (list1 == null && list2 != null)
			return copy(list2);
		else if (list1 != null && list2 == null)
			return copy(list1);
		else
			return new Node(list1.getData(), concat(list1.next(), list2));
	}

	/**
	 * Problem 4.11
	 * 
	 * @param list1
	 *            the first list
	 * @param list2
	 *            the second list
	 * @return a new list which is a combination of list1 and list2 but in
	 *         ascending order provided list1 and list2 are already in ascending
	 *         order
	 */
	public static Node merged(Node list1, Node list2) {
		if (list1 == null && list2 == null)
			return null;
		else if (list1 == null && list2 != null)
			return copy(list2);
		else if (list1 != null && list2 == null)
			return copy(list1);
		else if (list1.getData() <= list2.getData()) {
			return new Node(list1.getData(), merged(list1.next(), list2));
		} else {
			return new Node(list2.getData(), merged(list2.next(), list1));
		}
	}
}
