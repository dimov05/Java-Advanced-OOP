package EncapsulationExcercise.AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String chickenName = scanner.nextLine();
        int chickenAge = Integer.parseInt(scanner.nextLine());

        try{
            Chicken chicken = new Chicken(chickenName, chickenAge);
            System.out.println(chicken);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
