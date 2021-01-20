package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class LanguageFamily extends LanguageCommunication {
    private String LanguageFamilyName;
    private int approxNumOfLanguages;

    public LanguageFamily(boolean hasAlphabet, boolean isAlive, String name, int languages) {
        super(hasAlphabet, isAlive);
        this.LanguageFamilyName = name;
        this.approxNumOfLanguages = languages;
    }
    @Override
    public void languageStatement() {
        System.out.println("I speak a language from the " + LanguageFamilyName +
                " family that also has approximately " + approxNumOfLanguages +
                " other languages");
    }
}
