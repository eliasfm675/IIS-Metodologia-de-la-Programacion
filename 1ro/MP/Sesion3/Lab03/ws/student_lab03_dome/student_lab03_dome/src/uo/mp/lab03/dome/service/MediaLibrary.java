/**
 * 
 */
package uo.mp.lab03.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.model.Item;
import uo.mp.util.check.ArgumentChecks;

/**
 * @author uo299673
 *
 */
public class MediaLibrary {
    private ArrayList<Item> items;

    public MediaLibrary() {
	setItems(items);
    }

    public MediaLibrary(ArrayList<Item> items) {
	setItems(items);
    }

    /**
     * @param items the items to set
     */
    private void setItems(ArrayList<Item> items) {
	this.items = items;
    }

    /**
     * Añade un item a la lista. No puede ser null; si lo es salta IllegalArgumentException
     * 
     * @param item
     * @throws IllegalArgumentException si el item es null
     */
    public void add(Item item) {
	ArgumentChecks.isNotNull(item);
	items.add(item);
    }

    protected ArrayList<Item> getItems() {
	return new ArrayList<>(items); // se crea una copia de items para evitar acoplamiento
    }

    /**
     * @return número de items con propietario
     */
    public int numberOfItemsOwned() {
	int numberOfItems = 0;
	for (Item theItem : items) {
	    if (theItem.getOwn()) {
		numberOfItems++;
	    }
	}
	return numberOfItems;
    }

    /**
     * Imprime en el objeto out todos los elementos de la lista de items
     */
    public void list(PrintStream out) {
	for (Item theItem : items) {
	    theItem.print(out);
	}
    }

    /**
     * Método que Busca en la librería el ítem recibido como parámetro (el mismo
     * ítem, no otro ítem con el mismo contenido). Devuelve el ítem encontrado en la librería, si lo
     * encuentra, o bien null si no lo ha encontrado o el parámetro es null.
     */
    public Item searchItem(Item theItem) {
	for (Item item : items) {
	    if (item.equals(theItem)) {
		return item;
	    }
	}
	return null;
    }

    /**
     * Devuelve un String (posiblemente vacío si no hay datos) que
     * contenga las personas responsables de todos los ítems existentes, separadas por comas. En el
     * caso de los CDs, el responsable es el artista. En el caso de los DVDs el responsable es el director.
     */
    public String getResponsables() {
	StringBuilder sb = new StringBuilder();
	for (Item item : items) {
	    if (item instanceof Cd) {
		Cd cd = (Cd) item;
		sb.append(String.format("%s, ", cd.getArtist()));
	    } else if (item instanceof Dvd) {
		Dvd dvd = (Dvd) item;
		sb.append(String.format("%s, ", dvd.getDirector()));
	    }
	}
	if (sb.length() > 0) {
	    sb.delete(sb.length() - 2, sb.length());
	}
	return sb.toString();
    }
}
