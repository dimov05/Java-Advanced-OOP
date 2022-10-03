package ExceptionsAndErrorHandling.SquareRoot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int number = getNumber(scanner);
            System.out.printf("%.2f",
                    sqrt(number));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Goodbye");
        }
    }

    private static int getNumber(Scanner scanner) {
        String input = scanner.nextLine();
        int number;
        try{
            number = Integer.parseInt(input);
        } catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("Invalid");
        }
        return number;
    }

    public static double sqrt(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid");
        } else {
            return Math.sqrt(number);
        }
    }
}
