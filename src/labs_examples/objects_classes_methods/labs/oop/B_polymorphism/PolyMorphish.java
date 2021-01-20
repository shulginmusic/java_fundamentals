package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class PolyMorphish {
    public static void main(String[] args) {
        //Overloading
        greetUser("efim");
        greetUser("efim", "shulgin");
        //Overriding
        QueenElizabethII theQueen = new QueenElizabethII();
        theQueen.greeting();
        PrinceCharles thePrince = new PrinceCharles();
        thePrince.greeting();




    }
    // Demonstrate the three forms of Polymorphism:
    //    - Overloading
    //    - Overriding
    //    - Interfaces

    //Overloading
    public static void greetUser(String firstName) {
        String firstNameCapitalized = capitalizeWord(firstName);
        System.out.println("Hello, " + firstNameCapitalized);
    }
    public static void greetUser(String firstName, String lastName) {
        String firstNameCapitalized = capitalizeWord(firstName);
        String lastNameCapitalized = capitalizeWord(lastName);
        System.out.println("Hello, " + firstNameCapitalized + " " + lastNameCapitalized);
    }

    public static String capitalizeWord(String word) {
        char c = word.charAt(0);
        c = Character.toUpperCase(c);
        String wordCapitalized = word.replace(word.charAt(0), c);
        return wordCapitalized;
    }

    //Overriding

    private static class QueenElizabethII implements Royalty{
        int age;
        @Override
         public void greeting() {
             System.out.println("Her majesty the Queen!");
         }
        @Override
         public boolean isFirstHeir() {
             return true;
         }


    }
    private static class PrinceCharles extends QueenElizabethII {
        int age;

        @Override
        public void greeting() {
            System.out.println("His royal highness Prince Charles!");
        }
    }

    private static interface Royalty {
        public void greeting();
        public boolean isFirstHeir();

    }






}
