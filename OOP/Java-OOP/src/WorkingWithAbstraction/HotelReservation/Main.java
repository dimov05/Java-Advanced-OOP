package WorkingWithAbstraction.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(tokens[0]);
        int countDays = Integer.parseInt(tokens[1]);

        String inputSeason = tokens[2];
        Season season = Season.valueOf(inputSeason.toUpperCase());

        String inputDiscount = tokens[3];
        DiscountType discountType = DiscountType.valueOf(inputDiscount.toUpperCase());


        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, countDays,
                season, discountType);
        System.out.printf("%.2f", priceCalculator.calculatePrice());
    }
}
