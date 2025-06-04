package uo.mp.util.collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

/*
 * ESCENARIOS
 * 	1 Una lista vacía no contiene un elemento cualquiera
 * 	2 Una lista con varios elementos no contiene al elemento cualquiera 
 * 	3 Una lista con un elemento contiene al elemento
 * 	4 Una lista con varios elemento contiene al elemento
 * 	5 Una lista vacía no contienen null
 * 	6 Una lista con elementos no contiene null
 */
public class ContainsTests {
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}


	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyList(List list) {
		fail();
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void notInList(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void onlyElementInList(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void isInList(List list) {
		fail();
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyListDoesNotContainNull(List list) {

		fail();
	}
	
	/**
	 * GIVEN: a list with some elements
	 * WHEN:  calling the method contains() with null as a parameter
	 * THEN: it returns false because null is not an element in the list
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void nullNotInList(List list) {
		list.add("JOse");
		list.add("Manolo");
		list.add("Piolin");
		assertFalse(list.contains(null));
	}
}
