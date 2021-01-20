package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class LanguageController {
    public static void main(String[] args) {
        //First in hierarchy
        LanguageCommunication someLanguage = new LanguageCommunication(true, true);
        someLanguage.languageStatement();
        //Second in hierarchy
        LanguageFamily indoEuropean = new LanguageFamily(true, true, "Indo-European",
                445);
        indoEuropean.languageStatement();
        //Third in hierarchy
        Language russian = new Language(true, true, "Indo-European",
                445, "Russian", 258000000);
        russian.languageStatement();

    }
}
