package labs_examples.datastructures.queue.labs;

import labs_examples.datastructures.stack.labs.StackEmptyException;

/**
 *      Queues - Exercise_02
 *
 *      Write a new custom (Generic) Queue class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Queue class must also do the following:
 *
 *      1) throw a custom exception when trying to pop  an element from an empty Queue
 *      2) resize the Queue (the underlying array) to be twice the size when the Queue is more than 3/4 full
 *      3) resize the Queue (the underlying array) to be half the size when the Queue is more than 1/4 empty
 *      4) contain the methods peekFirst() and peekLast()
 *      5) contain a size() method
 *      6) contain a method to print out the data of all elements in the Queue
 *
 */

public class Exercise_02 {
    public static void main(String[] args) throws QueueEmptyException {
        MyQueue<Integer> nums = new MyQueue<>(); //Declaring a MyQueue object
        nums.enqueue(3);//adding some number to nums
        nums.enqueue(23);
        nums.enqueue(45);
        nums.enqueue(67);
        nums.printQueueData();//This method prints out queue data, along with confirming the resizing of the underlying array

        for (int i = 0; i < 500; i++) {
            nums.enqueue(generateRandom()); //adding more random numbers to queue
        }

        nums.printQueueData(); //see how the array size changed -- every time it's 3/4 full it doubles its size
        System.out.println("Queue size: " + nums.size()); //size method
        nums.clear(); //Clear the queue
        //look at how the underlying array size keeps changing as the program realized it doesn't need that much space...
        nums.enqueue(1); //First in
        nums.printQueueData();
        nums.enqueue(2);
        nums.printQueueData();
        nums.enqueue(3); //Last in
        nums.printQueueData();

        //Or you can just compress at once
//        nums.compress();
        nums.printQueueData();
        System.out.println("-----Peeking-----");
        //Peek methods
        System.out.println(nums.peekFirst()); //First out
        System.out.println(nums.peekLast()); //Last out

        System.out.println("-----Dequeueing-----");
        //Checking if the dequeueing works properly
        System.out.println(nums.dequeue());
        System.out.println(nums.dequeue());
        nums.printQueueData();

//        nums.clear(); //clear the queue
//
//        System.out.println(nums.dequeue()); //Throw custom exception when dequeueing from empty queue

        nums.enqueue(12);
        nums.enqueue(23);
        nums.enqueue(343);
        nums.enqueue(11);
        int element = nums.dequeue();
        int elementTwo = nums.dequeue();

        nums.printQueueData();

    }


    //A method to generate random numbers
    private static Integer generateRandom() {
        int min = 0;
        int max = 1423;
        int range = max - min + 1;

        return (int) (Math.random() * range) + min;

    }
}
