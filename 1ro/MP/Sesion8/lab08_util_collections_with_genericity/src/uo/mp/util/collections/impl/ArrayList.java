package uo.mp.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> extends AbstractList<T> {
    private T[] elements;

    public ArrayList(int initialCapacity) {
        elements = (T[]) new Object[initialCapacity];
    }

    @Override
    public void clear() {
        elements = (T[]) new Object[elements.length];
        numberOfElements = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index, numberOfElements - 1);
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index, numberOfElements - 1);
        T oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index, numberOfElements);
        if (numberOfElements == elements.length) {
            resize();
        }
        for (int i = numberOfElements; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        numberOfElements++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index, numberOfElements - 1);
        T removedElement = elements[index];
        for (int i = index; i < numberOfElements - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[numberOfElements - 1] = null; 
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < numberOfElements; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        private int index;
        private T lastReturned;

        private ArrayListIterator() {
            index = 0;
            lastReturned = null;
        }

        @Override
        public boolean hasNext() {
            return index < numberOfElements;
        }

        @Override
        public T next() {
            if (hasNext()) {
                lastReturned = elements[index];
                index++;
                return lastReturned;
            } else {
                throw new NoSuchElementException("No hay más elementos");
            }
        }

        @Override
        public void remove() {
            if (lastReturned != null) {
                ArrayList.this.remove(index - 1);
                index--;
                lastReturned = null;
            } else {
                throw new IllegalStateException("No es posible eliminar un objeto sin hacer previamente next");
            }
        }
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        T[] newElements = (T[]) new Object[newCapacity];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}
