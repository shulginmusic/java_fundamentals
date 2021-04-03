package labs_examples.datastructures.linkedlist.labs;

/**
 *      LinkedLists - Exercise_02
 *
 *      Write your own custom LinkedList class. Although it can mimic the CustomLinkedList
 *      class we used here, it must be entirely unique. Please also add at least two
 *      additional helper methods that you think could be useful. Refer to Java's built-in
 *      LinkedList class for inspiration. Your new LinkedList class should ONLY allow users
 *      to add and remove elements from the front of the list AND the end of the list.
 *      Also, instead of using the index in the get() and remove() methods, these methods should
 *      get() and remove() based by the Node's value, not it's index.
 */

public class MyLinkedList<T> {

    //The head variable
    private MyLinkedNode<T> head;

    private int size;

    public MyLinkedList(T data) {
        add(data);
    }

    public MyLinkedList() {
        head = null;
    }

    public void add(T data) {
        insert(data);
        size++;
    }

    public void add(T data, boolean first) {
        //This method will add to the front of the list provided a true boolean
        insert(data, first);
        size++;
    }

    private void insert (T data) { //Access modifier private because this method is only ever called internally
        //if head == null, create new head
        if (head == null) {
            head = new MyLinkedNode<T>(data); //pass the data to the Node object
        } else {
            //Reference to the head node
            MyLinkedNode<T> myLinkedNodeIterator = head;
            //Iterate through the list and find the last node
            while (myLinkedNodeIterator.next != null) {
                myLinkedNodeIterator = myLinkedNodeIterator.next;
            }
            //Now that the iterator.next is null, set it to the new value
            myLinkedNodeIterator.next = new MyLinkedNode<T>(data);

        }
    }

    private void insert (T data, boolean first) {
        //This method will add to the front of the list provided a true boolean
        MyLinkedNode<T> firstNode = new MyLinkedNode<>(data); //declare the node to insert
        //if head == null, create new head
        if (head == null) {
            head = new MyLinkedNode<T>(data); //pass the data Integer to the Node object
        } else if (first){ //Thanks StackOverflow https://stackoverflow.com/questions/19126347/addfirst-in-a-custom-linkedlist
            firstNode.next = head; //set the .next of firstNode to head
            head = firstNode; //make the first node head
        } else {
            //Reference to the head node
            MyLinkedNode<T> myLinkedNodeIterator = head;
            //Iterate through the list and find the last node
            while (myLinkedNodeIterator.next != null) {
                myLinkedNodeIterator = myLinkedNodeIterator.next;
            }
            //Now that the iterator is null, set it to the new value
            myLinkedNodeIterator.next = new MyLinkedNode(data);
        }
    }

    public void remove(T val) {
        if (size == 0) {
            System.out.println("Nothing to remove!"); //If size is 0, just stop right there
            return;
        } else {
            MyLinkedNode iterator = head;
            if (iterator.data.equals(val)) { //if val is in the first node in the list (because iterator = head)
                if (iterator.next != null) { //if head has a next
                    head = iterator.next; //make the iterator (which is head right now) equal to whatever its next is
                    size--; //downsize
                } else { //if head doesn't have a next
                    clear(); //list is now empty
                }
            } else { //if val isn't in the first node, then let's iterate
                MyLinkedNode<T> previous = null; //set a previous variable
                while (!iterator.data.equals(val) && iterator.next != null) { //while data != null && iterator has a next
                    previous = iterator; //assign previous to what iterator right now is
                    iterator = iterator.next; //assign iterator to the next node
                } //iteration is now complete
                if (iterator.data.equals(val)) { //if node with val is found
                    if (iterator.next != null) { //if node has a next
                        previous.next = iterator.next; //THIS is important
                        //link previous of iterator to next of iterator, essentially throwing out the iterator in the middle
                        size--; //don't forget to downsize
                    } else { //if node doesn't have a next i.e. last node
                        previous.next = null; //set previous.next i.e. last node to null
                        size--;
                    }
                } else { //if value wasn't in any of the nodes
                    System.out.println("No such value in list");
                }
            }
        }
    }

    public T getFirst() {
        try {
            return head.data;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public T get(T val) {
        MyLinkedNode<T> iterator = head;
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

    public int getSize() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

}
