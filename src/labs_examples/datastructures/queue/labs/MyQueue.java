package labs_examples.datastructures.queue.labs;

import java.util.Arrays;

public class MyQueue<T> {
    //Thanks to Youtube Channel Brandon Grasley https://youtu.be/Fccje3W6oBk

    private static final int INITIAL_SIZE = 10; //we start with 10 for the array size
    private T[] array; //initialize the underlying array to hold the objects in the queue

    private int currentEmptyIndex; //***index variable, VERY important!***

    public MyQueue() {
        array = (T[]) new Object[INITIAL_SIZE];//declare the array with the INITIAL_SIZE length
        this.currentEmptyIndex = 0;//start at 0
    }

    public void enqueue(T value) {
        checkToResize();
        array[currentEmptyIndex] = value; //set the value at currentEmptyIndex
        currentEmptyIndex++; //Increment currentEmptyIndex
    }

    public T dequeue() throws QueueEmptyException {
        checkToResize();
        if ((checkIfEmpty())) { //if queue is empty
            return null;
        } else {
            T popValue = array[0]; //store value
            for (int i = 0; i < size(); i++) {
                array[i] = array[i + 1];
            }
            currentEmptyIndex--; //decrement the currentEmptyIndex
            checkToResize(); //start downsizing if necessary
            return popValue; //return the stored value that's now been deleted from queue
        }
    }

    public T peekFirst() throws QueueEmptyException{ //as in the first one to be out
        if ((checkIfEmpty())) { //if queue is empty
            return null;
        } else {
            return array[0];
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
        return currentEmptyIndex; //let's say currentEmptyIndex is 5 ... so there are five elements in the queue, since
        //we start at 0: 0, 1, 2, 3, 4
    }

    public void printQueueData() throws QueueEmptyException {
        if (checkIfEmpty()) {
            ;//do nothing, the message will come from exception
        } else {
            System.out.println("Current underlying array length: " + array.length);
            System.out.print("queue data: {");
            for (T element : array) {
                if (element != null) {
                    System.out.print(element + ", "); //Print out every element in the underlying array, neatly
                }

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
        for (int i = 0; i < array.length; i++) {
            array[i] = null; //set every element in the array to null
        }
        currentEmptyIndex = 0;
        checkToResize(); //start downsizing
    }

    //________PRIVATE INTERNAL METHODS________
    private void checkToResize() {
        //Find out the current size to array length ratio
        double sizeToLengthRatio = (double) size() / array.length;
        //if greater than .75%, or 3/4, double the queue size
        if ((sizeToLengthRatio) >= 0.75) {
            //increase underlying array length X2
            int newArrayLength = array.length * 2;
            array = Arrays.copyOf(array, newArrayLength); //set array to a copy of itself with a new size
        }
        if ((sizeToLengthRatio) <= 0.25) {
            //decrease underlying array length by half
            int newArrayLength = array.length / 2;
            array = Arrays.copyOf(array, newArrayLength); //set array to a copy of itself with a new size
        }
    }

    //Check if empty, throw custom exception
    private boolean checkIfEmpty() throws QueueEmptyException{
        if (currentEmptyIndex == 0) { //if queue is empty
            throw new QueueEmptyException();
        }
        return false;
    }
}
