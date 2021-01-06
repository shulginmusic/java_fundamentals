package labs_examples.objects_classes_methods.labs.objects;

public class AirplanePurpose {
    private boolean isCivil;
    private boolean isMilitary;

    public AirplanePurpose(boolean isCivil, boolean isMilitary){
        this.isCivil = isCivil;
        this.isMilitary = isMilitary;
    }

    public boolean isCivil() {
        return isCivil;
    }

    public void setCivil(boolean civil) {
        isCivil = civil;
    }

    public boolean isMilitary() {
        return isMilitary;
    }

    public void setMilitary(boolean military) {
        isMilitary = military;
    }

    @Override
    public String toString() {
        return "AirplanePurpose{" +
                "isCivil=" + isCivil +
                ", isMilitary=" + isMilitary +
                '}';
    }
}
