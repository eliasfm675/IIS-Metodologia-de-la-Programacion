package uo.mp.newsstand.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import uo.mp.newsstand.domain.Order;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.exception.NewsstandException;
import uo.mp.newsstand.exception.NotYetImplementedException;
import uo.mp.newsstand.service.parsers.PublicationParser;
import uo.mp.newsstand.service.serializers.OrderSerializer;
import uo.mp.newsstand.service.serializers.PublicationSerializer;
import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.file.FileUtil;
import uo.mp.util.file.ZipFileUtil;
import uo.mp.util.log.Logger;

/**
 * Core class of the project. Manages the newsstand. 
 * Holds publications, together with the stock info, and generates orders to replenish the stock
 * 
 * @version 2023
 *
 */
public class Newsstand {

	private static final int MIN_FILE_LENGTH = 5;
	private List<Publication> publications = new LinkedList<>();
	private List<Order> orders = new LinkedList<>();

	/**
	 * Loads from a plain text file information about publications.
	 * 
	 * @param inFileName, the name of the file
	 * @return the number of publications loaded from file 
	 * @throws NewsstandException 
	 * @throws InvalidNameException, if the file name is invalid
	 */
	public void loadFile(String inFileName) throws NewsstandException { //esto cae fijo en el examen dijo marian
		ArgumentChecks.isNotNull(inFileName);
		checkFileName(inFileName);
		List<String> lines = new FileUtil().readLines(inFileName);
		List<Publication> fileProducts = new PublicationParser().parse(lines);
		addPublications(fileProducts);
	}

	private void checkFileName(String inFileName) throws NewsstandException {
		if(inFileName.length() < MIN_FILE_LENGTH) {
			throw new NewsstandException("Nombre del fichero menor de " + MIN_FILE_LENGTH);
		}
		
	}

	/**
	 * Add all the publications in the list passed as argument.
	 * Publications with names already contained in the actual list of publications 
	 * (no sensitive) are not accepted. 
	 * If a publication to be added has a name already in the list of 
	 * publications, the publication to be added will be ignored and a message sent to log.
	 * 
	 * @param newProducts, the list with the new publications
	 */
	private void addPublications(List<Publication> newProducts) {
		for (Publication p : newProducts) {
			try {
				addPublication(p);
			} catch (NewsstandException e) {
				Logger.log(e.getMessage() + ": " + p.getName());
				Logger.log(e);
			}
		}
	}

	/**
	 * Add the publication if it is name is not already registered
	 * @param p, the product to be added
	 * @throws NewsstandException if the product's name is repeated
	 * @throws IllegalArgumentException if the argument is null
	 */
	public void addPublication(Publication p) throws NewsstandException {
		if (searchByName(p.getName()) != -1) {
			throw new NewsstandException("Publicación repetida"); //esta excepcion se recoge en el metodo de arriba, si el metodo falla salta la excepcion  se salta a la siguiente iteracion
		}
		publications.add(p);
	}

	/**
	 * Removes the product matching the name passed as argument
	 * 
	 * @param name 					of the publication to be removed
	 * @throws NewsstandException	if the product does not exist
	 */
	public void removePublication(String name) throws NewsstandException {
		int pos = searchByName(name);
		if(pos == -1) {
			throw new NewsstandException("Publicación inexistente");
		}
		publications.remove(pos);
	}

	private int searchByName(String name) {
		for (int i = 0; i < publications.size(); i++) {
			Publication p = publications.get(i);
			if ((p.getName().equals(name)) /* compare both names */ )
				return i;
		}
		return -1;
	}

	/**
	 * Makes a shallow copy of the list of publications, so as not to break the encapsulation
	 * A copy constructor needed in our lists when replacing java lists for our lists
	 * @return a copy of the internal list of publications
	 */
	public List<Publication> getPublications() {
		List<Publication> copy = new ArrayList<>();
		for(Publication p : publications) {
			copy.add(p);
		}
		return copy;
	}

	/**
	 * Generates a list of orders. One for every product with stock under limits
	 * @throws NewsstandException 
	 */
	public void createOrders() throws NewsstandException {
		orders.clear();
		for(Publication p : publications) {
			Order order;
			try {
				order = p.generateOrders();
				orders.add(order);
			}catch(NewsstandException e){
				Logger.log(e.getMessage());
			}
		}
	}

	/**
	 * Makes a shallow copy of the list of orders, so as not to break the encapsulation
	 * A copy constructor needed in our lists when replacing java lists for our lists
	 * @return a copy of the internal list of orders
	 */
	public List<Order> getOrders() {
		List<Order> copy = new ArrayList<>();
		for(Order or : orders) {
			copy.add(or);
		}
		return copy;
	}

	/**
	 * Save all orders to a file with the given format
	 * 
	 * @param fileName
	 * @throws InvalidNameException in case
	 * 		- the file name is invalid
	 */
	public void saveOrdersToFile(String fileName) {
		OrderSerializer serializer = new OrderSerializer();
		List<String> lines = serializer.serialize(orders);
		new FileUtil().writeLines(fileName, lines);
	}

	/**
	 * Imports all the publications from the zip file, overwriting the 
	 * previous ones.
	 * 
	 * @param fileName
	 * @throws InvalidNameException, if the file name is invalid
	 */
	public void importPublicationsFromZipFile(String fileName) {
		throw new NotYetImplementedException();
	}

	/**
	 * Saves all the publications to a zip file. The file produced can be read
	 * by the method @see importPublicationsFromZipFile
	 * 
	 * @param fileName
	 * @throws InvalidNameException, if the file name is invalid
	 */
	public void exportPublicationsToZipFile(String fileName) {
		PublicationSerializer serializer = new PublicationSerializer();
		List<String> lines = serializer.serialize(publications);
		new ZipFileUtil().writeLines(fileName, lines);
	}

}
