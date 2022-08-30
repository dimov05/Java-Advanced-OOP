package PolymorphismExercise.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carData = scanner.nextLine().split("\\s+");
        String[] truckData = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]),
                Double.parseDouble(carData[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]),
                Double.parseDouble(truckData[2]));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            double value = Double.parseDouble(input[2]);
            switch (input[1]) {
                case "Car":
                    if (input[0].equals("Drive")) {
                        System.out.println(car.drive(value));
                    } else if (input[0].equals("Refuel")) {
                        car.refuel(value);
                    }
                    break;
                case "Truck":
                    if (input[0].equals("Drive")) {
                        System.out.println(truck.drive(value));
                    } else if (input[0].equals("Refuel")) {
                        truck.refuel(value);
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
