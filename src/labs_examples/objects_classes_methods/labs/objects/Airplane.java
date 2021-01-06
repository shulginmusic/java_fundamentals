package labs_examples.objects_classes_methods.labs.objects;

public class Airplane {
    AirplaneEngine engine;
    AirplaneAirline airline;
    AirplaneTech tech;
    AirplanePurpose purpose;
    private String make;
    private int year;
    public int range; //had to make this public for MethodTraining exercise
    private int passengerCapacity;
    private int cruiseSpeed;
    private double fuelCapacity;
    private double currentFuelLevel;

    public Airplane(){

    }

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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(int cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    public AirplaneEngine getEngine() {
        return engine;
    }

    public void setEngine(AirplaneEngine engine) {
        this.engine = engine;
    }

    public AirplaneAirline getAirline() {
        return airline;
    }

    public void setAirline(AirplaneAirline airline) {
        this.airline = airline;
    }

    public AirplaneTech getTech() {
        return tech;
    }

    public void setTech(AirplaneTech tech) {
        this.tech = tech;
    }

    public AirplanePurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(AirplanePurpose purpose) {
        this.purpose = purpose;
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
