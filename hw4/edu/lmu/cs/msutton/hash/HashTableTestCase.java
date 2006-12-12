package edu.lmu.cs.msutton.hash;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTestCase {

	HashTable table = new HashTable(7);

	Country austria = new Country("Austria", "German", 32378, 8139299);

	Country france = new Country("France", "French", 211200, 58978172);

	Country germany = new Country("Germany", "German", 137800, 82087361);

	Country greece = new Country("Greece", "Greek", 50900, 10707135);

	Country italy = new Country("Italy", "Italian", 116300, 56735130);

	Country portugal = new Country("Portugal", "Portuguese", 35672, 9918040);

	Country sweden = new Country("Sweden", "Swedish", 173732, 8911396);

	Country bogus = new Country("KellySuttonLand", "Suttish", 4, 1);

	Country deutchland = new Country("Deutchland", "German", 29434, 3047486);

	@Test
	public void testHashTable() {
		table.put("AT", austria);
		table.put("FR", france);
		table.put("DE", germany);
		table.put("GR", greece);
		table.put("IT", italy);
		table.put("PT", portugal);
		table.put("SE", sweden);

		assertEquals(table.size(), 7);
		assertEquals(table.remove("FR"), france);
		assertEquals(table.size(), 6);
		assertEquals(table.get("GR"), greece);
		table.put("KS", bogus);
		assertEquals(table.size(), 7);
		assertEquals(table.get("AT"), austria);
		assertEquals(table.get("GR"), greece);
		assertEquals(table.get("DE"), germany);
		assertEquals(table.get("IT"), italy);
		assertEquals(table.get("PT"), portugal);
		assertEquals(table.get("SE"), sweden);
		assertEquals(table.get("KS"), bogus);
		table.put("DE", deutchland);
		assertEquals(table.get("DE"), deutchland);

	}
}
