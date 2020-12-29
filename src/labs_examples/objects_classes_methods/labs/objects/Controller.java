package labs_examples.objects_classes_methods.labs.objects;

import com.sun.xml.internal.ws.util.StringUtils;

public class Controller {
    public static void main(String[] args) {
        City sanFrancisco = new City("USA", false, 883000);
        Resident efim = new Resident("Efim", "Shulgin",
                26, false);//not yet, but engaged!
        System.out.println(efim.name + " " + efim.lastName + " lives in a city with a population" +
                " of " + sanFrancisco.population);
        //Airplanes!
        //Create the "smaller" objects
        AirplaneEngine continentalO300 = new AirplaneEngine("continental",
                1970, false, 160);
        AirplaneAirline shulginAir = new AirplaneAirline("shulginAir",
                "USA");
        AirplaneTech tech = new AirplaneTech("garmin", true);
        AirplanePurpose purpose = new AirplanePurpose(true, false);
        //Create the big object
        Airplane cessna172 = new Airplane(continentalO300, shulginAir, tech,
                purpose, 1970, 736, 4,
                110, 39.0, 25.0);

        System.out.println(cessna172.toString());
    }
}
