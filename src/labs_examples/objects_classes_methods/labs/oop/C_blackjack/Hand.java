package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards = new ArrayList<Card>();
    int handValue = getHandScore();

    public int getHandScore() {
        int score = 0;
        boolean hasAce = false;
        for (Card card : cards) {
            switch (card.cardValue) {
                case "Jack":
                case "Queen":
                case "King":
                    score += 10;
                    break;
                case "Ace":
                    score += 11;//unless otherwise
                    hasAce = true;
                    break;
                default:
                    score += Integer.parseInt(card.cardValue);
                    break;
            }
        }
        if (score > 21 && hasAce) {
            score -= 10;
        }
        return score;
    }

    public boolean isOver21() {
        return (getHandScore() > 21);
    }
}
