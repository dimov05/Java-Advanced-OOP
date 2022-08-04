package EncapsulationExcercise.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight){
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(!TypeHelper.TOPPING_TYPES.containsKey(toppingType)){
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight < 1 || 50 < weight){
            throw new IllegalArgumentException("Topping type " + this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        return (2 * this.weight) * TypeHelper.TOPPING_TYPES.get(this.toppingType);
    }
}
