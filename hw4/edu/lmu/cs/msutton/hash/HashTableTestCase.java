package edu.lmu.cs.msutton.hash;

import org.junit.Test;

public class HashTableTestCase {

	HashTable table = new HashTable(7);
	
	Country austria = new Country("Austria", "German", 32378, 8139299);
	Country france = new Country("France", "French", 211200, 58978172);
	Country germany = new Country("Germany", "German", 137800, 82087361);
	Country greece = new Country("Greece", "Greek", 50900, 10707135);
	Country italy = new Country("Italy", "Italian", 116300, 56735130);
	Country portugal = new Country("Portugal", "Portuguese", 35672, 9918040);
	Country sweden = new Country("Sweden", "Swedish", 173732, 8911396);

	@Test
	public void testHashTable(){
		table.put("AT", austria);
		table.put("AT", france);
		table.put("AT", germany);
		table.put("AT", greece);
		table.put("AT", italy);
		table.put("AT", portugal);
		table.put("AT", sweden);
		//TODO fix country codes
		//TODO write tests
	}
}
