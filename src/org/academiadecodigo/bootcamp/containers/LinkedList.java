package org.academiadecodigo.bootcamp.containers;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(E data) {

        Node node = new Node(data);
        ListIterator iterator = iterator();

        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.getCurrent().setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public E get(int index) {

        int i = 0;
        ListIterator iterator = iterator();

        while (iterator.hasNext()) {
            if (i == index) {
                return iterator.next();
            }
            iterator.next();
            i++;
        }
        return null;
    }

    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(E data) {

        ListIterator iterator = iterator();
        int i = 0;

        while (iterator.hasNext()) {
            if (iterator.next() == data) {
                return i;
            }
            i++;
        }
        // Arrived at the end of the list, so the element wasn't found inside it
        return -1;
    }

    /**
     * Removes an element from the list
     *
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(E data) {

        ListIterator iterator = iterator();

        while (iterator.hasNext()) {
            if (iterator.next() == data) {
                iterator.remove();
                length--;
                return true;
            }
        }
        return false;
    }

    @Override
    public ListIterator iterator() {
        return new ListIterator(head);
    }


    private class Node {

        private E data;
        private Node next;

        Node(E data) {
            this.data = data;
            next = null;
        }

        E getData() {
            return data;
        }

        void setData(E data) {
            this.data = data;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }

    }

    private class ListIterator implements Iterator<E> {

        private Node current;

        ListIterator(Node node) {
            this.current = node;
        }

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public E next() {
            current = current.getNext();
            return current.getData();
        }

        /**
         * TODO Fix NullPointerException
         */
        public void remove() {
            System.out.println(current.getData());
            current.setNext(current.getNext().getNext());
        }

        Node getCurrent() {
            return current;
        }
    }

}
