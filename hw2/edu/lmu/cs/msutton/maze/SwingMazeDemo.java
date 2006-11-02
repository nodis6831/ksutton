package edu.lmu.cs.msutton.maze;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Really cheap application that "animates" a rat moving through a maze. It
 * simply keeps refreshing a monospaced font rendering of the maze's toString()
 * output.
 */
public class SwingMazeDemo {

	public static class MazePanel extends JPanel implements Maze.MazeListener {
		private JTextArea display = new JTextArea(40, 40);

		public MazePanel() {
			setLayout(new BorderLayout());
			display.setFont(new Font("Monospaced", Font.PLAIN, 32));
			add(new JScrollPane(display), BorderLayout.CENTER);
		}

		/**
		 * Waits a second then refreshes the maze in the textarea.
		 */
		public void mazeChanged(Maze maze) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ignored) {
			}
			display.setText(maze.toString());
		}
	}

	/**
	 * Throwaway main: it only animates a single maze!
	 */
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Maze");
		MazePanel panel = new MazePanel();
		frame.setSize(800, 600);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		Maze maze = new Maze();
		maze.setCells("000110000 110100010 010000010 000100000");
		boolean success = maze.solve(6, 0, 1, 3, panel);
		frame.setTitle(success ? "Made it! " : "Stuck");
	}
}