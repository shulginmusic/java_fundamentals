package labs_examples.objects_classes_methods.labs.objects;

public class AirplaneTech {
    private String gpsBrand;
    private boolean hasRadio;

    public AirplaneTech(String gpsBrand, boolean hasRadio){
        this.gpsBrand = gpsBrand;
        this.hasRadio = hasRadio;
    }

    public String getGpsBrand() {
        return gpsBrand;
    }

    public void setGpsBrand(String gpsBrand) {
        this.gpsBrand = gpsBrand;
    }

    public boolean isHasRadio() {
        return hasRadio;
    }

    public void setHasRadio(boolean hasRadio) {
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
