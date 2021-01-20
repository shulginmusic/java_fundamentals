package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Language extends LanguageFamily{
    String name;
    int speakers;
    public Language(boolean hasAlphabet, boolean isAlive,
                    String FamilyName, int languagesInGroup,
                    String languageName, int speakers) {
        super(hasAlphabet, isAlive, FamilyName, languagesInGroup);
        this.name = languageName;
        this.speakers = speakers;
    }

    @Override
    public void languageStatement() {
        System.out.println("I speak " + name + " and about " + speakers +
                " other people speak it");

    }

}
