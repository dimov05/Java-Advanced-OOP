package WorkingWithAbstractionExcercise.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Card Ranks:");
        for (CardRank card : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    card.getCardType(), card);
        }
    }
}
