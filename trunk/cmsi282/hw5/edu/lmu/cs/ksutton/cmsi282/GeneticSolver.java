package edu.lmu.cs.ksutton.cmsi282;

import java.util.ArrayList;

public class GeneticSolver {

	/**
	 * instance is the particular problem instance GeneticSolver attempts to
	 * solve
	 */
	public static ArrayList<ArrayList<Boolean>> instance = new ArrayList<ArrayList<Boolean>>();

	public static void main(String[] args) {

		instance = parseInput(args[0]);

	}
	
	/**
	 * parseInput will organize the input into the instance array.
	 * @param args The command line arguments
	 */
	static ArrayList<ArrayList<Boolean>> parseInput(String s){

		ArrayList<ArrayList<Boolean>> returnList = new ArrayList<ArrayList<Boolean>>();
		
		//if (s.length > 1)
		//	throw new IllegalArgumentException("There should only be one argument!");
		
		String[] cases = s.split(")");
		
		if (cases.length < 1)
			throw new IllegalArgumentException("Malformed problem instance!");
		
		for(int i = 0; i < cases.length; i++){
			if (cases[i].charAt(0) != '(')
				throw new IllegalArgumentException("Malformed problem instance!");
			cases[i] = cases[i].substring(1);
			
			String[] clause = cases[i].split(",");
			
			for(int j = 0; j < clause.length; j++){
				
				//we're not dealing with a negative
				if(clause[j].charAt(0) != '~')
					returnList.get(i).set(Integer.parseInt(clause[j]), true);    
				
				else
					returnList.get(i).set(Integer.parseInt(clause[j].substring(1)), false);
			}
		}
		
		return returnList;
	}
}
