package labs_examples.datastructures.linkedlist.labs;

public class MyDoublyLinkedList<T> {
    //Thanks to William Fiset https://github.com/williamfiset/data-structures/blob/master/com/williamfiset/datastructures/linkedlist/DoublyLinkedList.java

    private int size;
    private Node<T> head;
    private Node<T> tail;

    //Internal node class:
    private static class Node<T> {
        private T data;
        private Node<T> previous;
        private Node<T> next;

        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    public void add(T data) {
        if (size == 0) { //if list is empty
            head = new Node<T>(data, null, null);
            tail = head;
        } else {
            tail.next = new Node<T>(data, tail, null); //set the next of the tail to the new node
            tail = tail.next; //make this new node the tail
        }
        size++;
    }

    public void remove(T data) {
        //First check if empty
        if (size == 0) {
            System.out.println("Nothing to remove!");
        } else if (size == 1) { //if only one element in list
            head = null;
            tail = null;
            size = 0;
        } else {
            if (head.data.equals(data)) { //if head is to be removed
                head = head.next; //set the head to next
                head.previous = null; //set the previous to null, because this is head now without a null (this is not a circular list)
                if (size == 1) { //if only one element left in list
                    tail = head; //tail is the same as head
                }
                size--;
            } else if (tail.data.equals(data)) { //if tail is to be removed
                tail = tail.previous; //set the tail to its previous
                tail.next = null; //set the next to null, because this is head now without a null (this is not a circular list)
                if (size == 1) { //if only one element left in list
                    head = tail; //tail is the same as head
                }
                size--;
            } else { //if the removal is somewhere in between
                Node<T> iterator = head.next;
                while (!iterator.data.equals(data) && iterator.next != null) { //iterate through list
                    iterator = iterator.next;
                }
                if (iterator.data.equals(data)) {
                    iterator.previous.next = iterator.next;
                    iterator.next.previous = iterator.previous;
                    size--;
                } else {
                    System.out.println("No such value in list");
                }

            }
        }
    }

    public T get(T val) {
        Node<T> iterator = head;
        try {
            while (iterator.data != val) {
                iterator = iterator.next;
            }
        } catch (NullPointerException e) {
            System.out.println("Value not found");
            return null;
        }
        return iterator.data;
    }

    public T getFirst() {
        try {
            return head.data;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }
}





















