package labs_examples.enumerations.labs;

public class ContinentsController {
    public static void main(String[] args) {
        Continents myContinent = Continents.NORTH_AMERICA;

        System.out.println("My continent is : " + myContinent);

        System.out.println("Here is a list of all continents: ");

        for (Continents continent : Continents.values()) {
            System.out.println(continent);
        }
    }
}
