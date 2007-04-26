package edu.lmu.cs.ksutton.cmsi282.hw6;

import java.util.ArrayList;
import java.util.Random;

/**
 * CMSI 282 Problem Set #6 Problem #2
 * 
 * This is the GeneticSolver, which works (surprise!). It is, however, a good
 * example of sloppy Java programming. There are far too many hard-coded values
 * as is. To get rid of these hard-coded values, I'd have to go through the
 * user-input twice. That would require a decent amount of recoding.
 * 
 * The unit tests are not the extensive by any means, but they do test a few of
 * the more vital corner cases.
 * 
 * While iterating through generations, it's a crapshoot as to which method of
 * population change will occur. It randomly picks between the crossover method
 * and the mutation method.
 * 
 * IMPORTANT NOTE: Currently, GeneticSolver is not implementing "natural
 * selection," i.e., attempting to keep the better members of the population. It
 * usually spits out a solution to pretty complex problems with
 * NUMBER_OF_GENERATIONS set high enough. Cool.
 * 
 * In the future, it might be worth messing with the NUMBER_OF_GENERATIONS and
 * SIZE_OF_POPULATION. Should they always be proportional? Should they be
 * proportional to the number of variables used in the program instance? Does it
 * matter as long as they are large enough? The program runs quickly on my
 * desktop with 1000000 generations and 100 "citizens."
 * 
 * @author Kelly Sutton
 * 
 */
public class GeneticSolver {

	public static final int SIZE_OF_MATRIX = 100;

	public static final int NUMBER_OF_GENERATIONS = 1000000;

	public static final int SIZE_OF_POPULATION = 100;

	public static final int NUM_DIFFERENT_MODIFICATIONS = 2;

	public static int NUM_CLAUSES;

	public static final Random GENERATOR = new Random();

	/**
	 * instance is the particular problem instance GeneticSolver attempts to
	 * solve. Right now, it doesn't automatically size itself per the number of
	 * arguments entered by the user, which is bad.
	 */
	public static Boolean[][] instance = new Boolean[SIZE_OF_MATRIX][SIZE_OF_MATRIX];

	public static int numVariables;

	public static ArrayList<Boolean[]> population;

	/**
	 * How fit was the previous population? We'll assign an arbitrary value to
	 * that!
	 */
	public static int previousPopulationGoodness;

	public static void main(String[] args) {

		/* Initialize Arguments */
		instance = parseInput(args[0]);

		/* Create Inital Population */
		population = initializePopulation(SIZE_OF_POPULATION);

		/* Evalutate each possibility */

		/* END Evalutation */

		int t = 0;
		int chooser; // decide how we're going to modify the population
		int oneThirdPopulation = SIZE_OF_POPULATION / 3;
		int currentPair1, currentPair2;
		int smallFractionOfThePopulation = SIZE_OF_POPULATION / 30;
		// TODO find some fancy way to assign 30
		int modStep;
		int populationGoodness = 0;

		while (t < NUMBER_OF_GENERATIONS) {

			previousPopulationGoodness = populationGoodness;
			populationGoodness = 0;

			/* Select "fitter" members */
			int top25PercentStartIndex = SIZE_OF_POPULATION
					- ((SIZE_OF_POPULATION * 7) / 10);

			/* Modify population - Choose randomly */
			chooser = GENERATOR.nextInt(NUM_DIFFERENT_MODIFICATIONS);
			switch (chooser) {

			/*
			 * Construct new pairs via "crossover" of randomly-selected paris in
			 * P(t)
			 */
			case 0:
				/*
				 * Perform crossovers on oneThirdPopulation. Really this will be
				 * anywhere between 2 members of the population and 2/3 the
				 * population the way this algorithm works.
				 */
				for (int i = 0; i < oneThirdPopulation; i++) {

					/* Generate random pairs to cross over */
					currentPair1 = GENERATOR.nextInt(SIZE_OF_POPULATION);
					currentPair2 = GENERATOR.nextInt(SIZE_OF_POPULATION);

					/*
					 * We don't want to make a big fuss if the two happen to be
					 * the same
					 */
					if (currentPair1 == currentPair2)
						continue;

					/* Perform the crossover */
					Boolean[][] tmpArray = crossover(population
							.get(currentPair1), population.get(currentPair2));

					/* Reassign the crossed over pairs */
					population.set(currentPair1, tmpArray[0]);
					population.set(currentPair2, tmpArray[1]);

				}

				/* Randomly select some small fraction of P(t) for "mutation" */
			case 1:
				modStep = GENERATOR.nextInt(smallFractionOfThePopulation)
						+ (oneThirdPopulation / 2);

				for (int i = 0; i < SIZE_OF_POPULATION; i++) {
					if (i % modStep == 0)
						population.set(i, mutate(population.get(i)));
				}
			}

			/* Evaluate population */
			populationGoodness = evaluatePopulation();

			/* We found a solution */
			if (populationGoodness < 0) {
				System.out.println("We've found a solution:");
				System.out.println(printBooleanArray(population.get(Math
						.abs(populationGoodness))));
				break;
			}

			/* We didn't find a solution */
			else if (t == NUMBER_OF_GENERATIONS - 1) {
				System.out.println("No solution found.");
				break;
			}

			else
				t++;

		}
	}

