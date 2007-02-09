package edu.lmu.cs.ksutton.cmsi282.hw2;

import org.junit.Test;


public class IntegerHeapSortTestCase {

	
	
	@Test
	public void testHeapMethods(){
		
		IntHeap heap1 = new IntHeap(5);
		
		heap1.add(1);
		heap1.add(2);
		heap1.add(3);
		heap1.add(4);
		heap1.add(5);
		
		System.out.println(heap1.toString());
		
	}
	
	
	
}
