package uo.mp.newsstand.service.parsers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Magazine.Frequency;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.exception.NotYetImplementedException;
import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.log.Logger;

public class PublicationParser {
private int lineNumber;
	/**
	 * Transforms a list of Strings in a list of instances of Publication.
	 * Any of the following are invalid lines in the input file: 
	 * 		- incorrect type of publication, 
	 * 		- wrong number of fields in a line, and 
	 * 		- incorrect data format in numeric fields.
	 * Invalid lines will not produce a Publication instance but will throw an InvalidLineFormatException instead.
	 * As a result of processing this exception, a message will be written to a log (use Log) 
	 * @param lines non-null list of strings, probably empty
	 * 		One by each publication
	 * 				type_of_publication \t name_of_publication \t sales \t stock \t frequency
	 * 
	 * @return a list of publications
	 */
	public List<Publication> parse(List<String> lines) {
		checkLines(lines);
		List<Publication> publications = new ArrayList<>();
		for(String line: lines) {
			lineNumber++;
			if(line.isBlank()) {
				continue; // si hay una línea en blanco me la salto
			}
			Publication publication;
			try {
				publication = parseLine(line);
				publications.add(publication);
			} catch (InvalidLineFormatException e) {
				Logger.log("Error en línea " + lineNumber + ": " + e.getMessage());
			}
		}
		return publications;
	}
private void checkLines(List<String> lines) {
		ArgumentChecks.isNotNull(lines);
		for(String line: lines) {
			ArgumentChecks.isNotNull(line);
		}
		
	}
/**
 * Método que decide si se parsea una revista o un periódico
 * @param line
 * @return
 */
	private Publication parseLine(String line) throws InvalidLineFormatException{
		String[] parts = line.split("\t");
		String type = parts[0];
		if(type.equals("newspaper")) {
			return parseNewsPaper(parts);
		}else if(type.equals("magazine")){
			return parseMagazine(parts);
		}else {
			throw new InvalidLineFormatException("Tipo desconocido");
		}
		
	}
/**
 * Método que parsea una línea con una revista
 * @param parts
 * @return
 * @throws InvalidLineFormatException 
 */
	private Publication parseMagazine(String[] parts) throws InvalidLineFormatException {
		checkParts(parts, 5);
		String name = parts[1];
		int stock = toInteger(parts[2]);
		int sales = toInteger(parts[3]);
		Frequency frequency = toFrequency(parts[4]);
		return new Magazine(name, stock, sales, frequency);
	}

	private Frequency toFrequency(String string) throws InvalidLineFormatException {
		try {
		return Frequency.valueOf(string);
		}catch(IllegalArgumentException e) {
			throw new InvalidLineFormatException("Frecuencia desconocida");
		}
	}
/**
 * Método que parsea una línea con un newspaper
 * @param parts
 * @return
 * @throws InvalidLineFormatException 
 */
	private Publication parseNewsPaper(String[] parts) throws InvalidLineFormatException {
		checkParts(parts, 4);
		String name = parts[1];
		int stock = toInteger(parts[2]);
		int sales = toInteger(parts[3]);
		return new Newspaper(name, stock, sales);
		
	}
private void checkParts(String[] parts, int size) throws InvalidLineFormatException{
	if(parts.length != size) {
		throw new InvalidLineFormatException("Número de campos erróneo");
	}
	
}
/**
 * Méodo que pasa los stocks y sales a ints
 * @param string
 * @return
 */
	private int toInteger(String string) throws InvalidLineFormatException {
		try {
		return Integer.parseInt(string);
		}catch(NumberFormatException e){
			throw new InvalidLineFormatException("Formato de número erróneo");
		}
	}

}
