package PolymorphismExercise.WildFarm.animals;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder baseToString = new StringBuilder(super.toString());

        baseToString.insert(baseToString.indexOf(",") + 2, this.breed + ", ");
        return baseToString.toString();

    }
}
