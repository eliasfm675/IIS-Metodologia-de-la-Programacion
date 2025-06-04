package uo.mp.util.collections.impl;

import uo.mp.util.collections.List;

public class LinkedList extends AbstractList implements List {

	private Node head;
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
	private class Node{
		 Object element;
		 Node next;
	Node(Object element, Node next) {
		this.element = element;
		this.next = next;
	}
	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
