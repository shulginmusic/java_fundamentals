package labs_examples.enumerations.labs;

public enum Transportation {
    CAR(15.4), SCOOTER(50.0), BOAT (8.34), AIRPLANE(10.5);

    private final double mpg;
    Transportation(double mpg) {
        this.mpg = mpg;
    }

    public double getMpg() {
        return mpg;
    }
}
