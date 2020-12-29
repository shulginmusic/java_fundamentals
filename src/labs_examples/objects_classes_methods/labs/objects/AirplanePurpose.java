package labs_examples.objects_classes_methods.labs.objects;

public class AirplanePurpose {
    boolean isCivil;
    boolean isMilitary;

    public AirplanePurpose(boolean isCivil, boolean isMilitary){
        this.isCivil = isCivil;
        this.isMilitary = isMilitary;
    }

    @Override
    public String toString() {
        return "AirplanePurpose{" +
                "isCivil=" + isCivil +
                ", isMilitary=" + isMilitary +
                '}';
    }
}
