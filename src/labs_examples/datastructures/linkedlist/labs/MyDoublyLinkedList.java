package labs_examples.datastructures.linkedlist.labs;

public class MyDoublyLinkedList<T> {
    //VARIABLES
    //The head variable
    private MyDoublyLinkedNode<T> head;
    private MyDoublyLinkedNode<T> tail;

    //The size variable
    private int size;

    //CONSTRUCTORS
    public MyDoublyLinkedList() {
        this.head = null;
    }

    public MyDoublyLinkedList(MyDoublyLinkedNode<T> head) {
        this.head = head;
    }

    //ADD / INSERT METHODS
    public void add(T data) {
        MyDoublyLinkedNode<T> node = new MyDoublyLinkedNode<T>(data);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = tail.next;
        }
        size++;
    }


}




















