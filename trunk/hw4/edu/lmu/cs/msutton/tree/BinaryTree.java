package edu.lmu.cs.msutton.tree;

/**
 * 
 * @author Garrett Shannon
 * @author Kelly Sutton
 * 
 */
public class BinaryTree {

	private Object root;

	private BinaryTree left;

	private BinaryTree right;

	/**
	 * 
	 * @param root
	 *            creates a singelton tree
	 */
	public BinaryTree(Object root) {
		this.root = root;
		left = null;
		right = null;
	}

	/**
	 * 
	 * @param root
	 * @param left
	 * @param right
	 *            creates a binary tree
	 */
	public BinaryTree(Object root, BinaryTree left, BinaryTree right) {
		this.root = root;
		this.left = left;
		this.right = right;
	}

	/**
	 * 
	 * @param that
	 *            copy constructor which creates a tree that has the same
	 *            structure and whose nodes refrence the same objects as that
	 *            tree
	 */
	public BinaryTree(BinaryTree that) {
		this.root = that.root;
		this.left = that.left;
		this.right = that.right;
	}

	/**
	 * 
	 * @return the root
	 */
	public Object getRoot() {
		return this.root;
	}

	/**
	 * 
	 * @return the left tree node
	 */
	public BinaryTree getLeft() {
		return this.left;
	}

	/**
	 * 
	 * @return the right tree node
	 */
	public BinaryTree getRight() {
		return this.right;
	}

	/**
	 * 
	 * @param root
	 * @return the original value for the root. replaces root with given
	 *         argument
	 */
	public Object setRoot(Object root) {
		Object temp = this.root;
		this.root = root;
		return temp;
	}

	/**
	 * 
	 * @param left
	 * @return the original value for the left node. replaces left with the
	 *         given argument
	 */
	public BinaryTree setLeft(BinaryTree left) {
		BinaryTree temp = this.left;
		this.left = left;
		return temp;
	}

	/**
	 * 
	 * @param right
	 * @return the original value for the right node. replaces right with the
	 *         given argument
	 */
	public BinaryTree setRight(BinaryTree right) {
		BinaryTree temp = this.right;
		this.right = right;
		return temp;
	}

	public String toString() {
		// TODO write this method
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return true iff this tree node is a leaf
	 */
	public boolean isLeaf() {
		return (left == null && right == null && root != null);
	}

	/**
	 * 
	 * @return the number of elements in the tree
	 */
	public int size() {
		if (this.isLeaf())
			return 1;
		return 1 + left.size() + right.size();
	}

	/**
	 * 
	 * @return thenumber of leaves in the tree
	 */
	public int numLeaves() {
		if (this.isLeaf())
			return 1;
		return left.numLeaves() + right.numLeaves();
	}
}
