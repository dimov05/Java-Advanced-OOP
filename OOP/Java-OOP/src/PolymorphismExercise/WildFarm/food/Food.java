package PolymorphismExercise.WildFarm.food;

public abstract class Food {
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public Food(int quantity) {
        this.quantity = quantity;
    }
}
