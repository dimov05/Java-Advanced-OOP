package EncapsulationExcercise.ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> personList = new HashMap<>();
        Map<String, Product> productsList = new HashMap<>();

        String[] people = scanner.nextLine().split(";");
        for (String s : people) {
            String[] human = s.split("=");
            String name = human[0];
            double money = Double.parseDouble(human[1]);
            try {
                Person person = new Person(name, money);
                personList.putIfAbsent(name, person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        String[] products = scanner.nextLine().split(";");
        for (String p : products) {
            String[] grocery = p.split("=");
            String nameProduct = grocery[0];
            double priceProduct = Double.parseDouble(grocery[1]);
            try {
                Product product = new Product(nameProduct, priceProduct);
                productsList.putIfAbsent(nameProduct, product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] personProduct = input.split("\\s+");
            String buyer = personProduct[0];
            String grocery = personProduct[1];

            try {
                personList.get(buyer).buyProduct(productsList.get(grocery));
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            input = scanner.nextLine();
        }

        for(Person p : personList.values()){
            System.out.println(p.toString());
        }

    }
}
