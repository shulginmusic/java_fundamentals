package labs_examples.packages.labs.vegetables;

public class Cucumbers {

    String color;
    boolean isHealthy;

    public Cucumbers() {
        this.color = "green";
        this.isHealthy = true;
    }


    protected boolean isHealthy() {
        return isHealthy;
    }

    public String getColor() {
        return color;
    }
}
