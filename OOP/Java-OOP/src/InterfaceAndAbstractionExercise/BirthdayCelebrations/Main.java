package InterfaceAndAbstractionExercise.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> birthables = new ArrayList<>();
        List<Identifiable> identifiables = new ArrayList<>();

        String input = scanner.nextLine();


        while (!input.equalsIgnoreCase("End")) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            switch (type) {
                case "Citizen":
                    birthables.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]),
                            tokens[3], tokens[4]));
                    break;
                case "Pet":
                    birthables.add(new Pet(tokens[1], tokens[2]));
                    break;
                case "Robot":
                    identifiables.add(new Robot(tokens[1], tokens[2]));
                    break;
                default:
                    break;
            }

            input = scanner.nextLine();
        }

        String specificDate = scanner.nextLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(specificDate)) {
                System.out.println(birthable.getBirthDate());
            }
        }


    }
}
