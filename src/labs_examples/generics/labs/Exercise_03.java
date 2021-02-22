package labs_examples.generics.labs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Generics Exercise 3:
 *
 *      1) Write a generic method that accepts two generic arguments. This generic method should only accept
 *      arguments which are sublasses of Number. The generic method must return the sum (as a double) of whatever two
 *      numbers were passed in regardless of their type.
 *
 *      2) Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes
 *
 *      3) Write a generic method to exchange the positions of two different elements in an array.
 *
 *      4) Write a generic method to find the largest element within the range (begin, end) of a list.
 *
 */

public class Exercise_03 {
    // 1
    public static <N extends Number> double returnSumOfTwo(N num1, N num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    //2 Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes
    public static <T> int qtyOfPalindromes(Collection<T> collection) {

        int qty = 0;
        for (T t : collection) {
            //Convert t to string
            String s = t.toString();
            //Create a reverse variable and use StringBuilder to reverse s
            String reverse = new StringBuilder(s).reverse().toString();
            if (s.equals(reverse)) {
                qty++;
            }
        }
        return qty;
    }

    //3 Write a generic method to exchange the positions of two different elements in an array.

    public static <E> void changePositionInArray(E[] array, int indexOne, int indexTwo) {
        E e1 = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = e1;
    }

    //4) Write a generic method to find the largest element within the range (begin, end) of a list.

    public static <E extends Number> void largestElement (List<E> list) {
        if (list.size() == 0) {
            System.out.println("No elements in list");
            return;
        }
        E item = list.get(0);
        if (list.size() <= 1) {
            System.out.println(item);
        } else {

            for (E e : list) {
                if (item.doubleValue() < e.doubleValue()) {
                    item = e;
                }
            }
            System.out.println(item);
        }
    }


    public static void main(String[] args) {
        //1
        System.out.println(returnSumOfTwo(1.67, 3));

        //2
        ArrayList<String> words = new ArrayList<>();
        words.add("efim");
        words.add("agniia");
        words.add("bob");
        words.add("mom");
        System.out.println(qtyOfPalindromes(words));

        //3
        Object[] myInfo = {"Efim", "Shulgin", 26};
        //print out array in current order
        for (Object obj : myInfo) {
            System.out.print(obj + " | ");
        }
        //now change the order of things
        changePositionInArray(myInfo, 0, 2);
        //print out array in new order
        System.out.println();
        for (Object obj : myInfo) {
            System.out.print(obj + " | ");
        }

        // 4) Write a generic method to find the largest element within the range (begin, end) of a list.
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(44);
        nums.add(556);
        System.out.println();
        largestElement(nums);
    }
}