package edu.lmu.cs.ksutton.hw4;

import java.util.ArrayList;

public class DiceFactory {

	public static ArrayList<Dice> buildListofDice(int numDice){
		ArrayList<Dice> d = new ArrayList<Dice>();
		
		for (int i = 0; i < numDice; i++){
			d.add(new Dice());
		}
		
		return d;
	}
	
	
}
