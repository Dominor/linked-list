package org.academiadecodigo.bootcamp.containers;

public class LinkedList {

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
     * @param data the element to add
     */
    public void add(Object data)  {

        Node node = new Node(data);
        Node iterator = head;

        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {

        Node iterator = head;
        int i = 0;

        while (iterator.getNext() != null) {
            if (i == index) {
                return iterator.getNext().getData();
            }
            iterator = iterator.getNext();
            i++;
        }
        return null;
    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {

        Node iterator = head;
        int i = 0;

        while (iterator.getNext() != null) {
            if (iterator.getNext().getData() == data) {
                return i;
            }
            iterator = iterator.getNext();
            i++;
        }
        // Arrived at the end of the list, so the element wasn't found inside it
        return -1;
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {

        Node iterator = head;

        while (iterator.getNext() != null) {
            if (iterator.getNext().getData() == data) {
                iterator.setNext(iterator.getNext().getNext());
                length--;
                return true;
            }
            iterator = iterator.getNext();
        }
        return false;
    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
