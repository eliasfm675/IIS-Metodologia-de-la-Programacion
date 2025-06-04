package uo.mp.lab03.dome.model;

import java.io.PrintStream;
import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;

public class Dvd extends Item {
    private String director;
    private int playingTime;

    /**
     * Creates a new Dvd with default values for gotIt and comment
     * 
     * @param theTitle    String for title
     * @param theDirector String for director
     * @param time        integer for time
     */
    public Dvd(String theTitle, String theDirector, int time, boolean gotIt, String comment, double basePrice) {
	super(theTitle, gotIt, comment, basePrice);
	setDirector(theDirector);
	setPlayingTime(time);
    }

    /**
     * @return the playingTime
     */
    int getPlayingTime() {
	return playingTime;
    }

    /**
     * @param playingTime the playingTime to set
     */
    private void setPlayingTime(int playingTime) {
	ArgumentChecks.isTrue(playingTime > 0, "Invalid playing time");
	this.playingTime = playingTime;
    }

    /**
     * 
     * @param arg String with the new director
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setDirector(String arg) {
	ArgumentChecks.isNotNull(arg);
	ArgumentChecks.isNotEmpty(arg);
	ArgumentChecks.isNotBlank(arg);
	this.director = arg;
    }

    /**
     * @return the director of the dvd
     */
    public String getDirector() {
	return this.director;
    }

    /**
     * @param out a PrintStream to flush output
     */
    public void print(PrintStream out) {
	out.println("DVD: " + getPlayingTime() + " mins)");
	out.println("Director: " + getDirector());
	super.print2(out);
    }

    public String getResponsable() {
	return getDirector();

    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(director);
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!super.equals(obj)) {
	    return false;
	}
	if (!(obj instanceof Dvd)) {
	    return false;
	}
	Dvd other = (Dvd) obj;
	return Objects.equals(director, other.director) && super.equals(obj);
    }

    @Override
    public double getPrice() {
	return super.getBasePrice();
    }

}
