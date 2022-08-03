package EncapsulationExcercise.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int toppingsCount) {
        setName(name);
        setToppings(toppingsCount);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f",
                getName(), getOverallCalories());
    }

    public double getOverallCalories() {
        double totalCals = 0;
        totalCals += dough.calculateCalories();
        for (Topping t : toppings) {
            totalCals += t.calculateCalories();
        }
        return totalCals;
    }

    private void setToppings(int toppingsCount) {
        if (toppingsCount < 0 || 10 < toppingsCount) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(toppingsCount);
    }

    private void setName(String name) {
        if (name.trim().isBlank() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
