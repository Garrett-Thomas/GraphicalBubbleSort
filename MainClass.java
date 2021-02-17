package extras.sorter;

import javax.swing.JFrame;

public class MainClass { //MainClass that creates all the objects
	private JFrame frame;
	private Sorter inputPanel;

	final private static int width = 1000;
	final private static int height = 1000;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		MainClass mC = new MainClass();
		
	}

	MainClass() {
		
		frame = new JFrame("Bubble Sort");
		inputPanel = new Sorter();
		setup();
	}

	public void setup() {
		
		frame.add(inputPanel);
		frame.addKeyListener(inputPanel);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
