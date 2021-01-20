package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Arrays;

public class Card {

    char suit;
    String cardValue;

    public Card(char suit, String cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }


    @Override
    public String toString() {
        return "Card{" +
                ", \nsuit=" + suit +
                ", \ncardValue=" + cardValue +
                '}';
    }
}
