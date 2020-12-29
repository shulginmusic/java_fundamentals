package labs_examples.objects_classes_methods.labs.objects;

public class AirplaneEngine {
    String make;
    int year;
    int horsepower;
    boolean isTurbo;

    public AirplaneEngine(String make, int year, boolean isTurbo,
    int horsepower){
        this.make = make;
        this.year = year;
        this.horsepower = horsepower;
        this.isTurbo = isTurbo;
    }

    @Override
    public String toString() {
        return "AirplaneEngine{" +
                "make='" + make + '\'' +
                ", year=" + year +
                ", isTurbo=" + isTurbo +
                '}';
    }
}