	/**
	 * parseInput will organize the input into the instance array.
	 * 
	 * @param args
	 *            The command line arguments
	 */
	static Boolean[][] parseInput(String s) {

		String[] cases = s.split("\\)");

		NUM_CLAUSES = cases.length;

		Boolean[][] returnList = generateMatrixFullOfFalse(NUM_CLAUSES,
				SIZE_OF_MATRIX);

		if (cases.length < 1)
			throw new IllegalArgumentException("Malformed problem instance!");

		int tmpPosition;

		for (int i = 0; i < cases.length; i++) {
			if (cases[i].charAt(0) != '(')
				throw new IllegalArgumentException(
						"Malformed problem instance!");
			cases[i] = cases[i].substring(1);

			String[] clause = cases[i].split(",");

			for (int j = 0; j < clause.length; j++) {

				// we're not dealing with a negative
				if (clause[j].charAt(0) != '~') {
					tmpPosition = Integer.parseInt(clause[j]);
					returnList[i][tmpPosition] = true;
				}

				// negative
				else {
					tmpPosition = Integer.parseInt(clause[j].substring(1));
					returnList[i][tmpPosition] = false;
				}
				/* Set instance accordingly */

				/* Compute total number of variables */
				if (tmpPosition > numVariables)
					numVariables = tmpPosition;
			}
		}

		return returnList;
	}

	static ArrayList<Boolean[]> initializePopulation(int size) {

		ArrayList<Boolean[]> population = new ArrayList<Boolean[]>();

		for (int i = 0; i < SIZE_OF_POPULATION; i++) {
			population
					.add((Boolean[]) generateRandomBooleanArray(numVariables));
		}

		return population;
	}

	/**
	 * mutate() randomly mutates a Boolean[] object. That is, it randomly goes
	 * through and switches the values.
	 * 
	 * @param a
	 * @return A mutated Boolean[] object.
	 */
	static Boolean[] mutate(Boolean[] a) {
		Boolean[] tmp = a.clone();
		for (int i = 0; i < tmp.length; i++) {
			// We'll mutate about half the time
			if (GENERATOR.nextBoolean()) {
				tmp[i] = GENERATOR.nextBoolean();
			}
		}
		return tmp;
	}

	/**
	 * A helper method to evaluate the "goodness" of each guess. It returns an
	 * integer that represents how many clauses were satisfied. If the value
	 * returned is equal to the size of instance, then you have a solution.
	 * 
	 * @param a
	 *            The guess to evaluate against the instance
	 * @return The "goodness" value
	 */

