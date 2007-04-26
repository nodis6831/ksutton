package edu.lmu.cs.ksutton.cmsi282.hw6;

import java.util.ArrayList;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import static edu.lmu.cs.ksutton.cmsi282.hw6.GeneticSolver.testEquality;

public class GeneticSolverTester extends TestCase {

	public void testInitializeImports() {

		/* BEGIN Test #1 */

		Boolean[][] test1 = GeneticSolver.generateMatrixFullOfFalse(1, GeneticSolver.SIZE_OF_MATRIX);

		test1[0][0] = true;

		assertTrue(GeneticSolver.testEquality(test1, GeneticSolver
				.parseInput("(0)")));

		/* END Test #1 */

		/* BEGIN Test #2 */

		Boolean[][] test2 = GeneticSolver.generateMatrixFullOfFalse(2, GeneticSolver.SIZE_OF_MATRIX);

		test2[0][0] = true;
		test2[0][1] = true;
		test2[0][2] = true;
		test2[1][2] = false;
		test2[1][3] = false;
		test2[1][4] = true;

		assertTrue(testEquality(test2, GeneticSolver
				.parseInput("(0,1,2)(~2,~3,4)")));

		/* END Test #2 */

	}

	public void testCrossover() {

		Boolean[] a = { false, false, true, true };
		Boolean[] b = { true, true, false, false };
		Boolean[] ca = { true, true, true, true };
		Boolean[] cb = { false, false, false, false };

		Boolean[][] c1 = GeneticSolver.crossover(a, b, 2);

		assertTrue(testEquality(c1[0], cb));
		assertTrue(testEquality(c1[1], ca));

		Boolean[] x = { false, false, true, true };
		Boolean[] y = { true, true, false, false };
		Boolean[] cx = { true, true, false, false };
		Boolean[] cy = { false, false, true, true };

		Boolean[][] c2 = GeneticSolver.crossover(x, y, 0);

		assertTrue(testEquality(c2[0], cx));
		assertTrue(testEquality(c2[1], cy));
	}

	/**
	 * This is not the best unit test, but it is _very_ unlikely that it will
	 * ever fail
	 */
	public void testMutate() {

		Boolean[] a = { false, false, true, true, false, true, true, false,
				true, true, false, true, true, false, true, true, false, true,
				false, false, false, true, false, true, false, false, false,
				true, true, true };

		Boolean[] b = GeneticSolver.mutate(a);

		assertFalse(testEquality(a, b));
	}

	public void testEvaluate() {

		/* Test 1 */
		
		Boolean[][] key1 = {{true}};
		
		Boolean[] a = {true};
		Boolean[] b = {false};
		
		assertEquals(GeneticSolver.evaluate(a, key1), 1);
		assertEquals(GeneticSolver.evaluate(b, key1), 0);
		
		/* End Test 1 */
		
		/* Test 2 */
		
		Boolean[][] key2 = {{true, false}, {false, true}};
		
		Boolean[] w = {false, false};
		Boolean[] x = {false, true};
		Boolean[] y = {true, false};
		Boolean[] z = {true, true};
		
		assertEquals(GeneticSolver.evaluate(w, key2), 2);
		assertEquals(GeneticSolver.evaluate(x, key2), 1);
		assertEquals(GeneticSolver.evaluate(y, key2), 1);
		assertEquals(GeneticSolver.evaluate(z, key2), 2);
		
		/* End Test 2 */
		
	}

}
