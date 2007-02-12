/**
 * 
 */
package edu.lmu.cs.ksutton.cmsi282.hw2;


class IntHeap {

	private int[] a; // the heap

	private int size;

	public IntHeap(int s) {

		a = new int[s+1];
		size = 0;

	}

	
	public int size(){
		return size;
	}
	
	
	/**
	 * Adds an int to the heap and readjusts the heap
	 * 
	 * @param x
	 *            The int to add to the heap
	 */
	public void add(int x) {

		a[size+1] = x;

		size++;
		reheap_up();

	}

	/**
	 * 
	 * @return The top-most element of the heap
	 */
	public int remove() {

		int top = a[1];

		/*if (a[size] > a[size]) {
			a[1] = a[size];
		}

		else
			// a[2] < a[3]
			a[size] = a[size];*/
		
		a[1] = a[size];
		a[size] = 0;

		size--;
		//reheap_up();
		reheap_down();

		return top;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//return Arrays.toString(a);
		String toReturn = "";
		
		toReturn = toReturn + "[";
		for (int i = 1; i < a.length - 1; i++){
			toReturn = toReturn + a[i] + ", ";
		}
		toReturn = toReturn + a[a.length-1] + "]";
		
		return toReturn;
	}

	/**
	 * Recursive method that reorganizes the heap, should be called every
	 * time an object is added or removed from the heap.
	 */
	private void reheap_down() {

		int i = 1;

		while (2 * i + 1 < size) {
			int child = 2 * i;

			// since we're pushing a number down, we want to do the swapping
			// with the smallest number
			if (child < size && a[child] < a[child + 1])
				child++;

			// the number is as far down as it needs to go
			if (a[i] > a[child])
				break;

			else {
				swapInts(child, i);// we've found the smallest numbered
									// child
				// and we're swapping
				i = child;// now we move on to see if we need to go any
							// lower
			}
		}

	}

	/**
	 * Recursive method that reorganizes the heap, should be called every
	 * time an object is added or removed from the heap.
	 */
	private void reheap_up() {

		int i = size;

		while (i > 1) {
			if (parent(i) < a[i]) {
				swapInts(i, indexOfParent(i));
			}

			i = indexOfParent(i);
		}

	}

	/**
	 * 
	 * @param i
	 *            The index of the item in question
	 * @return The index of the parent
	 */
	private int indexOfParent(int i) {
		return i / 2;
	}

	/**
	 * 
	 * @param i
	 *            The index of the child
	 * @return The parent's data
	 */
	private int parent(int i) {
		return a[indexOfParent(i)];
	}

	/**
	 * Swaps the values at the two indeces of the array
	 * 
	 * @param i
	 * @param j
	 */
	private void swapInts(int i, int j) {

		int tmp = a[i];
		//System.out.println(tmp + " " + a[i] + " " + a[j]);
		a[i] = a[j];
		a[j] = tmp;
		//System.out.println(a[i] + " " + a[j]);

	}

}