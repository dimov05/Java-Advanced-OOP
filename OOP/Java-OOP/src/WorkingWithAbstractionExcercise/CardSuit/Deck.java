package WorkingWithAbstractionExcercise.CardSuit;

public enum Deck {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);


    private final int cardType;

    Deck(int cardType) {
        this.cardType = cardType;
    }
}
