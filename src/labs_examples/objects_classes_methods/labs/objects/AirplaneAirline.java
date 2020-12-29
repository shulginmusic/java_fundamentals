package labs_examples.objects_classes_methods.labs.objects;

public class AirplaneAirline {
    String airlineName;
    String country;

    public AirplaneAirline(String airlineName, String country){
        this.airlineName = airlineName;
        this.country = country;
    }

    @Override
    public String toString() {
        return "AirplaneAirline{" +
                "airlineName='" + airlineName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
