package edu.lmu.cs.ksutton.cmsi282.hw6;

import java.util.ArrayList;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import static edu.lmu.cs.ksutton.cmsi282.hw6.GeneticSolver.testEquality;


public class GeneticSolverTester extends TestCase {

	public void testInitializeImports(){
	
		/* BEGIN Test #1 */
		
		Boolean[][] test1 = GeneticSolver.fillMatrixWithFalse();
		
		test1[0][0] = true;
		
		assertTrue(GeneticSolver.testEquality(test1, GeneticSolver.parseInput("(0)")));
		
		/* END Test #1 */
		
		/* BEGIN Test #2 */
		
		Boolean[][] test2 = GeneticSolver.fillMatrixWithFalse();
		
		test2[0][0] = true;
		test2[0][1] = true;
		test2[0][2] = true;
		test2[1][2] = false;
		test2[1][3] = false;
		test2[1][4] = true;
		
		assertTrue(testEquality(test2, GeneticSolver.parseInput("(0,1,2)(~2,~3,4)")));
		
		/* END Test #2 */
		
	}
	
	public void testCrossover(){
		
		Boolean[] a = {false, false, true, true};
		Boolean[] b = {true, true, false, false};
		Boolean[] ca = {true, true, true, true};
		Boolean[] cb = {false, false, false, false};
		
		Boolean[][] c1 = GeneticSolver.crossover(a, b, 2);

		assertTrue(c1[0].equals(cb));
		
	}
	
}
