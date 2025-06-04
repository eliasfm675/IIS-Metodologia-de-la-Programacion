package uo.mp.util.collections;



import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;


//Escenarios
//1 Add en la posición 0 de una lista vacía añade el elemento
//2 Add en la posición 0 de una lista con varios elementos añade el elemento y mueve el resto una posición a la derecha
//3 Add en una posición intermedia de una lista añade el elemento y mueve el resto una posición a la derecha
//4 Add en la última posición de una lista con elementos añade el elemento y el último pasa a la derecha
//5 Add en la posición después del último de una lista con elementos añade el elemento al final
//6 Un elemento repetido PUEDE ser añadido y se almacena correctamente
//7 Intentar añadir  en una posición negativa, se lanza IndexOutOfBoundsException y la lista permanece igual
//8 Intentar añadir en una posicón > size(), se lanza IndexOutOfBoundsException y la lista permanece igual
//9 Intentar añadir un null, se lanza IllegalArgumentException y la lista permanece igual

public class AddInPositionTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	
	@ParameterizedTest
	@MethodSource("createLists")
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	public void emptyListAddAt0(List list) {
		
	}
	
	
	
	/**
	 * GIVEN: a non empty list and a non null element
	 * WHEN: trying to add the element at first position
	 * THEN: the list contains element at index 0, the size is increased in 1
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addNonEmptyListAddAt0(List list) {
		list.add(0, "with");
		list.add(1, "JUnit");
		list.add(2, "framework");
		int lsize = list.size();

		list.add(0, "testing");

		assertTrue(list.size() == lsize+1);
		assertTrue(list.get(0).equals("testing"));
		assertTrue(list.toString().equals("[testing, with, JUnit, framework]"));
	}

	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addLast(List list) {
		fail();
	}

	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addMiddle(List list) {
		fail();
	}
	

	
	
	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void nullExcep(List list) {
		fail();
	}
	

	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest 
	@MethodSource("createLists")
	public void UpperBound(List list) {
		fail();
	}
	
	/**
	 * GIVEN: a list with elements
	 * WHEN: trying to add an element to said list in negative position
	 * THEN: that element is not added to the list and it throws IndexOutofBoundsException
	 */
	@ParameterizedTest 
	@MethodSource("createLists")
	public void LowerBound(List list) {
		list.add(0, "with");
		list.add(1, "JUnit");
		list.add(2, "framework");
		String ts = list.toString();
	try {
		list.add(-1, "hghgfigh");
		fail();
	}catch(IndexOutOfBoundsException i){
		assertTrue(3==list.size());
		assertTrue(list.toString().equals(ts));
	}
	}

	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addRepeated(List list) {
		fail();
	}
	
}
