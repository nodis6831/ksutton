package edu.lmu.cs.msutton.tree;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class BinaryTreeTestCase extends TestCase {
	BinaryTree treeB = new BinaryTree("B");

	BinaryTree treeD = new BinaryTree("D");

	BinaryTree treeE = new BinaryTree("E");

	BinaryTree treeC = new BinaryTree("C", treeD, treeE);

	BinaryTree treeA = new BinaryTree("A", treeB, treeC);

	@Test
	public void testToString() {
		assertEquals(treeA.toString(), "((B),A,((D),C,(E)))");
		assertEquals(treeC.toString(), "((D),C,(E))");
	}

	@Test
	public void testisLeaf() {
		assertTrue(treeD.isLeaf());
		assertTrue(treeE.isLeaf());
		assertTrue(treeB.isLeaf());
		assertFalse(treeA.isLeaf());
		assertFalse(treeC.isLeaf());
	}

	@Test
	public void testSize() {
		assertEquals(treeA.size(), 5);
		assertEquals(treeC.size(), 3);
		assertFalse(treeA.size() == 4);
		assertFalse(treeA.size() == 6);
		assertFalse(treeC.size() == 2);
		assertFalse(treeC.size() == 4);
	}

	@Test
	public void testNumLeaves() {
		assertEquals(treeA.numLeaves(), 3);
		assertEquals(treeC.numLeaves(), 2);
		assertFalse(treeA.numLeaves() == 2);
		assertFalse(treeA.numLeaves() == 4);
		assertFalse(treeC.numLeaves() == 1);
		assertFalse(treeC.numLeaves() == 3);
	}

}
