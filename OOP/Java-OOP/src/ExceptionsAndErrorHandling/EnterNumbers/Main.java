package ExceptionsAndErrorHandling.EnterNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean succeeded = printRangeOfTwoNumbers(scanner);

        while (!succeeded) {
            succeeded = printRangeOfTwoNumbers(scanner);
        }
    }

    private static boolean printRangeOfTwoNumbers(Scanner scanner) {
        try {
            int[] numbers = readTwoNumbers(scanner);
            printNumbers(numbers[0], numbers[1]);
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input " + ex.getMessage());
            return false;
        }
    }

    public static int[] readTwoNumbers(Scanner scanner) {
        int[] res = new int[2];
        res[0] = readSingleNumber(scanner);
        res[1] = readSingleNumber(scanner);
        return res;
    }

    public static int readSingleNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    public static void printNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }

    }
}
