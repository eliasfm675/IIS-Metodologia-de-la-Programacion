package uo.mp.lab03.dome.model;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

/**
 *
 */
public class Cd {

    private String title;
    private String artist;
    private int numberOfTracks;
    private int playingTime;
    private boolean gotIt; // I have my own copy of the Cd
    private String comment;

    /**
     * Creates a new Cd with default values for gotIt and comment
     * 
     * @param theTitle  String for title
     * @param theArtist String for artist
     * @param tracks    integer for tracks
     * @param time      integer for time
     */
    public Cd(String theTitle, String theArtist, int tracks, int time) {
	setTitle(theTitle);
	setArtist(theArtist);
	setNumberOfTracks(tracks);

	setPlayingTime(time);
	setOwn(false);
	setComment("No comment");
    }

    /**
     * 
     * @param arg String with the new title
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setTitle(String arg) {
	ArgumentChecks.isNotNull(arg);
	ArgumentChecks.isNotEmpty(arg);
	ArgumentChecks.isNotBlank(arg);

	this.title = arg;
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
     * 
     * @param arg integer with the playing time in the CD
     * @throws IllegalArgumentException if the argument is is lower or equal zero
     */
    private void setPlayingTime(int arg) {
	ArgumentChecks.isTrue(arg > 0, "Invalid playing time");
	this.playingTime = arg;
    }

    /**
     * 
     * @param boolean true means we own a copy; otherwise, false
     */
    public void setOwn(boolean ownIt) {
	gotIt = ownIt;
    }

    /**
     * 
     * @param arg String with a new comment to the element
     * @implNote If the argument is null or does not contain meaningful characters (other than blanks, new lines, etc)
     *           previous comment stays as it is
     */
    public void setComment(String arg) {
	if (arg != null && !arg.isBlank()) {
	    this.comment = arg;
	}
    }

    /**
     * @return the comment (if any) or default
     */
    public String getComment() {
	return comment;
    }

    /**
     * @return true if we own a copy; false otherwise
     */
    public boolean getOwn() {
	return gotIt;
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
     * @return title
     */
    public String getTitle() {
	return this.title;
    }

    /**
     * @return playing time
     */
    public int getPlayingTime() {
	return this.playingTime;
    }

    /**
     * @param out a PrintStream to flush output
     */
    public void print(PrintStream out) {
	out.println("CD: " + getTitle() + " (" + getPlayingTime() + " mins)");
	out.println("Artist: " + getArtist());
	out.println("Tracks: " + getNumberOfTracks());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
    }
}