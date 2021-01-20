package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class LanguageCommunication {
    private boolean hasAlphabet;
    private boolean isAlive;

    public LanguageCommunication(boolean hasAlphabet, boolean isAlive) {
        this.hasAlphabet = hasAlphabet;
        this.isAlive = isAlive;
    }
    public void languageStatement() {
        if (isAlive) {
            System.out.println("I speak a language that's alive!");
        } else {
            System.out.println("I speak a dead language!");
        }
        if (hasAlphabet) {
            System.out.println("My language has an alphabet!");
        } else {
            System.out.println("My language doesn't have an alphabet!");
        }

    }


}
