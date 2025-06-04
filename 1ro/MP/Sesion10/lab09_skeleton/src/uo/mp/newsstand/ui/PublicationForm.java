package uo.mp.newsstand.ui;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.exception.NewsstandException;
import uo.mp.newsstand.domain.Magazine.Frequency;
import uo.mp.util.console.Console;

/**
 * Asks the user all the data for a new publication.
 * 
 * @version 2023
 */
public class PublicationForm {

	private static final int MAX_NAME_LENGTH = 25;
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 50;

	/**
	 * Ask the user to type information for a new publication
	 * 
	 * @return The new Publication object created. It will be of any of the child
	 *         types of Publication.
	 * @throws NewsstandException 
	 */
	public Publication askForPublication() throws NewsstandException {
		String type = Console.readString("Type of publication? (n | m)");
		type = type.toLowerCase();
		switch (type) {
		case "n":
			return askForNewsPaper();
		case "m":
			return askForMagazine();
		default:
			return null;
		}

	}

	private Publication askForMagazine() throws NewsstandException {
		String name = readString();
		int stock = readInt("stocks?"); //hacer en casa stock entre 0 y 50 (hechos)
		int sales = readInt("sales?"); //hacer en casa sales entre 0 y 50
		Frequency f = readFrequency();

		return new Magazine(name, stock, sales, f); // Frequency.valueOf(frequency.toUpperCase()));
	}
	private String readString() throws NewsstandException { // en caso de nombre incorrecto te pone el menu de nuevo
		String name = Console.readString("name?");
		checkName(name);
		return name;
	}
	private void checkName(String name) throws NewsstandException {
	  if(name.length() > MAX_NAME_LENGTH) {
		  throw new NewsstandException("Nombre mayor de " + MAX_NAME_LENGTH);
	  }
	
}

	private String readString2() { // en caso de nombre incorrecto intenta de nuevo
		String name;
		boolean wrongName = true;
		do{
			name = Console.readString("name?");
			if(name.length() > MAX_NAME_LENGTH) {
				wrongName = true;
				Console.println("Longitud del nombre debe ser menor de 25");
			}else {
				wrongName = false;
			}
		}while(wrongName);
		return name;
		
	}
	private int readInt(String name) {
		int number;
		boolean wrongInt = true;
		do {
			number = Console.readInt(name);
			if(!(number >=MIN_NUMBER && number<=MAX_NUMBER)) {
				wrongInt = true;
				Console.println("El número debe estar entre  y 50");
			}else {
				wrongInt = false;
			}
		}while(wrongInt);
		return number;
	}
	private Frequency readFrequency() {
		String frequency = Console.readString("frequency?");
		while (!Frequency.getNames().contains(frequency.toLowerCase()))
			frequency = Console.readString("frequency?");
		return Frequency.valueOf(frequency.toUpperCase());
	}

	private Publication askForNewsPaper() {
		String name = Console.readString("name?");
		int stock = Console.readInt("stock?");
		int sales = Console.readInt("sales?");

		return new Newspaper(name, stock, sales);
	}

}
