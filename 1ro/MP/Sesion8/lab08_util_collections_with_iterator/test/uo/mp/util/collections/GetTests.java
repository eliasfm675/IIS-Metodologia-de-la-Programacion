package uo.mp.util.collections;

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
 * 	1 Realizar get en una posición cualquiera de una lista no vacía retorna el elemento y la lista perpanece igual
 * 	2 Intentar realizar get en la posición 0 de una lista vacía, lanza IndexOutOfBoundsException
 * 	3 Intentar realizar get en la posición -1 de una lista vacía, lanza IndexOutOfBoundsException
 * 	4 Intentar realizar get en la posición -1 de una lista con elementos, lanza IndexOutOfBoundsException
 * 	5 Intentar realizar get en la posición size() de una lista con elementos, lanza IndexOutOfBoundsException
 */
public class GetTests {
	
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
	public void inList(List list) {
		fail();
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
	public void upper(List list) {
		try {
			list.get(list.size());
			fail("Should have failed");
		}catch(IndexOutOfBoundsException e) {
		}
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyMinusOne(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void lower(List list) {
		fail();
	}
}
