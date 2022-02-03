package WorkingWithAbstraction.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = getArray(scanner);
        Point bottom = new Point(coordinates[0], coordinates[1]);
        Point top = new Point(coordinates[2], coordinates[3]);
        Rectangle rectangle = new Rectangle(bottom, top);

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            int[] points = getArray(scanner);
            Point currentPoint = new Point(points[0], points[1]);
            System.out.println(rectangle.contains(currentPoint));
        }
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
