package WorkingWithAbstractionExcercise.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cardPower = scanner.nextLine();
        String color = scanner.nextLine();
        Card card = new Card(CardsPower.valueOf(cardPower),
                CardSuit.valueOf(color));
        System.out.printf("Card name: %s of %s; Card power: %d",
                cardPower, color, card.getTotal());
    }
}
