package labs_examples.arrays.labs;

/**
 *  Irregular Arrays
 *
 *      Create and populate a 2 dimensional irregular array of size and contents of your choosing. Using a nested
 *      "for-each" loop, iterate and print out each element of the array.
 *
 */

public class Exercise_04 {
    public static void main(String[] args) {
        //Declare an irregular array
        String [] [] cars = {
                {"bmw", "mercedes", "audi"},
                {"toyota", "honda"},
                {"chevrolet", "ford", "gmc", "buick"},
                {"lada", "volga"},
        };
        //print out array contents using a nested for-each loop
        for (String[] countries : cars) {
            for (String y : countries){
                System.out.print(y + " - ");
            }
            System.out.println();
        }
    }

}
