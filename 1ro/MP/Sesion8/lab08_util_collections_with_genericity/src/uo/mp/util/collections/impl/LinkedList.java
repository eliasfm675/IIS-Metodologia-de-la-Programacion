package uo.mp.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> extends AbstractList<T> {

    private Node head;
    private int size;

    private class Node {
        T element;
        Node next;

        Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean add(T element) {
        add(size(), element);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (head.element.equals(o)) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.element.equals(o)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index, size() - 1);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index, size() - 1);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T oldValue = current.element;
        current.element = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index, size());
        if (index == 0) {
            head = new Node(element, head);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new Node(element, current.next);
        }
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index, size() - 1);
        T removedElement;
        if (index == 0) {
            removedElement = head.element;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedElement = current.next.element;
            current.next = current.next.next;
        }
        size--;
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(o)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node nextNode = head;
        private Node lastReturned = null;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            T element = nextNode.element;
            lastReturned = nextNode;
            nextNode = nextNode.next;
            return element;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException("No es posible eliminar un elemento antes de llamar a next");
            }
            LinkedList.this.remove(lastReturned.element);
            lastReturned = null;
        }
    }
}
