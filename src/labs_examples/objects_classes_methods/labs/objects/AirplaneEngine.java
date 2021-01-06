package labs_examples.objects_classes_methods.labs.objects;

public class AirplaneEngine {
    private String make;
    private int year;
    private int horsepower;
    private boolean isTurbo;

    public AirplaneEngine(String make, int year, boolean isTurbo,
    int horsepower){
        this.make = make;
        this.year = year;
        this.horsepower = horsepower;
        this.isTurbo = isTurbo;
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

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public boolean isTurbo() {
        return isTurbo;
    }

    public void setTurbo(boolean turbo) {
        isTurbo = turbo;
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
