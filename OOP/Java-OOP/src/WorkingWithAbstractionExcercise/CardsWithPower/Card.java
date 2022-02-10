package WorkingWithAbstractionExcercise.CardsWithPower;

public class Card {
    private CardsPower power;
    private CardSuit color;

    public int getTotal() {
        return total;
    }

    private int total;

    public Card(CardsPower power, CardSuit color) {
        this.power = power;
        this.color = color;
        this.total = power.getPower() + color.getColor();
    }

}
