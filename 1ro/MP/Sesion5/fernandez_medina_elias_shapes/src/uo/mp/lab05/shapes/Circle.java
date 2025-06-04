/**
 * 
 */
package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

/**
 * @author uo299673
 *
 */
public class Circle extends Shape{

	private int radius;
	/**
	 * @param x
	 * @param y
	 * @param radius
	 * @param colour
	 */
	public Circle(int x, int y, int radius, Colour colour) {
		super(x,y,colour);
		ArgumentChecks.isTrue(radius>0 , "radius must be bigger than 0");
		setRadius(radius);
		
	}
	/**
	 * Imprime el círculo con este formato
	 * (0,0) - radius: 5 - Color: RED
	 */
	public void draw(PrintStream out) {
		String output = String.format("Drawing a %s Circle: (%d, %d) - radius: %d ", 
				getColour(), 
				getX(), 
				getY(), 
				getRadius());
		out.println(output);
	}
	private int getRadius() {
		return radius;
	}
	private void setRadius(int radius) {
		this.radius = radius;
	}
}

