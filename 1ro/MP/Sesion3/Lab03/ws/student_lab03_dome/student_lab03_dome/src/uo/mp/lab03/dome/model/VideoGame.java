package uo.mp.lab03.dome.model;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

public class VideoGame extends Item {
    private String author;
    private int numberOfPlayers;
    private Platform platform;

    public VideoGame(String theTitle, int time, String author, boolean gotIt, String comment, int numberOfPlayers,
	    Platform platform) {
	super(theTitle, gotIt, comment);
	setAuthor(author);
	setNumberOfPlayers(numberOfPlayers);
	setPlatform(platform);
    }

    /**
     * @return the author
     */
    private String getAuthor() {
	return author;
    }

    /**
     * @param author the author to set
     */
    private void setAuthor(String author) {
	ArgumentChecks.isNotNull(author);
	ArgumentChecks.isNotEmpty(author);
	ArgumentChecks.isNotBlank(author);
	this.author = author;
    }

    /**
     * @return the numberOfPlayers
     */
    private int getNumberOfPlayers() {
	return numberOfPlayers;
    }

    /**
     * @param numberOfPlayers the numberOfPlayers to set
     */
    private void setNumberOfPlayers(int numberOfPlayers) {
	ArgumentChecks.isTrue(numberOfPlayers > 0, "Number of players must be over 0");

	this.numberOfPlayers = numberOfPlayers;
    }

    /**
     * @return the platform
     */
    private Platform getPlatform() {
	return platform;
    }

    /**
     * @param platform the platform to set
     */
    private void setPlatform(Platform platform) {
	this.platform = platform;
    }

    /**
     * Método que imprima sus caracterísicas por consola
     */
    public void print(PrintStream out) {
	out.println("Videogame: " + getTitle() + "(" + getPlatform() + ")");
	out.println("Author: " + getAuthor());
	out.println("Number of players: " + getNumberOfPlayers());
	super.print(out);

    }
}
