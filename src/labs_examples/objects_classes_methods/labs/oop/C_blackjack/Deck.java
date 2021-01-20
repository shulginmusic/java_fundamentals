package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    Card[] cards;
    ArrayList<Integer> usedCards = new ArrayList<Integer>();
    char[] suitArr = {'♠', '♦', '♥', '♣'};
    String[] cardValues = {
            "",
            "Ace",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "Jack",
            "Queen",
            "King"
    };

    //Spades = 0
    //Diamonds = 1
    //Hearts = 2
    //Clubs = 3

    public Deck() {
        this.cards = new Card[52];
    }


    public void populateDeck() {
        int cardValue = 1;
        int suitNumber = 0;
        for (int i = 0; i < cards.length; i++) {
            Card someCard = new Card(suitArr[suitNumber],cardValues[cardValue]);
            this.cards[i] = someCard;
            cardValue++;
            if (cardValue > 13) {
                suitNumber++;
                cardValue = 1;
            }
        }
    }

    public void deal(Player player) {
        Random random = new Random();
        int randomCardIndex;
        do {
            randomCardIndex = random.nextInt(cards.length);
        } while (usedCards.contains(randomCardIndex));
        Card randomCard = cards[randomCardIndex];
        player.hand.cards.add(randomCard);
        usedCards.add(randomCardIndex);
    }



    @Override
    public String toString() {
        return Arrays.toString(cards);

    }
}
