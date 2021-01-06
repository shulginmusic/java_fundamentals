package labs_examples.objects_classes_methods.labs.objects;

public class AirplaneController {
    public static void main(String[] args) {
        Airplane tripleSeven = new Airplane();
        //example
        tripleSeven.setMake("Boeing");
        System.out.println(tripleSeven.getMake());

        //Set primitive data types/instance vars
        tripleSeven.setCruiseSpeed(500);
        tripleSeven.setCurrentFuelLevel(65.0);
        tripleSeven.setYear(2005);
        tripleSeven.setRange(800);
        tripleSeven.setPassengerCapacity(300);
        tripleSeven.setFuelCapacity(300.0);
        //create + set objects
        //Airplane engine
        AirplaneEngine rollsRoyce = new AirplaneEngine("rolls royce",
                2005, true, 1000);
        AirplaneAirline southWest = new AirplaneAirline("Southwest",
                "USA");
        AirplaneTech boeingTech = new AirplaneTech("garmin", true);
        AirplanePurpose tripleSevenPurpose = new AirplanePurpose(true, false);

        tripleSeven.setEngine(rollsRoyce);
        tripleSeven.setAirline(southWest);
        tripleSeven.setPurpose(tripleSevenPurpose);
        tripleSeven.setTech(boeingTech);

        //To string method

        System.out.println(tripleSeven.toString());

    }
}
