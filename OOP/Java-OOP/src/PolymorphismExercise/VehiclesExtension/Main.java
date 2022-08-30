package PolymorphismExercise.VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        vehicleMap.put("Car", createVehicle(scanner.nextLine()));
        vehicleMap.put("Truck", createVehicle(scanner.nextLine()));
        Bus bus = createBus(scanner.nextLine());

        vehicleMap.put("Bus", bus);


        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            double value = Double.parseDouble(input[2]);

            if (input[0].equals("Drive") && input[1].equals("Bus")) {
                System.out.println(bus.driveWithPassenger(value));
            } else if (input[0].equals("Drive") || input[0].equals("DriveEmpty")) {
                System.out.println(vehicleMap.get(input[1]).drive(value));
            } else {
                try {
                    vehicleMap.get(input[1]).refuel(value);
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
            }
        }
        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle);
        }
    }

    private static Bus createBus(String nextLine) {
        String[] tokens = nextLine.split("\\s+");
        return new Bus(Double.parseDouble(tokens[1]),
                Double.parseDouble(tokens[2]),
                Double.parseDouble(tokens[3]));
    }

    private static Vehicle createVehicle(String input) {
        String[] tokens = input.split("\\s+");

        switch (tokens[0]) {
            case "Car":
                return new Car(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            case "Truck":
                return new Truck(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            case "Bus":
                return createBus(input);
        }
        return null;
    }
}
