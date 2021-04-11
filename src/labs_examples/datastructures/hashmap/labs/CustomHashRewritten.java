package labs_examples.datastructures.hashmap.labs;

public class CustomHashRewritten<Key, Value> {
    //underlying array with initial size 10
    private Node<Key, Value>[] array = new Node[10];

    //track the size
    private int size = 0;

    //Internal node class ...
    class Node<Key, Value> {
        private Key key;
        private Value value;
        Node previous = null;
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
            while (linkedNode.previous != null) {
                //on collisions, add new elements to the front of the LinkedList, not the end
                linkedNode = linkedNode.previous;

                //Technically here we have an O(n), but resizing often should prevent many collisions
            }
            //we are now at the end of the linked list
            //add the new element now...
            linkedNode.previous = node;
        }
        size++;

        //resize if necessary
        checkToResize();
    }

    public Value retrieve(Key key) {
        //First get the index for the key
        int nodeIndex = getIndex(key);

        //if nothing is at the index of the key, return null
        if (array[nodeIndex] == null) {
            System.out.println("No such key - value in hashmap to retrieve");
            return null;
        }

        //If something is at the index, get it or iterate over the linked list if there is one
        Node<Key, Value> node = array[nodeIndex];
        if (node.getKey().equals(key)) {
            return node.getValue(); //if the key is at this index
        } else {
            //iterate over the linked list
            while (!node.getKey().equals(key) && node.previous != null) {
                node = node.previous;
            }
            //We have now reached the end of the linked list and/or have found the key
            if (node.getKey().equals(key)) {
                return node.getValue(); //if key is found
            } else {
                System.out.println("No such key - value in hashmap to retrieve");
                return null; //if it's not found
            }
        }
    }

    public void delete(Key key) {
        //Make sure key exists
        if (retrieve(key) == null) {
            System.out.println("No such key - value in hashmap to delete");
            return;
        }

        //if key does exist, then get the get its index
        int nodeIndex = getIndex(key);

        //Get the node at the index
        Node<Key, Value> node = array[nodeIndex];

        //remove the element if this is the node we are looking for AND it's not a linked list
        if (node.getKey().equals(key) && node.previous == null) {
            array[nodeIndex] = null;
            size--;
            return;
        } else if (node.getKey().equals(key) && node.previous != null) {
//            remove the element if this is the node we are looking for AND IT IS a linked list
            array[nodeIndex] = node.previous;
            size--;
            return;
        }

        //If not, then this is a linked list and we need to iterate over it

        while (node.previous != null) { //while the previous node != null
            if (!node.previous.getKey().equals(key)) {
                //if the previous node doesn't have the key, keep iterating
                node = node.previous;
            }
        }
        if (node.getKey() != key) { //if no match is found
            System.out.println("No such key-value pair to delete");
            return;
        } else { //if found
            if (node.previous.previous != null) {
                //if there is a node.previous.previous i.e. if we are in the middle of the linked list
                node.previous = node.previous.previous;
                size--;
                return;
            } else { //else if we are at the beginning of the list
                node.previous = null;
                size--;
                return;
            }
        }
    }

    //Method to clear the hashmap
    public void clear() {
        array = new Node[10];
        size = 0;
    }

    //Method to print hashmmap info and nodes (entries)

    public void printInfo() {
        System.out.println("Hashmap size: " + size());
        System.out.println("Current underlying array length: " + capacity());
        System.out.println("Key - value pairs: ");

        //print every node
        for (Node pair : array) {
            try {
                //if a linked list:
                //iterate over the list
                Node iterator = pair;
                if (iterator.previous != null) {
                    System.out.print("Linked List: ");
                    while (iterator.previous != null) {
                        System.out.print(iterator.getKey() + " - " + iterator.getValue() + "; ");
                        iterator = iterator.previous;
                    }
                } else { //if NOT a linked list
                    System.out.print(pair.getKey() + " - " + pair.getValue()); //simply print the key - value pair
                }
                System.out.println();
            } catch (NullPointerException exc) {
                ;//do nothing here
            }

        }
    }


    //Utility method to return the current size (number of elements) in this hashmap
    public int size() {
        return size;
    }

    //Utility method to return current underlying array length
    public int capacity() {
        return array.length;
    }

    //________PRIVATE INTERNAL METHODS________

    //Generate an index for a given key
    private int getIndex(Key key) {
        //we determine the index by modding the hashcode of the key by the current
        //underlying array length
        return Math.abs(key.hashCode() % array.length);
    }

    //Method to check if underlying array needs to be resized
    private void checkToResize() {
        //Find out the current size to array length ratio
        double sizeToLengthRatio = (double) size() / array.length;
        //if greater than .75%, or 3/4, double the stack size
        if ((sizeToLengthRatio) > 0.5) { //resize the HashMap when the underlying array is more than half full
            //increase underlying array length X3
            increaseSize();
        }
        if ((sizeToLengthRatio) <= 0.25 && size() > 10) {
            decreaseSize();
        }
    }

    //Increase underlying array size
    private void increaseSize() {
        //Copy old underlying array
        Node<Key, Value>[] oldArray = array;

        //Declare new underlying array that is 3x the size of the old one
        array = new Node[oldArray.length * 3];
        //Reset size
        size = 0;

        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] != null) {
                //Get node at the index of i
                Node<Key, Value> node = oldArray[i];

                //insert the node into the new underlying array
                insert(node.key, node.value); //this is called from within and is done on the new array declared above

                //check if the node is a linked list node
                if (node.previous != null) {
                    Node<Key, Value> iterator = node.previous;
                    while (iterator != null) {
                        //add the node to the underlying array
                        insert(iterator.getKey(), iterator.getValue());
                        //keep iterating
                        iterator = iterator.previous;
                    }
                }
            }
        }
    }


    private void decreaseSize() {
        //Copy old underlying array
        Node<Key, Value>[] oldArray = array;

        //Declare new underlying array that is half the size of the old one
        array = new Node[oldArray.length / 2];
        //Reset size
        size = 0;

        //iterate over the old array
        for (int i = 0; i < oldArray.length; i++) {
            try {
                //Get node at the index of i
                Node<Key, Value> node = oldArray[i];

                //insert the node into the new underlying array
                insert(node.key, node.value); //this is called from within and is done on the new array declared above

                //check if the node is a linked list node
                if (node.previous != null) {
                    Node<Key, Value> iterator = node.previous;
                    while (iterator != null) {
                        //add the node to the underlying array
                        insert(iterator.getKey(), iterator.getValue());
                        //keep iterating
                        iterator = iterator.previous;
                    }
                }
            } catch (Exception e) {
                ; //nothing to be done here, this is for empty indexes
            }
        }
    }
}


















