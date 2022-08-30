package PolymorphismExercise.WildFarm.animals;

import PolymorphismExercise.WildFarm.food.Food;

public abstract class Animal {
    String animalName;
    String animalType;
    double animalWeight;
    int foodEaten;

    public Animal(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
    }


    protected String getAnimalType() {
        return this.animalType;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }
}
