/**
 * 
 */
package uo.mp.lab03.dome.ui;

import uo.mp.lab03.dome.model.Book;
import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.service.MediaLibrary;

/**
 * @author uo299673
 *
 */
public class MediaPlayer {

    public void run() {
	MediaLibrary ml = new MediaLibrary();
	Book book1 = new Book("The Great Gatsby", true, "Classic novel", 25.99, "Scribner", "978-0743273565", false);
	Book book2 = new Book("To Kill a Mockingbird", true, "American classic", 20.50,
		"Harper Perennial Modern Classics", "978-0061120084", true);
	Book book3 = new Book("1984", false, "Dystopian novel", 18.99, "Signet Classic", "978-0451524935", true);
	Book book4 = new Book("Pride and Prejudice", false, "Romantic classic", 22.00,
		"CreateSpace Independent Publishing Platform", "978-1503290563", false);
	Book book5 = new Book("The Catcher in the Rye", false, "Coming-of-age novel", 19.95, "Back Bay Books",
		"978-0316769488", true);
	Cd cd1 = new Cd("Thriller", "Michael Jackson", 9, 42, true, "Best-selling album of all time", 15.99, false);
	Cd cd2 = new Cd("Back in Black", "AC/DC", 10, 41, true, "Legendary rock album", 14.50, true);
	Cd cd3 = new Cd("Abbey Road", "The Beatles", 17, 47, true, "Iconic album", 19.99, false);
	ml.add(book1);
	ml.add(book2);
	ml.add(book3);
	ml.add(book4);
	ml.add(book5);
	ml.add(cd1);
	ml.add(cd2);
	ml.add(cd3);

	ml.borrow(book1);
	ml.borrow(cd1);
	System.out.println("Se pueden prestar --> " + ml.borrowablesToString());
	System.out.println("Están disponibles --> " + ml.getAvailables());
    }
}
