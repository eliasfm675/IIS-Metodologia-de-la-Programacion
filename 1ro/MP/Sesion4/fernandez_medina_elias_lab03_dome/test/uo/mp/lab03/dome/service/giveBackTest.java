package uo.mp.lab03.dome.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Book;
import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Item;

class giveBackTest {
    private ArrayList<Item> items;
    private MediaLibrary ml;
    private Book book1;
    private Cd cd1;

    @BeforeEach
    public void setUp() {
	this.ml = new MediaLibrary(items);
	this.book1 = new Book("The Great Gatsby", true, "Classic novel", 25.99, "Scribner", "978-0743273565", true);
	this.cd1 = new Cd("Thriller", "Michael Jackson", 9, 42, true, "Best-selling album of all time", 15.99, true);
	ml.add(book1);
	ml.add(cd1);
    }

    /**
     * Clase de pruebas del método giveBack().Casos de uso:
     * 1.-Se devuelve un libro
     * 2.-Se devuelve un cd
     * 3.-Se devuelve null
     */
    /**
     * GIVEN a valid book
     * WHEN using the method
     * THEN the method returns the book
     */
    @Test
    public void giveBackBook() {
	assertEquals(book1, ml.giveBack(book1));
	assertFalse(book1.isBorrowed());

    }

    /**
     * GIVEN a valid cd
     * WHEN using the method
     * THEN the method returns the cd
     */
    @Test
    public void giveBackCd() {
	assertEquals(cd1, ml.giveBack(cd1));
	assertFalse(cd1.isBorrowed());

    }

    /**
     * GIVEN null
     * WHEN using the method
     * THEN the method throws an exception
     */
    @Test
    public void giveBackNull() {
	try {
	    ml.giveBack(null);
	    fail("should fail");
	} catch (IllegalArgumentException i) {
	    assertEquals("null is an invalid value for the argument.", i.getMessage());
	}
    }
}
