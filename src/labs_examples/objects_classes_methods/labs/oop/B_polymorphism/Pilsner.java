package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;
//interface
interface Beer {
    public void drink();

    public double getAlcoholContent();

    public String getCountryOfOrigin();
}

public class Pilsner implements Beer {
    double alcoholContent;
    String country;
    public Pilsner(double alcoholContent, String country) {
        this.alcoholContent = alcoholContent;
        this.country = country;
    }
    public void drink() {
        System.out.println("I am drinking Pilsner");
    }

    public double getAlcoholContent() {
        return alcoholContent;
    }

    public String getCountryOfOrigin() {
        return country;
    }
}
