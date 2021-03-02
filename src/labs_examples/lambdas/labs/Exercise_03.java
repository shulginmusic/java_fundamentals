package labs_examples.lambdas.labs;

import java.util.function.Predicate;

/**
 * Lambdas Exercise 3:
 *
 *      1) Demonstrate the use of a static method reference
 *      2) Demonstrate the use of an instance method reference
 *      3) Demonstrate the use of a constructor reference
 *
 */

public class Exercise_03 {
    public static void main(String[] args) {
//      1) Demonstrate the use of a static method reference
        Predicate<Integer> staticMethodReference = Exercise_03 :: divisibleBy3;
        System.out.println(staticMethodReference.test(56));

//      2) Demonstrate the use of an instance method reference
        RandomClassForDemonstration obj = new RandomClassForDemonstration();
        Predicate<Integer> instanceMethodReference = obj :: divisibleBy3;
        System.out.println(instanceMethodReference.test(99));

//        3) Demonstrate the use of a constructor reference
        TeaInterface teaCreator = Tea :: new; //Technically, "new" is sorta like a method, since a constructor
        //is sort of like a method... weird way to create an object to say the least
        Tea puErh = teaCreator.createTea("black", "Pu Erh");
        System.out.println(puErh.toString());



    }

    static boolean divisibleBy3(int i) {
        return i % 3 == 0;
    }


}

//Create simple POJO

class Tea {
    String type;
    String name;

    public Tea(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

//Create Interface

interface TeaInterface {
    Tea createTea(String type, String name);
}


//This is for Instance Method Reference demonstration
class RandomClassForDemonstration {
    boolean divisibleBy3(int i) {
        return i % 3 == 0;
    }
}