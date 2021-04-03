package labs_examples.datastructures.linkedlist.labs;

public class MyDoublyLinkedNode<T> {
    //VARIABLES

    //Data
    T data;
    //Previous Pointer
    MyDoublyLinkedNode<T> previous;
    //Next Pointer
    MyDoublyLinkedNode<T> next;

    //CONSTRUCTOR
    public MyDoublyLinkedNode(T data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "MyDoublyLinkedListNode{" +
                "data=" + data +
                ", previous=" + previous +
                ", next=" + next +
                '}';
    }
}
