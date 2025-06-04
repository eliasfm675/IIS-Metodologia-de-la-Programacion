package uo.mp.lab03.dome.model;

import java.io.PrintStream;
import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;

public class Book extends Item implements Borrowables {
    private String publisher;
    private String ISBN;
    private boolean borrowed;

    public Book(String theTitle, boolean gotIt, String comment, double basePrice, String publisher, String ISBN,
	    boolean Borrowed) {
	super(theTitle, gotIt, comment, basePrice);
	setPublisher(publisher);
	setISBN(ISBN);
	setBorrowed(Borrowed);
    }

    /**
     * @return the publisher
     */
    private String getPublisher() {
	return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    private void setPublisher(String publisher) {
	ArgumentChecks.isNotNull(publisher);
	ArgumentChecks.isNotBlank(publisher);
	ArgumentChecks.isNotEmpty(publisher);
	this.publisher = publisher;
    }

    /**
     * @return the iSBN
     */
    private String getISBN() {
	return ISBN;
    }

    /**
     * @param iSBN the iSBN to set
     */
    private void setISBN(String iSBN) {
	ArgumentChecks.isNotNull(publisher);
	ArgumentChecks.isNotBlank(publisher);
	ArgumentChecks.isNotEmpty(publisher);
	ISBN = iSBN;
    }

    @Override
    public void print(PrintStream out) {
	ArgumentChecks.isNotNull(out);
	out.println("Book: " + "(" + getPublisher() + " publisher)");
	out.println("ISBN: " + getISBN());
	super.print2(out);

    }

    @Override
    public String getResponsable() {
	return publisher;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(ISBN);
	return result;
    }

    /**
     * Método equal redefinido para comparar ISBN y título
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!super.equals(obj)) {
	    return false;
	}
	if (!(obj instanceof Book)) {
	    return false;
	}
	Book other = (Book) obj;
	return Objects.equals(ISBN, other.ISBN) && Objects.equals(getTitle(), other.getTitle());
    }

    @Override
    public double getPrice() {
	return getBasePrice() * 1.04;
    }

    /**
     * Método que presta el libro
     */
    @Override
    public void borrow() {
	if (isAvailable()) {
	    setBorrowed(true);
	}

    }

    /**
     * Método que devuelve el libro
     */
    @Override
    public void giveBack() {
	if (isBorrowed()) {
	    setBorrowed(false);
	}

    }

    /**
     * Método que indica si el libro está disponible
     */
    @Override
    public boolean isAvailable() {
	return !isBorrowed() && getOwn();
    }

    public boolean isBorrowed() {
	return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
	this.borrowed = borrowed;
    }

}
