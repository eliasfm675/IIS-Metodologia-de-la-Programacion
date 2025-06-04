package uo.mp.lab03.dome.model;

import java.io.PrintStream;
import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;

public abstract class Item {

    private String title;
    private boolean gotIt;
    protected String comment;
    private double basePrice;

    /**
     * @param gotIt the gotIt to set
     */
    protected void setGotIt(boolean gotIt) {
	this.gotIt = gotIt;
    }

    /**
     * @return the basePrice
     */
    protected double getBasePrice() {

	return basePrice;
    }

    /**
     * @param basePrice the basePrice to set
     */
    private void setBasePrice(double basePrice) {
	ArgumentChecks.isTrue(basePrice <= 1000 && basePrice > 0, "Base price not valid");
	this.basePrice = basePrice;
    }

    public Item(String theTitle, boolean gotIt, String comment, double basePrice) {
	setTitle(theTitle);
	setOwn(gotIt);
	setComment(comment);
	setBasePrice(basePrice);
    }

    /**
     * 
     * @param arg String with the new title
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    protected void setTitle(String arg) {
	ArgumentChecks.isNotNull(arg);
	ArgumentChecks.isNotEmpty(arg);
	ArgumentChecks.isNotBlank(arg);

	this.title = arg;
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
	ArgumentChecks.isNotNull(arg);
	ArgumentChecks.isNotEmpty(arg);
	ArgumentChecks.isNotBlank(arg);
	this.comment = arg;

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
     * @return title
     */
    public String getTitle() {
	return this.title;
    }

    public abstract void print(PrintStream out);

    public void print2(PrintStream out) {
	ArgumentChecks.isNotNull(out);
	out.println(getTitle());

	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + comment);
    }

    public abstract String getResponsable();

    @Override
    public int hashCode() {
	return Objects.hash(title);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof Item)) {
	    return false;
	}
	Item other = (Item) obj;
	return Objects.equals(title, other.title);
    }

    public abstract double getPrice();
}