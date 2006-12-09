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
		return root;
	}

	/**
	 * 
	 * @return the left tree node
	 */
	public BinaryTree getLeft() {
		return left;
	}

	/**
	 * 
	 * @return the right tree node
	 */
	public BinaryTree getRight() {
		return right;
	}

	/**
	 * 
	 * @param root
	 * @return the original value for the root. replaces root with given
	 *         argument
	 */
	public Object setRoot(Object rootObj) {
		Object temp = root;
		root = rootObj;
		return temp;
	}

	/**
	 * 
	 * @param left
	 * @return the original value for the left node. replaces left with the
	 *         given argument
	 */
	public BinaryTree setLeft(BinaryTree tree) {
		BinaryTree temp = left;
		left = tree;
		return temp;
	}

	/**
	 * 
	 * @param right
	 * @return the original value for the right node. replaces right with the
	 *         given argument
	 */
	public BinaryTree setRight(BinaryTree tree) {
		BinaryTree temp = right;
		right = tree;
		return temp;
	}

	@Override
	public String toString() {

		/*
		 * We're dealing with a leaf node, just print out its contents in a set
		 * of parens
		 */
		if (isLeaf()) {
			return "(" + root.toString() + ")";
		}

		/*
		 * Both left and right are not null, so we recurse down to both of them
		 * while printing out the contents of the root
		 */
		else if (left != null && right != null) {
			return "(" + left.toString() + "," + root.toString() + ","
					+ right.toString() + ")";
		}

		/*
		 * The right tree is null so we only recurse to the left
		 */
		else if (left != null && right == null) {
			return "(" + left.toString() + "," + root.toString() + ")";
		}

		/*
		 * The left tree is null so we only recurse to the right
		 */
		else
			return "(" + root.toString() + "," + right.toString() + ")";
	}

	/**
	 * 
	 * @return true iff this tree node is a leaf
	 */
	public boolean isLeaf() {
		return (left == null && right == null && root != null);
	}

	/**
	 * Recursive height function
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		if (this.isLeaf())
			return 1;
		return this.left.height() >= this.right.height() ? this.left.height()
				: this.right.height();
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
	 * @return the number of leaves in the tree
	 */
	public int numLeaves() {
		if (this.isLeaf())
			return 1;
		return left.numLeaves() + right.numLeaves();
	}

	/**
	 * isFull() checks to see if this tree is full by comparing a binary log of
	 * the size to the height of the tree
	 * 
	 * @return whether or not the binary tree is full
	 */
	public boolean isFull() {
		return Math.log((double) this.size() + 1.0) / Math.log(2.0) - 1 == (double) this
				.height();
	}

	/**
	 * A recursive method that counts the instances of the Object x in a given
	 * tree.
	 * 
	 * @return the number of references that this tree has to the given object
	 *         x.
	 */
	public int count(Object x) {

		/*
		 * If the root of the tree is null, we've reached the end and need to
		 * stop recursing
		 */
		if (root == null)
			return 0;
		else if (isLeaf()) {
			return getRoot().equals(x) ? 1 : 0;
		}

		/*
		 * If x is equal to the root, we add one to the count and recurse to the
		 * left and to the right Otherwise we just recurse left and right
		 */
		if (left != null && right != null) {
			return root.equals(x) ? 1 + left.count(x) + right.count(x) : left
					.count(x)
					+ right.count(x);
		}

		/*
		 * The right child is null so we can only recurse to the left. Add one
		 * and recurse if this is equal to Object x
		 */
		else if (left != null && right == null)
			return root.equals(x) ? 1 + left.count(x) : left.count(x);

		/*
		 * The left child is null so we can only recurse to the right. Add one
		 * and recurse if the this is equals to Object x. We don't have to worry
		 * about both left and right being null because we checked to see if
		 * this is a leaf node earlier
		 */
		else
			return root.equals(x) ? 1 + right.count(x) : right.count(x);

	}

	/**
	 * 
	 * @return a copy of the reverse of the binary tree as though it has been flipped along
	 *         its vertical axis
	 */
	public BinaryTree reverse() {
		BinaryTree returnTree = new BinaryTree(this);
		
		BinaryTree oldLeft = left;
		BinaryTree oldRight = right;
		
		if (oldLeft != null) {
			setRight(oldLeft.reverse());
		}
		
		if (oldRight != null){
			setLeft(oldRight.reverse());
		}
		return returnTree;
	}
}
