package uo.mp.lab05.picture;

import java.io.PrintStream;

import uo.mp.lab05.drawing.interfacerepository.Drawable;

public class Picture implements Drawable {
	private int x;
	private int y;
	private int width;
	private int height;
	private String filename;
	public Picture(int x, int y, int width, int height, String filename) {
		setFilename(filename);
		setHeight(height);
		setWidth(width);
		setX(x);
		setY(y);
	}
		
	@Override
	public void draw(PrintStream out) {
		String output = String.format("Drawing &s : (%d, %d) - width: &d - height: &d", 
				getFilename(), 
				getX(), 
				getY(), 
				getWidth(), 
				getHeight());
		out.println(output);
		
		}
		
	
	/**
	 * @return the x
	 */
	private int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	private void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	private int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	private void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the width
	 */
	private int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	private void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	private int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	private void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the filename
	 */
	private String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	private void setFilename(String filename) {
		this.filename = filename;
	}

}
