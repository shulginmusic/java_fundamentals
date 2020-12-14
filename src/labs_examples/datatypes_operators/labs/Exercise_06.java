package labs_examples.datatypes_operators.labs;

/**
 * Fundamentals Exercise 4: Volume and Surface Area
 *
 *      Write the necessary code to calculate the volume and surface area of a cylinder
 *      with a radius of 3.14 and a height of 5. Print out the result.
 *
 */

public class Exercise_06 {

    public static void main(String[] args) {

        //Source: https://www.wikihow.com/Calculate-the-Volume-of-a-Cylinder
        double pi = 3.14159265359;
        double radius = 3.14;
        double height = 5.0;

        double surfaceArea = pi * (radius * radius); //Circular area formula is A = Pi * (r*r)
         //I wonder why there is no exponent operator in Java??
        float surfaceAreaRoughly = (float)surfaceArea;
        System.out.println("The surface area of the cylinder is "
         + surfaceAreaRoughly);
        //Volume = area * height
        double volume = surfaceArea * height;
        float volumeRoughly = (float) volume;
        System.out.println("The volume of the cylinder is " 
        	+ volumeRoughly);



        // want to convert to two decimal places, but how? Here is what I found on stackoverflow:
        //https://stackoverflow.com/questions/8779659/convert-a-number-to-2-decimal-places-in-java
//        double angle = 20.3034;

//        DecimalFormat df = new DecimalFormat("#.00");
//        String angleFormated = df.format(angle);
//        System.out.println(angleFormated); //output 20.30
        


    }
}