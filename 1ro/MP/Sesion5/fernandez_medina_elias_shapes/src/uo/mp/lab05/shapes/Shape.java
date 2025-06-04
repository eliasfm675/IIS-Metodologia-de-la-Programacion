package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.lab05.drawing.interfacerepository.Drawable;
import uo.mp.util.check.ArgumentChecks;

public abstract class Shape implements Drawable {

	protected int x;
	protected int y;
	protected Colour colour;

	public Shape(int x, int y, Colour colour) {
		
		super();
		ArgumentChecks.isTrue(x >= 0, "Illegal argument, must be x >= 0");
		ArgumentChecks.isTrue(y >= 0,  "Illegal argument, must be y >= 0");
		ArgumentChecks.isTrue(colour != null, "Illegal argument, must be colour != null");
		this.x = x;
		this.y = y;
		this.colour = colour;
		
	}

	protected int getX() {
		return x;
	}

	protected int getY() {
		return y;
	}

	protected Colour getColour() {
		return colour;
	}
	public abstract void draw(PrintStream out);
}