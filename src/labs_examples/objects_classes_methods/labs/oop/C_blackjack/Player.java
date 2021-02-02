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

    public void betMoney(int bet) {
        potValue -= bet;
        moneyJar.totalBets += bet;
    }

    public int getPotValue() {
        return potValue;
    }

}
