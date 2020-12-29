package labs_examples.objects_classes_methods.labs.objects;

public class AirplaneTech {
    String gpsBrand;
    boolean hasRadio;

    public AirplaneTech(String gpsBrand, boolean hasRadio){
        this.gpsBrand = gpsBrand;
        this.hasRadio = hasRadio;
    }

    @Override
    public String toString() {
        return "AirplaneTech{" +
                "gpsBrand='" + gpsBrand + '\'' +
                ", hasRadio=" + hasRadio +
                '}';
    }
}
