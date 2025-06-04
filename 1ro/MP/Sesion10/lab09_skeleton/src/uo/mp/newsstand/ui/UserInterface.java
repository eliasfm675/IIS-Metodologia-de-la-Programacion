package uo.mp.newsstand.ui;

import java.util.List;

import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.exception.NewsstandException;
import uo.mp.newsstand.service.Newsstand;
import uo.mp.util.console.Console;
import uo.mp.util.log.Logger;

/**
 * It is in charge of interacting with the user:
 * 	- Shows the menu of options
 *  - Process the option chosen by the user
 *  	- For that it asks the user the necessary data to fulfill the request
 *  	- Shows the result of the request
 *  - In case of error shows an explaining message
 *  
 *  Note: This is the unique class allowed to show information to the user
 *  @version 2023
 */
public class UserInterface {
	private static final int EXIT = 0;

	private Menu menu = new Menu();
	private Newsstand newsStand = new Newsstand();
	
	public void show()  {
		int option = EXIT;
		do {
			try {
			menu.show();
			option = Console.readInt("Option  ");		
			processOption(option);
			}catch(RuntimeException e) {
				handleSystemError(e);
				return; //para hacer que pare
			}catch(NewsstandException e) {
				handleUserError(e);
			}
		} while (option != EXIT);
	}
private void handleUserError(NewsstandException e) {
		Console.println("Se ha producido un error: " + e.getMessage());
		Console.println("Por favor, elija de nuevo la opción del menú");
		
		
	}
/**
 * Manejador de excepciones runtime(de programacion)
 * @param e
 */
	private void handleSystemError(RuntimeException e) {
		Console.println("Se ha producido un error irrecuperable, por favor contacte con el administrador");
		Logger.log(e.getMessage());
		Logger.log(e);
		
	}

	private void processOption(int option) throws NewsstandException {
		switch( option ) {
			case EXIT: return;
			case 1: loadFile(); break;
			case 2: showPublications(); break;				
			case 3: addPublication(); break;
			case 4: removePublication(); break;				
			case 5: createOrders(); break; 				
			case 6: saveOrdersToFile(); break;
			case 7: importFromZip(); break;
			case 8: exportToZip(); break;
		}
	}
	private void loadFile() throws NewsstandException {
			String fileName = Console.readString("File name?");
			newsStand.loadFile( fileName );
			
			
	}
/**
 * Caso en que queremos que vuelva a preguntar únicamente el nombre hasta que lo ponga bien
 * @throws NewsstandException
 */
	private void loadFile2() throws NewsstandException {
		boolean wrongName = true;
		do {
			String fileName = Console.readString("File name?");
			try{
				newsStand.loadFile( fileName );
				wrongName = false;
			}catch(NewsstandException e) {
				Console.println("Se ha producido un error: " + e.getMessage());
				Console.println("Por favor, elija de nuevo la opción del menú");
				wrongName = true;
			}
		} while(wrongName);
		
	}
	
	private void addPublication() throws NewsstandException {
		Publication p = new PublicationForm().askForPublication();
			newsStand.addPublication( p );
		
	}

	private void removePublication() throws NewsstandException { // conviene poner el throws para asi poner el try catch solo en el show
		String name = Console.readString("publication name?");
		newsStand.removePublication( name );
	}
	
	private void showPublications() {
		List<Publication> publications = newsStand.getPublications();
		listPublications( publications );
	}

	private void createOrders() throws NewsstandException {
		newsStand.createOrders();
	}

	private void listPublications(List<Publication> publications) {
		Console.print("\nList of publications\n");
		Console.print("------------------\n");
		for (Publication p: publications) {
			Console.print(String.format("%s\n", p ) );
		}
	
		Console.print("------------------\n");
   }	
	
	private void saveOrdersToFile() {
		String fileName = Console.readString("output file name?");
		newsStand.saveOrdersToFile( fileName );
	}
	
	private void importFromZip() {
		String fileName = Console.readString("input zip file name?");
		newsStand.importPublicationsFromZipFile( fileName );
	}
	
	private void exportToZip() {
		String fileName = Console.readString("output file name?");
		newsStand.exportPublicationsToZipFile( fileName );
	}

}
