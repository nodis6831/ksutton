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
	 * position is inside the maze.
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
	}

	/**
	 * A simple cell value. A cell can be open (meaning a rat has never visited
	 * it), a wall, part of the rat's current path, or "tried" (meaning the rat
	 * found it to be part of a dead end.
	 */
	public enum Cell {
		OPEN('.'), WALL('#'), TRIED('x'), PATH('o'), RAT('r');

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

			// TODO
			// 1 - put the rat at the current position
			// 2 - notify the listener
			// 3 - Check if we reached the end
			// 4 - Move to an adjacent open cell, leaving a "breadcrumb"
			// but if you can't move anywhere, backtrack. But if
			// there's nowhere to backtrack to, you know you are
			// stuck.
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
