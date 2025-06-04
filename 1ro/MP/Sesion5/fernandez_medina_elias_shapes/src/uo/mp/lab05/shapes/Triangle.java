package uo.mp.lab05.shapes;

import java.io.PrintStream;

public class Triangle extends Shape{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	public Triangle(int x, int y, int x1, int y1, int x2, int y2, Colour colour) {
		super(x, y, colour);
		setX1(x1);
		setX2(x2);
		setY1(y1);
		setY2(y2);

	}
	
	/**
	 * @return the x1
	 */
	private int getX1() {
		return x1;
	}
	/**
	 * @param x1 the x1 to set
	 */
	private void setX1(int x1) {
		this.x1 = x1;
	}
	/**
	 * @return the y1
	 */
	private int getY1() {
		return y1;
	}
	/**
	 * @param y1 the y1 to set
	 */
	private void setY1(int y1) {
		this.y1 = y1;
	}
	/**
	 * @return the x2
	 */
	private int getX2() {
		return x2;
	}
	/**
	 * @param x2 the x2 to set
	 */
	private void setX2(int x2) {
		this.x2 = x2;
	}
	/**
	 * @return the y2
	 */
	private int getY2() {
		return y2;
	}
	/**
	 * @param y2 the y2 to set
	 */
	private void setY2(int y2) {
		this.y2 = y2;
	}
	@Override
	public void draw(PrintStream out) {
		String output = String.format("Drawing a %s Triangle: (%d, %d) - 1st Position: (%d, %d) - 2nd Position: (%d, %d)", 
				getColour(), 
				getX(), 
				getY(), 
				getX1(), 
				getY1(),
				getX2(),
				getY2());
		out.println(output);
		
		}
	}
	
