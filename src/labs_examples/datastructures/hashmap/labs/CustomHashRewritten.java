package labs_examples.datastructures.hashmap.labs;

import java.util.Arrays;

public class CustomHashRewritten<Key, Value> {
    //underlying array with initial size 10
    private Node<Key, Value>[] array = new Node[10];

    //track the size
    private int size = 0;

    //Internal node class ...
    class Node<Key, Value> {
        private Key key;
        private Value value;
        Node next = null;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Key getKey() {
            return key;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }
    }

    //METHODS

    //________PUBLIC INTERNAL METHODS________

    public void insert(Key key, Value value) {
        //generate the index for the key
        int nodeIndex = getIndex(key);
        //Declare new node
        Node<Key, Value> node = new Node<>(key, value);

        //if there is no element at the generated index, simply add the value
        if (array[nodeIndex] == null) {
            array[nodeIndex] = node;
        } else { //in case there is something already at the index, means there is a collision
            //get the node that's already at that nodeIndex
            Node<Key, Value> linkedNode = array[nodeIndex];

            //iterate through the linked list
            while (linkedNode.next != null) {
                linkedNode = linkedNode.next;
                //Technically here we have an O(n), but resizing often should prevent many collisions
            }
            //we are now at the end of the linked list
            //add the new element now...
            linkedNode.next = node;
        }
        size++;

        //resize if necessary
        checkToResize();
    }

    public Value retrieve(Key key) {
        //First get the index for the key
        int nodeIndex
    }


    //Utility method to return the current size (number of elements) in this hashmap
    public int size() {
        return size;
    }

    //________PRIVATE INTERNAL METHODS________

    //Generate an index for a given key
    private int getIndex(Key key) {
        //we determine the index by modding the hashcode of the key by the current
        //underlying array length
        return Math.abs(key.hashCode() % array.length);
    }

    private void checkToResize() {
        //Find out the current size to array length ratio
        double sizeToLengthRatio = (double) size() / array.length;
        //if greater than .75%, or 3/4, double the stack size
        if ((sizeToLengthRatio) > 0.75) {
            //increase underlying array length X2
//            increaseSize;
        }
        if ((sizeToLengthRatio) <= 0.25 && size() > 10) {
//            decreaseSize;
        }
    }



}


















