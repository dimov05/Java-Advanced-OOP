package Encapsulation.FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IllegalArgumentException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Team team = new Team("Black Eagles");

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            try {
                team.addPlayer(new Person(input[0]
                        , input[1]
                        , Integer.parseInt(input[2])
                        , Double.parseDouble(input[3])));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}
