package WorkingWithAbstractionExcercise.CardsWithPower;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    public int getColor() {
        return color;
    }

    private final int color;

    CardSuit(int color) {
        this.color = color;
    }
}
