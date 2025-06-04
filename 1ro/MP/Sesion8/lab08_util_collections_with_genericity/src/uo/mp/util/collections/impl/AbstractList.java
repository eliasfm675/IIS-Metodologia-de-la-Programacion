package uo.mp.util.collections.impl;

import uo.mp.util.collections.List;

public abstract class AbstractList<T> implements List<T>{
 
	 int numberOfElements;

	public AbstractList() {
		super();
	}

	/**
	 * Futuros metodos comunes de la super clase AbstractList
	 * size()
	 * isEmpty(), en funcion de size()
	 * contains() en funcion de indexOf() (Si es -1) contains devuelve false
	 * add(Object); en funcion de add(size(), object)
	 * remove(Object) en funcon de indexOf y remove(index)
	 * equals(Object); en funcion de get(i)
	 * hashCode(); en funcion de get(i)
	 * toString()
	 */
	public int size() {
		return numberOfElements;
	}

	public boolean isEmpty() {
	return numberOfElements == 0;
	}

	public boolean contains(Object o) {
		if(this.indexOf(o)==-1) {
			return false;
		}else {
			return true;
		}
		
		
	}

	public boolean add(T element) {
		this.add(size(), element);
		if(this.get(size())==element) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean remove(Object o) {
		 int index = indexOf(o);
	        if (index != -1) {
	            remove(index);
	            return true;
	        } else {
	            return false;
	        }
	}
	///------------------- validaciones
	public void checkIndex(int index, int maxIndex) {
		if(index<0 || index> maxIndex) {
			throw new IndexOutOfBoundsException("Index out of range [0, " + maxIndex + "]");
		}
	}
	//añadir checkIllegalArgument(condicion, mensajes)

}