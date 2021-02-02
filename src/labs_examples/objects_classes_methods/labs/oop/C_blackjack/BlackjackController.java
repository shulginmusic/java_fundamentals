package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackjackController {
    public static void main(String[] args) {
        playBlackJack();
    }

    public static void playBlackJack() {
        MoneyJar moneyJar = new MoneyJar();
        //Create a computer and a human player
        Scanner newScanner = new Scanner(System.in);
        Player humanPlayer = new Player(moneyJar);
        //Ask for player's name
        System.out.print("Hello, what's your name? ");
        humanPlayer.name = newScanner.next();
        //Create and assign name to computer
        Player computerPlayer = new Player(moneyJar);
        computerPlayer.name = "Computer";
        //Create and populate deck
        Deck newDeck = new Deck();
        newDeck.populateDeck();
        boolean quitGame = false;

        do {
            //Ask how much the player would like to bet
            int bet = 0;
            do {
                if (humanPlayer.getPotValue() < bet) {
                    System.out.println("You don't have enough money to bet this amount");
                }
                if (computerPlayer.getPotValue() < bet) {
                    System.out.println("The computer doesn't have enough money to bet this amount");
                }
                System.out.print(humanPlayer.name + ", you currently have " + humanPlayer.potValue + " dollars.");
                System.out.print("\nHow much would you like to bet? (5/10/20/50/100) ");
                boolean invalidInput;
                do {
                    invalidInput = false;
                    try {
                        bet = newScanner.nextInt();
                    } catch (InputMismatchException e) {
                        invalidInput = true;
                        System.out.println("Invalid input, please try again...");
                        newScanner.nextLine();
                    }
                } while (invalidInput);


            } while((humanPlayer.getPotValue() < bet) || (computerPlayer.getPotValue() < bet) || !checkBet(bet));

            humanPlayer.betMoney(bet);
            computerPlayer.betMoney(bet);

            //Deal each player two cards
            for (int i = 0; i < 2; i++) {
                newDeck.deal(humanPlayer);
                newDeck.deal(computerPlayer);
            }
            //Let the player know what cards they have
            System.out.println(humanPlayer.name + ", you have the following cards: ");
            for (Card card : humanPlayer.hand.cards) {
                System.out.println(card.cardValue + " of " + card.suit);
            }
            //Let them know what their current hand value is
            System.out.println("Your current hand value is " + humanPlayer.hand.getHandScore());
            //Keep playing
            String humanReply;
            do {
                System.out.print("\nWould you like another card? (y/n)");
                humanReply = newScanner.next();
                if (humanReply.equals("y")) {
                    newDeck.deal(humanPlayer);
                    System.out.println("-------------\n" + humanPlayer.name + ", you have the following cards: ");
                    for (Card card : humanPlayer.hand.cards) {
                        System.out.println(card.cardValue + " of " + card.suit);
                    }
                    //Let them know what their current hand value is
                    System.out.println("Your current hand value is " + humanPlayer.hand.getHandScore());
                }
                if (computerPlayer.computerAI()) {
                    System.out.println("\nThe computer took another card!");
                    newDeck.deal(computerPlayer);
                }
            } while ((computerPlayer.computerAI() || humanReply.equals("y")) &&
                    (!computerPlayer.hand.isOver21()) && (!humanPlayer.hand.isOver21()));
            //So who won?!
            System.out.println("\n-------------------\nRound is over!");
            //Let the player know what cards they have
            System.out.println("-------------\n" + humanPlayer.name + ", you have the following cards: ");
            for (Card card : humanPlayer.hand.cards) {
                System.out.println(card.cardValue + " of " + card.suit);
            }
            //Let them know what their final hand value is
            System.out.println("Your final hand value is " + humanPlayer.hand.getHandScore());

            //COMPUTER PART
            //Let the player know what the computer has
            System.out.println("\nThe computer has the following cards: ");
            for (Card card : computerPlayer.hand.cards) {
                System.out.println(card.cardValue + " of " + card.suit);
            }
            //Let them know what the computer's final hand value is
            System.out.println("The computer's final hand value is " + computerPlayer.hand.getHandScore());
            //determine who wins and distribute bets
            determineWinner(moneyJar, humanPlayer, computerPlayer);
            //Let the players know how much money each now has
            System.out.println(humanPlayer.name + ", you have " + humanPlayer.potValue + " dollars.");
            System.out.println("The computer has " + computerPlayer.potValue + " dollars.");
            //Quit if one is out of money
            if (humanPlayer.getPotValue() <= 0 || computerPlayer.getPotValue() <= 0) {
                System.out.println("\nGAME OVER DUE TO LACK OF FUNDS");
                break;
            }
            //Ask if they'd like to play again
            System.out.print("Would you like to play again? (y/n) ");
            String playAgain = newScanner.next();
            if (playAgain.equals("n")) {
                System.out.println("Goodbye!");
                quitGame = true;
            }
            //Empty players' hands
            humanPlayer.hand.cards.clear();
            computerPlayer.hand.cards.clear();
            //Empty the used cards in the deck class
            newDeck.usedCards.clear();
            //Empty the money jar
            moneyJar.totalBets = 0;
        } while (quitGame == false);
    }

    public static void determineWinner(MoneyJar moneyJar, Player player, Player computerPlayer) {
        boolean humanWinner = false;
        boolean computerWinner = false;
        boolean draw = false;
        if (player.hand.getHandScore() == 21) {
            System.out.println("You have won!");
            humanWinner = true;
        } else if (computerPlayer.hand.getHandScore() == 21) {
            System.out.println("The computer has won!");
            computerWinner = true;
        } else if ((player.hand.getHandScore() == 21) && (computerPlayer.hand.getHandScore() == 21)) {
            System.out.println("It's a draw!");
            draw = true;
        } else if ((player.hand.getHandScore() < 21) && computerPlayer.hand.getHandScore() < 21) {
            if (player.hand.getHandScore() > computerPlayer.hand.getHandScore()) {
                System.out.println("You have won!");
                humanWinner = true;
            } else if (computerPlayer.hand.getHandScore() > player.hand.getHandScore()) {
                System.out.println("The computer has won");
                computerWinner = true;
            } else { //both hand scores are equal and less than 21
                System.out.println("It's a draw (under 21)");
                draw = true;
            }
        } else if ((player.hand.getHandScore() > 21) && (computerPlayer.hand.getHandScore() > 21)) {
            System.out.println("Both have busted");
            draw = true;
        } else if ((player.hand.getHandScore() > 21) && (computerPlayer.hand.getHandScore() <= 21)) {
            System.out.println("The computer has won!");
            computerWinner = true;
        } else if ((computerPlayer.hand.getHandScore() > 21) && (player.hand.getHandScore() <= 21)) {
            System.out.println("You have won!");
            humanWinner = true;
        }
        //distribute the bets
        distributeBets(humanWinner, draw, computerWinner, moneyJar, player, computerPlayer);
    }

    public static void distributeBets(boolean humanWinner, boolean draw,
                                      boolean computerWinner,
                                      MoneyJar moneyJar, Player humanPlayer,
                                      Player computerPlayer) {
        if (humanWinner) {
            humanPlayer.potValue += moneyJar.totalBets;
        } else if (draw) {
            humanPlayer.potValue += moneyJar.totalBets / 2;
            computerPlayer.potValue += moneyJar.totalBets / 2;
        } else if (computerWinner) {
            computerPlayer.potValue += moneyJar.totalBets;
        }
    }

    public static boolean checkBet(int bet) {
        return ((bet == 5) || (bet == 10) || (bet == 20) || (bet == 50) || (bet == 100));
    }
}



