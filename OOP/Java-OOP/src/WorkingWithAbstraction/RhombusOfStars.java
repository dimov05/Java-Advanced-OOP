package WorkingWithAbstraction;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printTop(n);
        printBottom(n - 1);
    }

    private static void printBottom(int rowsCount) {
        for (int i = 1; i <= rowsCount; i++) {
            printStringNumberOfTimes(i, " ");
            printStringNumberOfTimes(rowsCount - (i - 1), "* ");
            System.out.println();
        }
    }

    private static void printTop(int rowsCount) {
        for (int i = 1; i <= rowsCount; i++) {
            printStringNumberOfTimes(rowsCount - i, " ");
            printStringNumberOfTimes(i, "* ");
            System.out.println();
        }

    }

    public static void printStringNumberOfTimes(int count, String str) {
        for (int i = 0; i < count; i++) {
            System.out.print(str);
        }
    }
}
