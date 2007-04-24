package edu.lmu.cs.ksutton.cmsi282;

import java.util.ArrayList;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class GeneticSolverTester extends TestCase {

	public void testInitializeImports(){
	
		ArrayList<ArrayList<Boolean>> test1 = new ArrayList<ArrayList<Boolean>>(10);
		
		//TODO make a BoolMatrix class
		test1.set(0, new ArrayList<Boolean>(10));
		test1.get(0).set(0, true);
		
		assertTrue(test1.equals(GeneticSolver.parseInput("(0)")));
		
	}
}
