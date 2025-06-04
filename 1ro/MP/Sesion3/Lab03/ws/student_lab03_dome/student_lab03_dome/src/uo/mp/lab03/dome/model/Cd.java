package uo.mp.lab03.dome.model;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

/**
 *
 */
public class Cd extends Item {
    private String artist;
    private int numberOfTracks;
    private int playingTime;

    /**
     * Creates a new Cd with default values for gotIt and comment
     * 
     * @param theTitle  String for title
     * @param theArtist String for artist
     * @param tracks    integer for tracks
     * @param time      integer for time
     */
    public Cd(String theTitle, String theArtist, int tracks, int time, boolean gotIt, String comment) {
	super(theTitle, gotIt, comment);
	setArtist(theArtist);
	setNumberOfTracks(tracks);
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
	out.println("CD: " + getTitle() + " (" + getPlayingTime() + " mins)");
	out.println("Artist: " + getArtist());
	out.println("Tracks: " + getNumberOfTracks());
	super.print(out);
    }
}