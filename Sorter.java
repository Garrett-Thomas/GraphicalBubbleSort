package extras.sorter;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


import javax.swing.JPanel;
import javax.swing.Timer;

public class Sorter extends JPanel implements KeyListener, ActionListener {

	private static final long serialVersionUID = -6362051141542562727L;

	final private static int width = 1000;
	final private static int height = 1000;

	static ArrayList<Box> boxHolder;
	public Stack<Integer> hundredInts = new Stack<Integer>();

	Timer time;

	Sorter() {

		time = new Timer(10000, this);
		time.start();
		boxHolder = new ArrayList<Box>();
		createBoxes();
	}

	public static void createBoxes() {

		for (int i = 0; i < width / 10; i++) {

			boxHolder.add(new Box((i * 10), height - 20 - (i * 10), width / 100, i * 10, i));

		}
	}

	public void randomizeBoxes() {

		for (int i = 0; i < boxHolder.size(); i++) {

			hundredInts.add(i); // Creates a stack full of numbers from 0-99

		}
		for (int i = 0; i < boxHolder.size(); i++) {

			int tempInt = hundredInts.remove(new Random().nextInt(hundredInts.size()));
			Box tempBox = boxHolder.set(i, boxHolder.get(tempInt));
			boxHolder.set(tempInt, tempBox); // Shifts the location of the box in the array rather than giving it a
												// different x value.
		}

	}

	public void sortBoxes() {

		for (int j = 0; j < boxHolder.size() - 1; j++) {

			if (boxHolder.get(j).index > boxHolder.get(j + 1).index) { // Simple implementation of the BubbleSort
																		// algorithm. Compares two adjacent box's
																		// heights and swaps their location if the
																		// second box is taller than the first.

				Box tempBox = boxHolder.get(j);
				boxHolder.set(j, boxHolder.get(j + 1));
				boxHolder.set(j + 1, tempBox);

			}

		}

	}

	@Override
	public void paintComponent(Graphics g) {
	
		for (int i = 0; i < boxHolder.size(); i++) {
			
			//System.out.println(boxHolder.get(i).x + " Y:" + boxHolder.get(i).y); Useful for debugging
			boxHolder.get(i).draw(g, i);

		}

	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_R) {
			
			randomizeBoxes();
			repaint();
		
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S) {
			
			sortBoxes();
			repaint();
		
		}
	

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
