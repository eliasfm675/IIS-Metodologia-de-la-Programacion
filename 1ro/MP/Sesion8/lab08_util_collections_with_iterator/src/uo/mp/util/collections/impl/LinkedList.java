package uo.mp.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList extends AbstractList {

    private Node head;

    private class Node {
        Object element;
        Node next;

        Node(Object element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        head = null;
        numberOfElements = 0;
    }

    @Override
    public Object get(int index) {
        Node node = getNodeAtIndex(index);
        return node.element;
    }

    @Override
    public Object set(int index, Object element) {
        Node node = getNodeAtIndex(index);
        Object oldValue = node.element;
        node.element = element;
        return oldValue;
    }

    @Override
    public void add(int index, Object element) {
        checkIndexForAdd(index, numberOfElements);
        if (index == 0) {
            head = new Node(element, head);
        } else {
            Node prevNode = getNodeAtIndex(index - 1);
            prevNode.next = new Node(element, prevNode.next);
        }
        numberOfElements++;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index, numberOfElements - 1);
        Object removedElement;
        if (index == 0) {
            removedElement = head.element;
            head = head.next;
        } else {
            Node prevNode = getNodeAtIndex(index - 1);
            removedElement = prevNode.next.element;
            prevNode.next = prevNode.next.next;
        }
        numberOfElements--;
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    @Override
    public Iterator<Object> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Object> {
        private Node next;
        private Node lastReturned;
        private boolean removed;

        LinkedListIterator() {
            next = head;
            removed = false;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            lastReturned = next;
            next = next.next;
            removed = false;
            return lastReturned.element;
        }

        @Override
        public void remove() {
            if (removed || lastReturned == null) {
                throw new IllegalStateException("No es posible eliminar un objeto sin hacer previamente next o remove repetido");
            }
            if (lastReturned == head) {
                head = head.next;
            } else {
                Node current = head;
                while (current != null && current.next != lastReturned) {
                    current = current.next;
                }
                current.next = lastReturned.next;
            }
            lastReturned = null;
            numberOfElements--;
            removed = true;
        }
    }

    private Node getNodeAtIndex(int index) {
        checkIndex(index, numberOfElements - 1);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
