/**
 * 
 */
package uo.mp.lab03.dome.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.model.Item;

/**
 * @author uo299673
 *
 */
class MediaLibraryAddTest {

    /**
     * Clase de pruebas del método add().Casos de add:
     * 1.-Añadir un CD a lista vacía
     * 2.-Añadir un DVD a una lista vacía
     * 3.-Añadir un CD a una lista con varios items
     * 4.-Añadir un DVD a una lista con varios items
     * 5.-Añadir null --> salta excepción
     */
    private MediaLibrary ml;
    private Cd aCD;
    private Dvd aDVD;
    private String theTitle, theArtist, theDirector;
    private int theTime, theTracks;
    private String theComment;
    private ArrayList<Item> items;

    @BeforeEach
    void setUp() throws Exception {
	theTitle = "Come Together";
	theArtist = "Beatles";
	theTime = 70;
	theTracks = 4;
	theComment = "No comment";
	aCD = new Cd(theTitle, theArtist, theTracks, theTime, false, theComment, 0, false);
	theTitle = "La guerra de las Galaxias";
	theDirector = "George Lucas";
	theTime = 125;
	aDVD = new Dvd(theTitle, theDirector, theTime, false, theComment, 0);
	items = new ArrayList<Item>();
	ml = new MediaLibrary(items);

    }

    /*
     * GIVEN una MediaLibrary que contiene una lista vacía
     * WHEN se añade un CD
     * THEN se añade el CD a la lista de MediaLibrary
     */
    @Test
    void cdEmptyList() {
	ml.add(aCD);
	ArrayList<Item> result = ml.getItems();
	assertTrue(result.contains(aCD)); // metodo de los arraylist que dice si el objeto esta contenido en la lista
	assertEquals(1, result.size());

    }

    /*
     * GIVEN una MediaLibrary que contiene una lista vacía
     * WHEN se añade un DVD
     * THEN se añade el DVD a la lista de MediaLibrary
     */
    @Test
    void dvdEmptyList() {
	ml.add(aDVD);
	ArrayList<Item> result = ml.getItems();
	assertTrue(result.contains(aDVD)); // metodo de los arraylist que dice si el objeto esta contenido en la lista
	assertEquals(1, result.size());

    }

}
