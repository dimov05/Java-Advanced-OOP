package EncapsulationExcercise.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int countOfToppings = Integer.parseInt(pizzaInfo[2]);


        String[] ingredients = scanner.nextLine().split("\\s+");
        String flourType = ingredients[1];
        String bakingTechnique = ingredients[2];
        double weightInGrams = Double.parseDouble(ingredients[3]);

        try {
            Pizza pizza = new Pizza(pizzaName, countOfToppings);
            try {
                Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);
                pizza.setDough(dough);
                try {
                    String input = scanner.nextLine();
                    while (!"END".equals(input)) {
                        String[] toppings = input.split("\\s+");
                        String toppingType = toppings[1];
                        double weight = Double.parseDouble(toppings[2]);
                        Topping topping = new Topping(toppingType, weight);
                        pizza.addTopping(topping);

                        input = scanner.nextLine();
                    }
                    System.out.println(pizza.toString());

                } catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }



    }
}
