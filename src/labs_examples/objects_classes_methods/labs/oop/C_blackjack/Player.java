package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {
    String name;
    Hand hand = new Hand();
    int potValue; //the amount of money you have
    MoneyJar moneyJar;

    public Player(MoneyJar moneyJar) {
        this.potValue = 100;
        this.moneyJar = moneyJar;
    }

    public boolean computerAI() {
        return hand.getHandScore() < 16;
    }

    public void betFive() {
        if (potValue >= 5) {
            potValue -= 5;
            moneyJar.totalBets += 5;
        } else {
            System.out.println("Not enough money to bet");
        }
    }

    public void betTen() {
        if (potValue >= 10) {
            potValue -= 10;
            moneyJar.totalBets += 10;
        } else {
            System.out.println("Not enough money to bet");
        }
    }

    public void betTwenty() {
        if (potValue >= 20) {
            potValue -= 20;
            moneyJar.totalBets += 20;
        } else {
            System.out.println("Not enough money to bet");
        }
    }

    public void betFifty() {
        if (potValue >= 50) {
            potValue -= 50;
            moneyJar.totalBets += 50;
        } else {
            System.out.println("Not enough money to bet");
        }
    }

    public void betHundred() {
        if (potValue >= 100) {
            potValue -= 100;
            moneyJar.totalBets += 100;
        } else {
            System.out.println("Not enough money to bet");
        }
    }


    public int getPotValue() {
        return potValue;
    }
}
