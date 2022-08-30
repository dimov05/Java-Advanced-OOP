package PolymorphismExercise.WildFarm.animals;

import java.text.DecimalFormat;

public class Mammal extends Animal {
    protected String livingRegion;

    public Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {

    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.getAnimalType(),
                this.animalName,
                formatter.format(this.animalWeight),
                this.livingRegion,
                this.foodEaten);
    }
}
