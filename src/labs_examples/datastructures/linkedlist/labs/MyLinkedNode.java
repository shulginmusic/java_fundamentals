package labs_examples.datastructures.linkedlist.labs;

public class MyLinkedNode<T>{
    //The Data
    T data;
    //the next pointer
    MyLinkedNode<T> next;

    public MyLinkedNode(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "MyLinkedListNode{" +
                "data=" + data;
    }
}
