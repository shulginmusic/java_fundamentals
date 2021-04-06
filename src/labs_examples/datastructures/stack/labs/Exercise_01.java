package labs_examples.datastructures.stack.labs;
import java.util.Stack;

/**
 *      Demonstrate your mastery of Java's built-in Stack class by completing the following:
 *
 *      1) instantiate a new Stack
 *
 *
 *      2) demonstrate the use of EVERY method in the Stack class - there are 5
 */

public class Exercise_01 {
    public static void main(String[] args) {
        Stack<Integer> nums = new Stack<>();

        //1 push()
        nums.push(4);
        nums.push(5);
        nums.push(2);
        nums.push(12);
        nums.push(423);

        //2 pop()
        System.out.println(nums.pop());

        //3 peek()
        System.out.println(nums.peek());

        //4 empty()
        System.out.println(nums.empty());

        //5 size()
        System.out.println(nums.size());

        //It seems there are more than five methods - but the five above seem the most essential to me

    }
}
