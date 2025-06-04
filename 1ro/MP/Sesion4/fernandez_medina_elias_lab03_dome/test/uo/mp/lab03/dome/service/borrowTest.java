package uo.mp.lab03.dome.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Book;
import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Item;

class borrowTest {
    private ArrayList<Item> items;
    private MediaLibrary ml;
    private Book book1;
    private Cd cd1;

    @BeforeEach
    public void setUp() {
	this.ml = new MediaLibrary(items);
	this.book1 = new Book("The Great Gatsby", true, "Classic novel", 25.99, "Scribner", "978-0743273565", false);
	this.cd1 = new Cd("Thriller", "Michael Jackson", 9, 42, true, "Best-selling album of all time", 15.99, false);
	ml.add(book1);
	ml.add(cd1);
    }

    /**
     * Clase de pruebas del método borrow().Casos de uso:
     * 1.-Se presta un libro
     * 2.-Se presta un cd
     * 3.-Se presta un item que no se tiene
     * 4.-Se presta un item que ya está prestado
     * 5.-Se presta un item null
     */
    /**
     * GIVEN a valid book
     * WHEN borrowing it
     * THEN the method returns the book
     */
    @Test
    public void borrowBook() {
	assertEquals(book1, ml.borrow(book1));
	assertTrue(book1.isBorrowed());
    }

    /**
     * GIVEN a valid cd
     * WHEN borrowing it
     * THEN the method returns the cd
     */
    @Test
    public void borrowCd() {
	assertEquals(cd1, ml.borrow(cd1));
	assertTrue(cd1.isBorrowed());
    }

    /**
     * GIVEN an invalid item
     * WHEN borrowing it
     * THEN the method returns null
     */
    @Test
    public void borrowNotOwnedItem() {
	Book book2 = new Book("The Catcher in the Rye", false, "Coming-of-age novel", 19.95, "Back Bay Books",
		"978-0316769488", false);
	assertNull(ml.borrow(book2));

    }

    /**
     * GIVEN a valid item
     * WHEN borrowing it
     * THEN the method returns null because it was already borrowed
     */
    @Test
    public void borrowAlreadyBorrowedItem() {
	Book book2 = new Book("The Catcher in the Rye", true, "Coming-of-age novel", 19.95, "Back Bay Books",
		"978-0316769488", true);
	assertNull(ml.borrow(book2));

    }

    /**
     * GIVEN a null
     * WHEN borrowing it
     * THEN the method returns null
     */
    @Test
    public void borrowNotBorrowable() {
	try {
	    ml.borrow(null);
	    fail("should fail");
	} catch (IllegalArgumentException i) {
	    assertEquals("null is an invalid value for the argument.", i.getMessage());
	}

    }

}
