package labs_examples.input_output.labs;

public class City {

    private String name;
    private String country;
    private int established;
    private long population;


    public City() {
    }

    public City (String name, String country,
                 int established, long population) {
        this.name = name;
        this.country = country;
        this.established = established;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setCityName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getEstablished() {
        return established;
    }

    public void setEstablished(int established) {
        this.established = established;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", established=" + established +
                ", population=" + population +
                '}';
    }
}
