package labs_examples.datastructures.queue.labs;

import java.util.Arrays;

public class MyQueue<T> {
    //Thanks to Youtube Channel Brandon Grasley https://youtu.be/Fccje3W6oBk

    private static final int INITIAL_SIZE = 10; //we start with 10 for the array size
    private T[] array; //initialize the underlying array to hold the objects in the queue

    private int oldestElement; //keeping track of oldest element (i.e. the first one to go out of the queue, to be dequeued)
    private int currentEmptyIndex; //current index after last element in the underlying array
    private int numElements; //keeping track of num of elements in the queue, e.g. to resize the underlying array if necessary

    public MyQueue() {
        array = (T[]) new Object[INITIAL_SIZE];//declare the array with the INITIAL_SIZE length
        oldestElement = 0;
        currentEmptyIndex = 0;
    }

    public void enqueue(T value) throws QueueEmptyException {
        //This if block may seem redundant, but the indexes need to be reset after clearing the array
        // without the clear() method, and this is an easy way to solve that problem
        if (size() == 0) {
            array[0] = value;
            currentEmptyIndex = 1; //this index would be 2 if the array was dequeued a 100 times to empty
            oldestElement = 0; ////this index would be 2 if the array was dequeued a 100 times to empty
            numElements++;
        } else {
            checkToResize();
            array[currentEmptyIndex] = value; //set the value at newest element
            currentEmptyIndex++; //Increment newest element
            numElements++; //Increment num of elements
        }

    }

    public T dequeue() throws QueueEmptyException {
        if ((checkIfEmpty())) { //if queue is empty
            return null;
        } else {
            T popValue = array[oldestElement]; //store value
            array[oldestElement] = null;
            oldestElement++;
            numElements--;
            checkToResize(); //start downsizing if necessary
            return popValue; //return the stored value that's now been deleted from queue
        }
    }

    public int search(T val) {
        for (int i = 0; i < array.length; i++) { //iterate over the array
            if (array[i] == val) { //search for value
                return i; //return distance from the first element of the queue
            }
        }
        return -1; //if not found, return -1
    }

    public T peekFirst() throws QueueEmptyException{ //as in the first one to be out
        if ((checkIfEmpty())) { //if queue is empty
            return null;
        } else {
            return array[oldestElement];
        }
    }

    public T peekLast() throws QueueEmptyException { //as in the last one to be out
        if ((checkIfEmpty())) { //if queue is empty
            return null;
        } else {
            return array[currentEmptyIndex - 1];
        }
    }

    public int size() {
        return numElements; //let's say currentEmptyIndex is 5 ... so there are five elements in the queue, since
        //we start at 0: 0, 1, 2, 3, 4
    }

    public void printQueueData() throws QueueEmptyException {
        if (checkIfEmpty()) {
            ;//do nothing, the message will come from exception
        } else {
            System.out.println("Current underlying array length: " + array.length);
            System.out.print("queue data: {");
            int count = 0;
            //Print out every element in the underlying array, neatly
            for (T element : array) {
                if (count == 0) {
                    System.out.print(element);
                } else {
                    System.out.print(", " + element);
                }
                count++;
            }
            System.out.print("}\n");
        }
    }

    //Compress
    public void compress() {
        array = Arrays.copyOf(array, size()); //set array equal to its size, so no extra spaces in memory
    }

    //Clear out the queue
    public void clear() {
        array = (T[]) new Object[INITIAL_SIZE];//declare the array with the INITIAL_SIZE length
        currentEmptyIndex = 0;
        oldestElement = 0;
        numElements = 0;
    }
    //- - - 3 2 6 - - - -


    //________PRIVATE INTERNAL METHODS________

    private void shuffle() {
        if (oldestElement > array.length * 0.3) {
            int count = 0;
            for (int i = oldestElement; i < currentEmptyIndex; i++) {
                array[count] = array[i];
                array[i] = null;
                count++;
            }
            oldestElement = 0;
            currentEmptyIndex = count;
        }

    }

    private void checkToResize() throws QueueEmptyException {
        shuffle();
        //Find out the current size to array length ratio
        double sizeToLengthRatio = (double) size() / array.length;
        //if greater than .75%, or 3/4, double the queue size
        if ((sizeToLengthRatio) >= 0.75) {
            //increase underlying array length X2
            int newArrayLength = array.length * 2;
            array = Arrays.copyOf(array, newArrayLength); //set array to a copy of itself with a new size
        }
        if ((sizeToLengthRatio) <= 0.25 && array.length > 10) {
            //decrease underlying array length by half
            int newArrayLength = array.length / 2;
            array = Arrays.copyOf(array, newArrayLength); //set array to a copy of itself with a new size
        }
//        if (checkIfEmpty()) {
//            oldestElement = 0;
//            currentEmptyIndex = 0;
//        }
    }

    //Check if empty, throw custom exception
    private boolean checkIfEmpty() throws QueueEmptyException{
        if (numElements == 0) { //if queue is empty
            throw new QueueEmptyException();
        }
        return false;
    }
}
