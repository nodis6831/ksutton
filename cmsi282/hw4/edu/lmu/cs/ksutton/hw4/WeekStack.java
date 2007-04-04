package edu.lmu.cs.ksutton.hw4;

import java.util.Stack;

/**
 * For the Kirkman Schoolgirl problem. This holds DayStacks.
 * @author Kelly Sutton
 */
public class WeekStack extends Stack<DayStack>{

	/* (non-Javadoc)
	 * @see java.util.Vector#toString()
	 */
	@Override
	public synchronized String toString() {
	
		String toReturn = "";
		while (this.size() >= 1) {
			toReturn += "Day " + Math.abs((this.size() - 8)) + "\n";

			DayStack currentDay = this.pop();
			while (currentDay.size() >= 1) {	
				RowStack row = currentDay.pop();
				toReturn += row + "\n";
			}
		}
		return toReturn;
	}
}
