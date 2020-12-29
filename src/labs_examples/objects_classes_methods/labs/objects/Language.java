package labs_examples.objects_classes_methods.labs.objects;

import java.util.Arrays;

public class Language {
    int speakers;
    String mostPopularCountry;
    String[] countries;
    boolean hasAlphabet;

    //first constructor
    public Language(){};

    //second constructor
    public Language(int speakers, String mostPopularCountry){
        this.speakers = speakers;
        this.mostPopularCountry = mostPopularCountry;
    }

    //third constructor
    public Language(int speakers, String mostPopularCountry, String[] countries,
                    boolean hasAlphabet){
        this.speakers = speakers;
        this.mostPopularCountry = mostPopularCountry;
        this.countries = countries;
        this.hasAlphabet = hasAlphabet;
    }

    public void setSpeakers(int speakers) {
        this.speakers = speakers;
    }

    public void setMostPopularCountry(String mostPopularCountry) {
        this.mostPopularCountry = mostPopularCountry;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public void setHasAlphabet(boolean hasAlphabet) {
        this.hasAlphabet = hasAlphabet;
    }

    @Override
    public String toString() {
        return "Language{" +
                "speakers=" + speakers +
                ", mostPopularCountry='" + mostPopularCountry + '\'' +
                ", countries=" + Arrays.toString(countries) +
                ", hasAlphabet=" + hasAlphabet +
                '}';
    }
}
