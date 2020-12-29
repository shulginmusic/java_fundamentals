package labs_examples.objects_classes_methods.labs.objects;

public class Airplane {
    AirplaneEngine engine;
    AirplaneAirline airline;
    AirplaneTech tech;
    AirplanePurpose purpose;
    String make;
    int year;
    int range;
    int passengerCapacity;
    int cruiseSpeed;
    double fuelCapacity;
    double currentFuelLevel;

    public Airplane(AirplaneEngine engine, AirplaneAirline airline,
                    AirplaneTech tech, AirplanePurpose purpose,
                    int year, int range, int passengerCapacity,
                    int cruiseSpeed, double fuelCapacity,
                    double currentFuelLevel){
        //Objects
        this.engine = engine;
        this.airline = airline;
        this.tech = tech;
        this.purpose = purpose;
        //Primitive types
        this.year = year;
        this.range = range;
        this.passengerCapacity = passengerCapacity;
        this.cruiseSpeed = cruiseSpeed;
        this.fuelCapacity = fuelCapacity;
        this. currentFuelLevel = currentFuelLevel;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "\nengine=" + engine.toString() +
                ", \nairline=" + airline.toString() +
                ", \ntech=" + tech.toString() +
                ", \npurpose=" + purpose.toString() +
                '}';
    }
}
