package uo.mp.lab03.dome.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.model.VideoGame;

//tienees que cambiar los test
//tienees que cambiar los test
//tienees que cambiar los test
//tienees que cambiar los test
//tienees que cambiar los test
//tienees que cambiar los test
//tienees que cambiar los test
//tienees que cambiar los test
//tienees que cambiar los test
//tienees que cambiar los test
//tienees que cambiar los test
//tienees que cambiar los test
class SearchItemTest {

    private boolean gotIt;
    private String theComment;
    private MediaLibrary ml;
    private Cd cd;
    private Dvd dvd;
    private VideoGame vg;

    @BeforeEach
    public void setUp() {
	gotIt = false;
	theComment = "No comment";
	ml = new MediaLibrary();
	cd = new Cd("Hola", "Adios", 0, 0, gotIt, theComment, 0, gotIt);
	dvd = new Dvd("Hola", "Adios", 0, gotIt, theComment, 0);
	vg = new VideoGame(theComment, 0, theComment, gotIt, theComment, 0, null, 0);
    }

    /**
     * Clase de pruebas del método searchItem(). Casos de uso:
     * 1.-Encuentra el item
     * 2.-No lo encuentra --> devuelve null
     * 3.-EL item es null
     * 4.-Varios items distintos pero con el mismo contenido
     */
    /**
     * GIVEN valid arguments and an empty arrayList
     * WHEN adding an item to a list
     * THEN returns said item when calling this method
     */
    @Test
    public void searchItemFound() {
	Cd cd = new Cd("Hola", "Adios", 0, 0, gotIt, theComment, 0, gotIt);
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

    /*
     * GIVEN Library with some items cd, dvd and videogame
     * WHEN an item is seacrhed for with the same data as one
     */
    @Test
    public void itemSameDataExist() {
	Cd otherCd = new Cd("Hola", "Adios", 0, 0, gotIt, theComment, 0, gotIt);
	ml.add(otherCd);
	assertEquals(cd, ml.search(cd));
	assertEquals(otherCd, ml.search(otherCd));
	assertEquals(dvd, ml.search(dvd));
	assertEquals(vg, ml.search(vg));
    }
}
