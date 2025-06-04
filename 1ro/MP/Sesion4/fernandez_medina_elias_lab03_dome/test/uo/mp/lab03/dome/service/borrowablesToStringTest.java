package uo.mp.lab03.dome.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Book;
import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Item;
import uo.mp.lab03.dome.model.Platform;
import uo.mp.lab03.dome.model.VideoGame;

class borrowablesToStringTest {

    private ArrayList<Item> items;
    private MediaLibrary ml;
    private Book book1;
    private Cd cd1;
    private VideoGame vg;

    @BeforeEach
    public void setUp() {
	this.ml = new MediaLibrary(items);
	this.book1 = new Book("The Great Gatsby", true, "Classic novel", 25.99, "Scribner", "978-0743273565", false);
	this.cd1 = new Cd("Thriller", "Michael Jackson", 9, 42, true, "Best-selling album of all time", 15.99, false);
	vg = new VideoGame("Halo Infinite", 120, "Microsoft", true, "Awesome multiplayer experience", 4, Platform.XBOX,
		49.99);
    }

    /**
     * Clase de pruebas del método borrowablesToString(). Casos de uso:
     * 1.-Devuelve el String con cada Borrowable de la lista
     * 2.-Devuelve vacío porque no se añadió nada
     */
    /**
     * GIVEN many items
     * WHEN calling the method
     * THEN the method returns toString()
     */
    @Test
    public void getBorrowablesNotEmpty() {
	ml.add(book1);
	ml.add(cd1);
	ml.add(vg);
	assertEquals("The Great Gatsby Thriller", ml.borrowablesToString());
    }

    /**
     * GIVEN many items
     * WHEN calling the method
     * THEN the method returns toString()
     */
    @Test
    public void getBorrowablesEmpty() {
	assertEquals("", ml.borrowablesToString());
    }
}
