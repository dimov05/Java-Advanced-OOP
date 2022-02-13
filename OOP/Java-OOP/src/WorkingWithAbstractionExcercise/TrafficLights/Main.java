package WorkingWithAbstractionExcercise.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] startLights = scanner.nextLine().split("\\s+");

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String light : startLights) {
            TrafficLight trafficLight =
                    new TrafficLight(Color.valueOf(light));
            trafficLights.add(trafficLight);
        }
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            for (TrafficLight light : trafficLights) {
                light.update();
                System.out.print(light.getColor() + " ");
            }
            System.out.println();
        }
    }
}
