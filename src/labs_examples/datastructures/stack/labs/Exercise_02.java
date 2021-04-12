package labs_examples.datastructures.stack.labs;

/**
 *      Stacks - Exercise_02
 *
 *      Write a new custom (Generic) Stack class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Stack class must also do the following: (Ryan Take 2)
 *
 *      1) throw a custom exception when trying to pop an element from an empty Stack
 *      2) resize the Stack (the underlying array) to be twice the size when the Stack is more than 3/4 full
 *      3) resize the Stack (the underlying array) to be half the size when the Stack is more than 1/4 empty
 *      4) contain the methods peekFirst() and peekLast()
 *      5) contain a size() method
 *      6) contain a method to print out the data of all elements in the Stack
 *
 *      TIP: To initialize an new array of a Generic type you can use this:
 *           Object[] data = (T[]) new Object[10];
 */

public class Exercise_02 {
    //Thanks to Youtube Channel Brandon Grasley https://youtu.be/Fccje3W6oBk
    public static void main(String[] args) throws StackEmptyException {
        //Stack with a set, final size:
        MyStack<String> colors = new MyStack<>();

        //Let's add some colors
        colors.push("Green");
        colors.push("Blue");
        colors.push("Red");
        colors.push("Orange");
        colors.push("Purple"); //Last in


        //Peek Methods
        System.out.println(colors.peekFirst()); //First out
        System.out.println(colors.peekLast()); //First in, Last out
        //Print out contents of stack
        colors.printStackData();
        //Get size of stack:
        System.out.println("Stack size: " + colors.size());
        //pop method
        String color = colors.pop();
        //size after popping:
        System.out.println("Stack size after .pop(): " + colors.size());

        //Search the stack for a value
        System.out.print("Searching for value Red:");
        System.out.println(" distance from top of the stack = " + colors.search("Red"));

        //Clear out the stack:
        colors.clear();
        System.out.println("Stack size after clear(): " + colors.size());

//        //Throw custom exception when trying to peek / pop empty stack
//        System.out.println(colors.peekFirst());

        System.out.println("----------------INTERNAL RESIZING DEMONSTRATION----------------");

        //Let's see how the internal resizing works
        MyStack<Integer> nums = new MyStack<>();
        //Follow the current underlying array length:
        for (int i = 0; i < 50; i++) {
            nums.push(i);
            nums.printStackData();
        }

        //Now let's downsize by going backwards...
        System.out.println("----------------INTERNAL DOWNSIZING DEMONSTRATION----------------");
        for (int i = 50; i >= 2; i--) {
            nums.pop();
            nums.printStackData();
        }

        //Bonus cool thing I saw on the internet:
        // Again, Thanks to Youtube Channel Brandon Grasley https://youtu.be/Fccje3W6oBk
        System.out.println("----------------STACK COMPRESSION DEMONSTRATION----------------");
        MyStack<String> animals = new MyStack<>();

        animals.push("Elephant");
        animals.push("Dog");
        animals.push("Cat");
        animals.push("Giraffe");
        animals.push("Hippo");
        animals.push("Parrot");
        animals.push("Racoon");
        animals.push("Eagle");
        animals.push("Whale");

        //Look at underlying array length before and after compression...
        animals.printStackData();
        animals.compress();
        animals.printStackData();
    }
}
