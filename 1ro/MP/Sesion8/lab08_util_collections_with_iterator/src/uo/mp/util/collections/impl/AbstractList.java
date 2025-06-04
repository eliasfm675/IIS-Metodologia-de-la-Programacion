package uo.mp.util.collections.impl;

import java.util.NoSuchElementException;

public abstract class AbstractList<T> {

    protected int numberOfElements;

    public AbstractList() {
        super();
    }

    public int size() {
        return numberOfElements;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public boolean add(T element) {
        add(size(), element);
        return true; // Siempre devuelve true ya que asumimos que la adición es exitosa
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;  // Se ha eliminado el elemento, devuelve true
        } else {
            return false; // El elemento no estaba en la lista, devuelve false
        }
    }

    public abstract void add(int index, T element);

    public abstract T remove(int index);

    public abstract int indexOf(Object o);

    public void checkIndex(int index, int maxIndex) {
        if (index < 0 || index > maxIndex) {
            throw new IndexOutOfBoundsException("Index out of range [0, " + maxIndex + "]");
        }
    }

    // Otros métodos abstractos que deben ser implementados por las subclases
    // Dependiendo de la implementación específica de la lista, se pueden agregar más métodos abstractos

}
