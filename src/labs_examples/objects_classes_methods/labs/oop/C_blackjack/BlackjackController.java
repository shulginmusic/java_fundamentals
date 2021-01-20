package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

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
        boolean notEnoughMoney = false;
        int bet;
        do {
            //Ask how much the player would like to bet
            System.out.print(humanPlayer.name + ", you currently have " + humanPlayer.potValue + " dollars.");
            System.out.print("\nHow much would you like to bet? (5/10/20/50/100) ");
            bet = newScanner.nextInt();
            //TODO how to write functionality if not enough money for chosen bet
            switch (bet) {
                case 5:
                    humanPlayer.betFive();
                    computerPlayer.betFive();
                    break;
                case 10:
                    humanPlayer.betTen();
                    computerPlayer.betTen();
                    break;
                case 20:
                    humanPlayer.betTwenty();
                    computerPlayer.betTwenty();
                    break;
                case 50:
                    humanPlayer.betFifty();
                    computerPlayer.betFifty();
                    break;
                case 100:
                    humanPlayer.betHundred();
                    computerPlayer.betHundred();
                    break;
                default://TODO this needs work, try a throws exception + why does it keep going without quitting the loop?!
                    System.out.println("Input not allowed, sorry");
            }

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
//        boolean bothBusted = false;
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
//            bothBusted = true;
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

}

//TODO work on bet functionality, something doesn't add up, also: the computer might have less money than you and won't
//be able to match bet