	static int evaluate(Boolean[] a, Boolean[][] key) {

		int goodness = 0;

		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (key[i][j] == a[j]) {
					goodness++;
					break;
				}
			}
		}

		return goodness;
	}

	/**
	 * A helper method to evaluate the goodness of the _entire_ population.
	 * 
	 * @return
	 */
	static int evaluatePopulation() {

		int totalPopulationGoodness = 0;
		int specificAttemptGoodness = 0;

		for (int i = 0; i < SIZE_OF_POPULATION; i++) {
			specificAttemptGoodness = evaluate(population.get(i), instance);

			/* This "citizen" fulfilled each clause */
			if (specificAttemptGoodness == NUM_CLAUSES) {
				// System.out.println("We've found a perfect citizen!");
				return -i;
			}

			else
				totalPopulationGoodness += specificAttemptGoodness;
		}

		return totalPopulationGoodness;
	}

	/**
	 * Performs a random crossover between two Boolean[] objects
	 * 
	 * @param a
	 * @param b
	 * @return Returns a Boolean[][] object of size 2
	 */
	static Boolean[][] crossover(Boolean[] a, Boolean[] b) {
		return crossover(a, b, GENERATOR.nextInt(a.length));
	}

	/**
	 * Performs a crossover between two Boolean[] objects at a specific seed
	 * value
	 * 
	 * @param a
	 * @param b
	 * @return Returns a Boolean[][] object of size 2
	 */
	static Boolean[][] crossover(Boolean[] a, Boolean[] b, int seed) {

		Boolean[] aClone = a.clone();
		Boolean[] bClone = b.clone();

		Boolean[][] returnArray = new Boolean[2][a.length];
		returnArray[0] = a;
		returnArray[1] = b;

		for (int i = seed; i < a.length; i++) {
			returnArray[0][i] = bClone[i];
			returnArray[1][i] = aClone[i];
		}

		return returnArray;
	}

	/**
	 * A helper method to just return a Boolean matrix fillled with false.
	 * 
	 * @return
	 */
	static Boolean[][] fillMatrixWithFalse() {
		Boolean[][] tmp = new Boolean[SIZE_OF_MATRIX][SIZE_OF_MATRIX];

		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				tmp[i][j] = false;
			}
		}

		return tmp;
	}

	/**
	 * A helper method to just return a Boolean matrix fillled with false.
	 * 
	 * @return
	 */
	static Boolean[][] generateMatrixFullOfFalse(int size) {
		Boolean[][] tmp = new Boolean[size][size];

		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				tmp[i][j] = false;
			}
		}

		return tmp;
	}

	/**
	 * A helper method to just return a Boolean matrix fillled with false.
	 * 
	 * @return
	 */
	static Boolean[][] generateMatrixFullOfFalse(int rows, int columns) {
		Boolean[][] tmp = new Boolean[rows][columns];

		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				tmp[i][j] = false;
			}
		}

		return tmp;
	}

	/**
	 * Self-explanatory I hope
	 * 
	 * @param size
	 * @return A randomized Boolean array of input size
	 */
	static Boolean[] generateRandomBooleanArray(int size) {

		Boolean[] returnArray = new Boolean[size];

		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = GENERATOR.nextBoolean();
		}
		return returnArray;
	}

	/**
	 * ... because equals() just doesn't do the trick
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static Boolean testEquality(Boolean[][] a, Boolean[][] b) {

		if (a.length != b.length)
			return false;

		// Not the best loops, but they'll do the trick
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != b[i][j])
					return false;
			}
		}

		return true;

	}

	/**
	 * ... because equals() just doesn't do the trick
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static Boolean testEquality(Boolean[] a, Boolean[] b) {

		if (a.length != b.length)
			return false;

		// Not the best loops, but they'll do the trick
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}

		return true;
	}

	/**
	 * Slick little method that works the way Boolean[].toString() should work
	 * 
	 * @param a
	 *            A Boolean[] object
	 * @return A String representation of a
	 */
	static String printBooleanArray(Boolean[] a) {

		String s = "";

		s += "[";

		for (int i = 0; i < a.length - 1; i++) {
			s += a[i] + ", ";
		}

		s += a[a.length - 1];

		s += "]";
		return s;
	}
}