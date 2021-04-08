package labs_examples.datastructures.queue.labs;

import java.util.PriorityQueue;

/**
 *      Demonstrate your mastery of Java's (sun's) built-in Queue class (as seen in the import statement
 *      above) by completing the following:
 *
 *      1) instantiate a new Queue
 *      2) demonstrate the use of EVERY method in the Queue class - there are 7
 */

public class Exercise_01 {
    public static void main(String[] args) {
        //There was no import statement in this file, but nonetheless going to use PriorityQueue
        PriorityQueue<Integer> nums = new PriorityQueue<>();
        //adding
        nums.add(1);
        nums.add(11);
        nums.add(111);
        nums.add(1111);
        //peeking
        System.out.println(nums.peek());
        System.out.println(nums.size());//size
        System.out.println(nums.remove());//equivalent to .pop()
        System.out.println(nums.peek());//peeking again
        System.out.println(nums.size());//new size
        System.out.println(nums.contains(1));//contains method returns boolean
        System.out.println(nums.remove(111));//remove an element
        nums.poll(); //remove first element using .poll()
        nums.clear();//clear out
        System.out.println(nums.peek());//null because queue has been cleared


    }
}
