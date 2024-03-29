package edu.lmu.cs.msutton.maze;

import java.io.IOException;

import edu.lmu.cs.msutton.util.SimpleStack;
import edu.lmu.cs.msutton.util.Stack;

/**
 * A maze class based on the discussion in Section 5.4 of Hubbard and Huray's
 * Data Structures in Java.
 */
public class Maze {

	/**
	 * An (x,y) position. The method <code>legal()</code> returns whether the
	 * position is inside the maze. Positions are eithe rlegal or not legal.
	 */
	private class Location {
		int x;

		int y;

		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}

		boolean legal() {
			return x >= 0 && x < width && y >= 0 && y < height;
		}

		boolean isOpen() {
			return legal() && cells[y][x] == Cell.OPEN;
		}

		Location above() {
			return new Location(x, y - 1);
		}

		Location below() {
			return new Location(x, y + 1);
		}

		Location left() {
			return new Location(x - 1, y);
		}

		Location right() {
			return new Location(x + 1, y);
		}

		@Override
		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = PRIME * result + x;
			result = PRIME * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Location other = (Location) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	/**
	 * A simple cell value. A cell can be open (meaning a rat has never visited
	 * it), a wall, part of the rat's current path, or "tried" (meaning the rat
	 * found it to be part of a dead end.
	 */
	public enum Cell {
		OPEN('.'), WALL('#'), TRIED('x'), PATH('o'), RAT('r');
		// Display values are attached to the enum and the ability to display
		// the character

		private char display;

		private Cell(char display) {
			this.display = display;
		}

		public String toString() {
			return Character.toString(display);
		}
	}

	/**
	 * A listener interface for responding to maze changes.
	 */
	public interface MazeListener {
		void mazeChanged(Maze maze);
	}

	private Cell[][] cells;

	private int width;

	private int height;

	public void setCells(String description) throws IOException {
		String[] rows = description.trim().split("\\s+");
		height = rows.length;
		width = rows[0].length();
		cells = new Cell[height][width];
		System.out.println("Width = " + width);
		System.out.println("Height = " + height);
		for (int y = 0; y < height; y++) {
			String row = rows[y];
			if (!row.matches("[01]+")) {
				throw new IllegalArgumentException("Illegal characters in maze");
			}
			if (row.length() != width) {
				throw new IllegalArgumentException("Non-rectangular maze");
			}
			for (int x = 0; x < width; x++) {
				cells[y][x] = row.charAt(x) == '0' ? Cell.OPEN : Cell.WALL;
			}
		}
	}

	/**
	 * Moves a rat from (x1,y1) to (x2,y2), filling in the cells as it goes, and
	 * notifying a listener at each step. Returns true if the rat reached the
	 * end, or false if it is completely stuck.
	 */
	public boolean solve(int x1, int y1, int x2, int y2, MazeListener listener) {

		// Validate the parameters.
		Location start = new Location(x1, y1);
		if (!start.isOpen()) {
			throw new IllegalArgumentException("Bad start location");
		}
		Location end = new Location(x2, y2);
		if (!end.isOpen()) {
			throw new IllegalArgumentException("Bad end location");
		}
		if (listener == null) {
			throw new IllegalArgumentException("Listener cannot be null");
		}

		// Get ready
		Location current = start;
		Stack path = new SimpleStack();

		// Solution loop. At each step, place the rat and notify listener.
		while (true) {
			cells[current.y][current.x] = Cell.RAT;
			listener.mazeChanged(this);

			// Did we reach the desired end cell?
			if (current.x == x2 && current.y == y2) {
				return true;
			}

			// Move to an adacent open cell, leaving a breadcrumb. If we can't
			// move at all, backtrack. If there's nowhere to backtrack to, we're
			// totally stuck.
			if (current.above().isOpen()) {
				path.push(current);
				cells[current.y][current.x] = Cell.PATH;
				current = current.above();
			} else if (current.left().isOpen()) {
				path.push(current);
				cells[current.y][current.x] = Cell.PATH;
				current = current.left();
			} else if (current.below().isOpen()) {
				path.push(current);
				cells[current.y][current.x] = Cell.PATH;
				current = current.below();
			} else if (current.right().isOpen()) {
				path.push(current);
				cells[current.y][current.x] = Cell.PATH;
				current = current.right();
			} else if (path.size() == 0) {
				return false;
			} else {
				cells[current.y][current.x] = Cell.TRIED;
				current = (Location)path.peek();
				path.pop();
			}
		}
	}

	/**
	 * Returns a textual description of the maze, separating each row with a
	 * newline.
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer(height * width);
		for (Cell[] row : cells) {
			for (Cell cell : row) {
				buffer.append(cell);
			}
			buffer.append("\n");
		}
		return buffer.toString();
	}
}
