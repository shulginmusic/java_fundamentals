package labs_examples.objects_classes_methods.labs.methods;

import labs_examples.objects_classes_methods.labs.objects.Airplane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MethodTraining {
    //1) Demonstrate method overloading in this class

    public static int sumOf(int a, int b) {
        return a + b;
    }

    public static int sumOf(int a, int b, int c) {
        return a + b + c;
    }

    //2) Demonstrate the difference between "pass by value" and "pass by reference"

    public static void main(String[] args) {
        //pass by value
        int z = 5;
        System.out.println("z before addFivemethod(): " + z);
        System.out.println(addFive(z));
        System.out.println("z after addFivemethod(): " + z);

        //pass by reference
        Airplane piper = new Airplane();
        piper.setRange(300);

        System.out.println("Piper range before addFive() method: " + piper.range);
        //Let's now apply the addFive() method to piper.range
        addFive(piper);
        System.out.println("Piper range after addFive() method: " + piper.range);
        System.out.println("The range value is now changed");
        //largest of four
        System.out.println();
        System.out.println(largestOfFour(4,678 ,9,3));
        //count consonants in a String
        System.out.println();
        numberOfConsonants("TEST");
        numberOfConsonants("Apple");
        numberOfConsonants("San Francisco");
        //determine if a number is prime
        System.out.println();
        System.out.println(isPrime(2));
        //find highest and lowest numbers in array
        int[] numbers= {1000, 50, 100, 150, 200, 250};
        System.out.println(Arrays.toString(highestAndLowest(numbers)));
        //Nums divisible by both
        System.out.println();
        ArrayList<Integer> someNums = numsDivisibleByBoth(1000,3,5);
        System.out.println(someNums.toString());
        //Reverse array
        System.out.println();
        int[] moreNums = {1, 5, 10, 15, 20};
        System.out.println(Arrays.toString(reverseIntArr(moreNums)));

        numberOfConsonants("TEST!!!");






    }

    public static int addFive(int a) {
        a += 5;
        return a;
    }

    public static void addFive(Airplane airplane) {
        airplane.range += 5;
    }

    //3) Create a method that will return the largest of 4 numbers (all of which are passed in as arguments)

    public static int largestOfFour(int a, int b, int c, int d) {
        int[] nums = {a, b, c, d};
        int largest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (largest < nums[i]) {
                    largest = nums[i];
            }
        }
        return largest;
    }

    //4) Write a method to count all consonants (the opposite of vowels) in a String

    public static void numberOfConsonants(String s) {
        int count = 0;
        String vowels = "aeiou ";
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i)).toLowerCase(Locale.ROOT);
            if (Character.isLetter(s.charAt(i))) {
                if (!vowels.contains(c)) {
                    count++;
                }
            }
        }
//        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w',
//        'x', 'y', 'z'};//y is usually a consonant
//        String lowerS = s.toLowerCase(Locale.ROOT);
//        System.out.println(lowerS);
//        int consCount = 0;
//        for (char c : consonants) {
//            for (int i = 0; i < lowerS.length(); i++) {
//                if (c == lowerS.charAt(i)) {
//                    consCount++;
//                }
//            }
//        }
        System.out.println("Number of consonants in " + s + ": " + count);
    }

    //    5) Write a method that will determine whether or not a number is prime
    //In math, prime numbers are whole numbers greater than 1,
    // that have only two factors – 1 and the number itself.
    //Prime numbers are divisible only by the number 1 or itself.

    public static boolean isPrime(int x) {
        boolean isNumPrime = true;
        if (x <= 1) {
             isNumPrime = false;
        } else {
            for (int i = 2; i < x; i++) {
                if (x % 2 == 0) {
                    isNumPrime = false;
                    break; //but why break here?
                }
            }
        }
        return isNumPrime;
    }

    //6) Write a method that will return a small array containing the highest and lowest numbers in a given numeric
    // array,which is passed in as an argument
    public static int[] highestAndLowest(int[] nums) {
        //find largest
        int largest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (largest < nums[i]) {
                largest = nums[i];
            }
        }
        //find lowest
        int lowest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (lowest > nums[i]) {
                lowest = nums[i];
            }
        }
        //create small array
        int[] highestAndLowestArr = {lowest, largest};
        return highestAndLowestArr;

    }

    //7) Write a method that takes 3 arguments (int maxNum, int divisor1, int divisor2) and returns an Integer
    // Arraylist.
    //        In this method create an Integer ArrayList and populate it with each number between zero and maxNum
    //        that is divisible by both divisor1 and divisor2. Then return this ArrayList. After calling this method, print
    //        out the
    //        length of the returned list

    public static ArrayList<Integer> numsDivisibleByBoth(int maxNum, int divisor1, int divisor2) {
        ArrayList<Integer> numsDivisibleByBothArr = new ArrayList<Integer>();
        for (int i = 0; i <= maxNum; i++) {
            if ((i % divisor1 == 0) && (i % divisor2 == 0)) {
                numsDivisibleByBothArr.add(i);
            }
        }
        return numsDivisibleByBothArr;
    }

    //8) Write a method that will reverse an array in place use only one extra temp variable. For this exercise you
    // cannot instantiate a second array. You must reverse the array in place using only one extra temp variable.
    // Hint: this variable is used to temporarily store individual values in the array

    public static int[] reverseIntArr(int[] numArr) {
        int temp;
        for (int i = 0; i < numArr.length / 2; i++) {
            temp = numArr[i];
            numArr[i] = numArr[numArr.length - 1 - i];
            numArr[numArr.length - 1 - i] = temp;
        }
        return numArr;
    }









}
