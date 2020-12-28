package labs_examples.arrays.labs;

/**
 *  Traversing Arrays Backwards
 *
 *      Please create and populate an array of your choosing. Then, please demonstrate how to print out every other
 *      element in the array in reverse order.
 *
 */

public class Exercise_05 {
    public static void main(String[] args) {
        //Initialize the array
        char [] myName = new char [4];
        //populate + print

        for (int i = 0; i < myName.length; i++){
            String name = "Efim";
            char letter = name.charAt(i);
            myName[i] = letter;
            System.out.print(myName[i] + " ");
        }
    }

}
