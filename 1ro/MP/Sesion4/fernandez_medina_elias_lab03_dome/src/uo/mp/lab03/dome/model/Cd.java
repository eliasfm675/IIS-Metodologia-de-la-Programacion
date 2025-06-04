package uo.mp.lab03.dome.model;

import java.io.PrintStream;
import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;

/**
 *
 */
public class Cd extends Item implements Borrowables {
    private String artist;
    private int numberOfTracks;
    private int playingTime;
    private boolean borrowed;

    /**
     * Creates a new Cd with default values for gotIt and comment
     * 
     * @param theTitle  String for title
     * @param theArtist String for artist
     * @param tracks    integer for tracks
     * @param time      integer for time
     */
    public Cd(String theTitle, String theArtist, int tracks, int time, boolean gotIt, String comment, double basePrice,
	    boolean borrowed) {
	super(theTitle, gotIt, comment, basePrice);
	setArtist(theArtist);
	setNumberOfTracks(tracks);
	setPlayingTime(time);
	setBorrowed(borrowed);
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
     * @param arg String with the new artist name
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setArtist(String arg) {
	ArgumentChecks.isNotNull(arg);
	ArgumentChecks.isNotEmpty(arg);
	ArgumentChecks.isNotBlank(arg);

	this.artist = arg;
    }

    /**
     * 
     * @param arg integer with the number of tracks in the CD
     * @throws IllegalArgumentException if the argument is is lower or equal zero
     */
    private void setNumberOfTracks(int arg) {
	ArgumentChecks.isTrue(arg > 0, "Invalid number of tracks");
	this.numberOfTracks = arg;
    }

    /**
     * @return artist's name
     */
    public String getArtist() {
	return this.artist;
    }

    /**
     * @return number of tracks
     */
    public int getNumberOfTracks() {
	return this.numberOfTracks;
    }

    /**
     * @param out a PrintStream to flush output
     */
    public void print(PrintStream out) {
	ArgumentChecks.isNotNull(out);
	out.println("CD: " + getTitle() + " (" + getPlayingTime() + " mins)");
	out.println("Artist: " + getArtist());
	out.println("Tracks: " + getNumberOfTracks());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + comment);
    }

    public void print2(PrintStream out) {
	ArgumentChecks.isNotNull(out);
	out.println("CD: " + " (" + getPlayingTime() + " mins)");
	out.println("Artist: " + getArtist());
	out.println("Tracks: " + getNumberOfTracks());
	super.print2(out);

    }

    public String getResponsable() {
	return getArtist();

    }

//    @Override
//    public boolean isLike(Item itemToSearch) {
//	if (!(itemToSearch instanceof Cd)) {
//	    return false;
//	}
//	Cd cd = (Cd) itemToSearch;
//	return this.getTitle()
//	    .equals(cd.getTitle())
//		&& this.getArtist()
//		    .equals(cd.getArtist());
//    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(artist);
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!super.equals(obj)) { // esto comprueba que el título sea igual en el super de modo que no se iene que poner
				  // el && en el return
	    return false;
	}
	if (!(obj instanceof Cd)) {
	    return false;
	}
	Cd other = (Cd) obj;
	return Objects.equals(artist, other.artist) && super.equals(obj);
    }

    @Override
    public double getPrice() {
	return super.getBasePrice() + 2;
    }

    public void setBorrowed(boolean borrowed) {
	this.borrowed = borrowed;
    }

    /**
     * Método que presta el cd
     */
    @Override
    public void borrow() {
	if (isAvailable()) {
	    setBorrowed(true);
	}
	/**
	 * Método que devuelve el cd
	 */
    }

    @Override
    public void giveBack() {
	if (isBorrowed()) {
	    setBorrowed(false);
	}
	/**
	 * Método que indica si el cd está prestado
	 */
    }

    public boolean isBorrowed() {
	return borrowed;
    }

    /**
     * Método que indica si el cd está disponible
     */
    @Override
    public boolean isAvailable() {
	return !isBorrowed() && getOwn();
    }

//    @Override // el override sobrescribe un método arriba que se quiera redefinir
//    public boolean equals(Object object) {
//	if (!(object instanceof Cd)) {
//	    return false;
//	}
//	Cd cd = (Cd) object;
//	return this.getTitle()
//	    .equals(cd.getTitle())
//		&& this.getArtist()
//		    .equals(cd.getArtist());
//
//    }
}