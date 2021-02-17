package extras.sorter;

import java.awt.Color;
import java.awt.Graphics;

public class Box {
	
	int x;
	int y;
	int width;
	int height;
	int index;
	

	public Box(int x, int y, int w, int height, int index) {
		
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = height;
		this.index = index;
		
	}

	public void draw(Graphics g, int arrayLoc) {
	
		g.setColor(new Color(arrayLoc, x/(y+x), 2)); //creates the location off of the box's location in the array rather than x value. Makes randomizing easier.
		g.fillRect((10 * (arrayLoc + 1)) - 10, y + 10, width, height);

	}
}
