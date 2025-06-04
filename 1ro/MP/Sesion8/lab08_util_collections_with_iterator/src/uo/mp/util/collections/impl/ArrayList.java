package uo.mp.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import uo.mp.util.collections.List;

public class ArrayList extends AbstractList implements List {
    private Object[] elements;

    @Override
    public void clear() {
        elements = new Object[elements.length];
        numberOfElements = 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index, numberOfElements - 1);
        return elements[index];
    }

    @Override
    public Object set(int index, Object element) {
        checkIndex(index, numberOfElements - 1);
        Object oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, Object element) {
        checkIndex(index, numberOfElements);
        if (numberOfElements == elements.length) {
            resize();
        }
        // Shift elements to the right to make space for the new element
        for (int i = numberOfElements; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        numberOfElements++;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index, numberOfElements - 1);
        Object removedElement = elements[index];
        // Shift elements to the left to fill the gap left by the removed element
        for (int i = index; i < numberOfElements - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[numberOfElements - 1] = null; // Clear the last element
        numberOfElements--;
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
    public Iterator<Object> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<Object> {
        private int index;
        private int lastReturnedIndex;

        private ArrayListIterator() {
            index = 0;
            lastReturnedIndex = -1;
        }

        @Override
        public boolean hasNext() {
            return index < numberOfElements;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos");
            }
            lastReturnedIndex = index;
            return elements[index++];
        }

        @Override
        public void remove() {
            if (lastReturnedIndex == -1) {
                throw new IllegalStateException("No es posible eliminar un objeto sin hacer previamente next");
            }
            ArrayList.this.remove(lastReturnedIndex);
            if (index > lastReturnedIndex) {
                index--;
            }
            lastReturnedIndex = -1;
        }
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}
