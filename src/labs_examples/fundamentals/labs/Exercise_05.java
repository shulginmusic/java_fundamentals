package labs_examples.fundamentals.labs;


/**
 * Fundamentals Exercise 5: Working with Strings
 *
 *      Please follow the instructions in the comments below
 *
 */

public class Exercise_05 {

    public static void main(String[] args) {

        String str = "hello!";
        // please declare an int variable below, and set it to the value of the length of "str"
        int strLength;
        strLength = str.length();

        String str2 = "hello";
        // please initialize a boolean variable and test whether str is equal to str2
        boolean isStrEqual;
        isStrEqual = str.equals(str2);
//        System.out.println(isStrEqual);
        

        // please concatenate str & str2 and set the result to a new String variable below

        String newStr;
        newStr = str + str2;
//        System.out.println(newStr);
        

        // please demonstrate the use of any other method that is available to us in the String class
        // for example, replace(), substring(), contains(), indexOf() etc

        //.replace() = replace any char in a string with a new char
        String river, new_river;

        river = "mississippi";
        new_river = river.replace('s', 'l');
        System.out.println(new_river);


        //charAt() returns a char from a string using an index

        System.out.println(river.charAt(0));

        //Using substring() method to extract characters from a string. The first argument is the starting point
        //whereas the second one is the number of chars to extract
        System.out.println(river.substring(0, 4));
    }
}




















