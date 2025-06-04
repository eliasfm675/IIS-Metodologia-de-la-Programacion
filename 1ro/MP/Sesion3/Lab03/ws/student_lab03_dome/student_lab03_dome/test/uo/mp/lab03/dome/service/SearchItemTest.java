package uo.mp.lab03.dome.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Item;

class SearchItemTest {
    private String theTitle;
    private boolean gotIt;
    private String theComment;
    private Item anItem;
    private ArrayList<Item> items;
    private MediaLibrary ml;

    @BeforeEach
    public void setUp() {
	theTitle = "Come Together";
	gotIt = false;
	theComment = "No comment";
	anItem = new Item(theTitle, gotIt, theComment);
	items = new ArrayList<>();
	ml = new MediaLibrary(items);
    }

    /**
     * Clase de pruebas del método searchItem(). Casos de uso:
     * 1.-Encuentra el item
     * 2.-No lo encuentra --> devuelve null
     * 3.-EL item es null
     */
    /**
     * GIVEN valid arguments and an empty arrayList
     * WHEN adding an item to a list
     * THEN returns said item when calling this method
     */
    @Test
    public void searchItemFound() {
	Cd cd = (Cd) anItem;
	ml.add(cd);
	assertEquals(cd, ml.searchItem(cd));
    }

    /**
     * GIVEN valid arguments and an empty arrayList
     * WHEN not adding an item to a list
     * THEN returns null
     */
    @Test
    public void searchItemNotFound() {
	Cd cd = (Cd) anItem;

	assertNull(ml.searchItem(cd));
    }

    /**
     * GIVEN null
     * WHEN searching for null
     * THEN returns null
     */
    @Test
    public void searchItemNull() {
	assertNull(ml.searchItem(null));
    }
}
