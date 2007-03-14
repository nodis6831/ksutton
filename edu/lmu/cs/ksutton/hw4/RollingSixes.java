package edu.lmu.cs.ksutton.hw4;

import java.util.ArrayList;

public class RollingSixes {

	private static ArrayList<Dice> six = DiceFactory.buildListofDice(6);
	
	private static ArrayList<Dice> twelve = DiceFactory.buildListofDice(12);;
	
	public static void main(String[]args){
		
		long numRolls;
		
		try{
			numRolls = Integer.parseInt(args[0]);
		}
		catch (Exception e){
			throw new IllegalArgumentException("You must input how many times you wish to roll the dice");
		}
		
		System.out.println("The ratio of the number of times one six was rolled out of six dice is " + rollSixDice(numRolls) + " out of " + numRolls + " rolls");
		System.out.println("The ratio of the number of times two sixes were rolled out of twelve dice is " + rollTwelveDice(numRolls) + " out of " + numRolls + " rolls");
	}
	
	
	public static double rollSixDice(long rolls){
		
		long hit = 0;
		int[] tmpRolls = { 0, 0, 0, 0, 0, 0 };
		
		for (long i = 0; i < rolls; i++){
			
			//Roll the dice
			for (int j = 0; j < six.size(); j++){
				tmpRolls[j] = six.get(j).roll();
			}
			
			//Test exactly one six
			if(testForNumSixes(tmpRolls, 1)){
				hit++;
			}
			
		}
		
		return (double) hit / rolls;	
	}
	
	public static double rollTwelveDice(long rolls){
	
		long hit = 0;
		int[] tmpRolls = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0 ,0 };
		
		for (long i = 0; i < rolls; i++){
			
			//Roll the dice
			for (int j = 0; j < twelve.size(); j++){
				tmpRolls[j] = twelve.get(j).roll();
			}
			
			//Test exactly two sixes
			if(testForNumSixes(tmpRolls, 2)){
				hit++;
			}
			
		}
		
		return (double) hit / rolls;	
	}
	
	private static boolean testForNumSixes(int[] a, int n){
		
		int sixes = 0;
		for (int i = 0; i < a.length; i++){
			if (a[i] == 6)
				sixes++;
		}
		
		return sixes == n;
	}
	
}

