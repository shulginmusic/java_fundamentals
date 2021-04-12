package labs_examples.datastructures.stack.labs;

import java.util.Arrays;

public class MyStack<T> {
    //Thanks to Youtube Channel Brandon Grasley https://youtu.be/Fccje3W6oBk

    private static final int INITIAL_SIZE = 10; //we start with 10 for the array size
    private T[] array; //initialize the underlying array to hold the objects in the stack

    private int currentEmptyIndex; //***index variable, VERY important!***

    public MyStack() {
        array = (T[]) new Object[INITIAL_SIZE];//declare the array with the INITIAL_SIZE length
        this.currentEmptyIndex = 0;//start at 0
    }

    public void push(T value) {
        checkToResize();
        array[currentEmptyIndex] = value; //set the value at currentEmptyIndex
        currentEmptyIndex++; //Increment currentEmptyIndex
    }

    public T pop() throws StackEmptyException {
        checkToResize();
        if ((checkIfEmpty())) { //if stack is empty
            return null;
        } else {
            T popValue = array[currentEmptyIndex - 1]; //store value
            array[currentEmptyIndex - 1] = null; // empty underlying array at last index used
            currentEmptyIndex--; //decrement the currentEmptyIndex
            checkToResize(); //start downsizing if necessary
            return popValue; //return the stored value that's now been deleted from stack
        }
    }

    public int search(T val) {
        for (int i = 0; i < array.length; i++) { //iterate over the array
            if (array[i] == val) { //search for value
                return i; //return distance from top of the stack
            }
        }
        return -1; //if not found, return -1
    }

    public T peekFirst() throws StackEmptyException{ //as in the first one to be out
        if ((checkIfEmpty())) { //if stack is empty
            return null;
        } else {
            return array[currentEmptyIndex - 1];
        }
    }

    public T peekLast() throws StackEmptyException { //as in the last one to be out
        if ((checkIfEmpty())) { //if stack is empty
            return null;
        } else {
            return array[0];
        }
    }

    public int size() {
        return currentEmptyIndex; //let's say currentEmptyIndex is 5 ... so there are five elements in the stack, since
        //we start at 0: 0, 1, 2, 3, 4
    }

    public void printStackData() throws StackEmptyException {
        if (checkIfEmpty()) {
            ;//do nothing, the message will come from exception
        } else {
            System.out.println("Current underlying array length: " + array.length);
            System.out.print("Stack data: {");
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

    //Clear out the stack
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null; //set every element in the array to null
        }
        currentEmptyIndex = 0;
        checkToResize();//start downsizing
    }

    //________PRIVATE INTERNAL METHODS________
    private void checkToResize() {
        //Find out the current size to array length ratio
        double sizeToLengthRatio = (double) size() / array.length;
        //if greater than .75%, or 3/4, double the stack size
        if ((sizeToLengthRatio) >= 0.75) {
            //increase underlying array length X2
            int newArrayLength = array.length * 2;
            array = Arrays.copyOf(array, newArrayLength); //set array to a copy of itself with a new size
        }
        if ((sizeToLengthRatio) <= 0.25 && size() > 10) {
            //decrease underlying array length by half
            int newArrayLength = array.length / 2;
            array = Arrays.copyOf(array, newArrayLength); //set array to a copy of itself with a new size
        }
    }

    //Check if empty, throw custom exception
    private boolean checkIfEmpty() throws StackEmptyException{
        if (currentEmptyIndex == 0) { //if stack is empty
            throw new StackEmptyException();
        }
        return false;
    }
}
