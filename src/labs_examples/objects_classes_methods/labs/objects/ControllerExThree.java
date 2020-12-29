package labs_examples.objects_classes_methods.labs.objects;

public class ControllerExThree {
    public static void main(String[] args) {
        Language mayan = new Language();
        Language english = new Language(1500000000,
                "USA");
        String[] countriesMandarin = {"china", "singapore", "taiwan"};
        Language mandarin = new Language(917000000, "china",
                countriesMandarin, false);

        String[] countriesMayan = {"mexico", "guatemala", "belize"};
        mayan.setCountries(countriesMayan);
        System.out.println(mayan.toString());
    }
}
