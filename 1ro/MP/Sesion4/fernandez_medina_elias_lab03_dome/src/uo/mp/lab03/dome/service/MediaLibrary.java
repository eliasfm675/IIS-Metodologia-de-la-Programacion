/**
 * 
 */
package uo.mp.lab03.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.lab03.dome.model.Borrowables;
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
	this.items = new ArrayList<Item>();
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
	ArgumentChecks.isNotNull(out);
	out.println("List of the Items in the library");
	for (Item theItem : items) {
	    theItem.print(out);
	}
    }

    public void list2(PrintStream out) {
	ArgumentChecks.isNotNull(out);
	out.println("Otra forma de imprimir");
	for (Item theItem : items) {
	    theItem.print2(out);
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
	    sb.append(String.format("%s, ", item.getResponsable()));
	}
	if (sb.length() > 0) {
	    sb.delete(sb.length() - 2, sb.length());
	}
	return sb.toString();
    }

    /**
     * Busca un item en la lista igual al recibido coo parámetro
     * Dos cds son iguales si lo son título y artista
     * Dos dvd son iguales si los son título director
     * Dos videogames son iguales si lo son título y autor
     * 
     * @param item a buscar
     * @return el item encontrado o null si no lo ha encontrado o recibe null
     */
    public Item search(Item itemToSearch) {
	for (Item itemInList : items) {
	    if (itemInList.equals(itemToSearch)) { // se puede hacer con
						   // itemToSeach.getResponasable.equals(itemToSearch.getResponsable)
						   // ...
		return itemInList;
	    }
	}
	return null;
    }

    /**
     * Méotodo que devuelve un String con los items prestables
     */
    public String borrowablesToString() {
	StringBuilder sb = new StringBuilder();
	for (Item theItem : items) {
	    if (theItem instanceof Borrowables && theItem.getOwn()) {
		sb.append(theItem.getTitle() + " ");
	    }
	}
	if (sb.length() > 0) {
	    sb.deleteCharAt(sb.length() - 1);
	}
	return sb.toString();
    }

    /**
     * Método que devuelve un String con los items disponibles que ahora se pueden prestar
     */
    public String getAvailables() {
	StringBuilder sb = new StringBuilder();
	for (Item theItem : items) {
	    if (theItem instanceof Borrowables && ((Borrowables) theItem).isAvailable()) {
		sb.append(theItem.getTitle() + " ");
	    }
	}
	if (sb.length() > 0) {
	    sb.deleteCharAt(sb.length() - 1);
	}

	return sb.toString();

    }

    /**
     * Método que presta un item
     */
    public Item borrow(Borrowables item) {
	ArgumentChecks.isNotNull(item);
	for (Item theItem : items) {
	    if (theItem instanceof Borrowables && (((Borrowables) theItem).isAvailable())
		    && ((Borrowables) theItem).equals(item)) {
		((Borrowables) theItem).borrow();
		return theItem;
	    }
	}
	return null;
    }

    /**
     * Método que devuelve un ítem que recibe por parámetro
     */
    public Item giveBack(Borrowables item) {
	ArgumentChecks.isNotNull(item);
	for (Item theItem : items) {
	    if (theItem instanceof Borrowables && !(((Borrowables) theItem).isAvailable())
		    && ((Borrowables) theItem).equals(item)) {
		((Borrowables) theItem).giveBack();
		return theItem;
	    }
	}
	return null;
    }

    /**
     * Método que devuelve un valor de tipo double con
     * la suma de los precios finales de los items contenidos en MediaLibrary
     */
    public double getTotalPrice() {
	double totalPrice = 0.0;
	for (Item theItem : items) {
	    totalPrice += theItem.getPrice();
	}
	return totalPrice;
    }

    /**
     * Método que devuelve una cadena con el código de todos los items de
     * MediaLibrary separados por un guión
     */
    public String generateCodes() {
	StringBuilder sb = new StringBuilder();
	int index = 0;
	for (Item theItem : items) {
	    sb.append(theItem.getTitle()
		.substring(0, 3) + index + "-");
	    index++;
	}
	sb.deleteCharAt(-1);
	return sb.toString();
    }

}
