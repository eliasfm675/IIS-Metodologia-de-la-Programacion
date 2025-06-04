package uo.mp.lab03.dome.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.model.Item;

class getResponsablesTest {
    private ArrayList<Item> items;
    private MediaLibrary ml;

    @BeforeEach
    public void setUp() {
	items = new ArrayList<>();
	ml = new MediaLibrary(items);
    }

    /**
     * Clases de prueba del método getResponsables().Casos de uso
     * 1.-Devuelve el nombre de un artista --> Cd
     * 2.-Devuelve el nombre de un director --> Dvd
     * 3.-Devuelve una cadena vacía
     * 4.-Devuelve varios --> Cd y dvd
     */
    /**
     * GIVEN a cd whose artist is not blank
     * WHEN the method is called
     * THEN returns said artist
     */
    @Test
    public void getResponsablesCd() {
	Cd cd = new Cd("Titulo", "Bicho", 2, 3, true, "No comments");
	ml.add(cd);
	assertEquals("Bicho", ml.getResponsables());
    }

    /**
     * GIVEN a dvd whose artist is not blank
     * WHEN the method is called
     * THEN returns said artist
     */
    @Test
    public void getResponsablesDvd() {
	Dvd dvd = new Dvd("Titulo", "Bicho", 2, true, "No comments");
	ml.add(dvd);
	assertEquals("Bicho", ml.getResponsables());
    }

    /**
     * GIVEN a dvd whose artist is blank
     * WHEN the method is called
     * THEN returns blank
     */
    @Test
    public void getResponsablesBlank() {
	Dvd dvd = new Dvd("Titulo", "    ", 2, true, "No comments");
	ml.add(dvd);
	assertEquals("    ", ml.getResponsables());
    }

    /**
     * GIVEN a cd and a dvd whose artist is not blank
     * WHEN the method is called
     * THEN returns said artists
     */
    @Test
    public void getResponsablesBoth() {
	Dvd dvd = new Dvd("Titulo", "Cristiano", 2, true, "No comments");
	Cd cd = new Cd("Titulo", "Bicho", 2, 3, true, "No comments");
	ml.add(dvd);
	ml.add(cd);
	assertEquals("Cristiano, Bicho", ml.getResponsables());
    }
}
