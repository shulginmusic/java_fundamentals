package labs_examples.objects_classes_methods.labs.objects;

public class AirplaneAirline {
    private String airlineName;
    private String country;

    public AirplaneAirline(String airlineName, String country){
        this.airlineName = airlineName;
        this.country = country;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
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
