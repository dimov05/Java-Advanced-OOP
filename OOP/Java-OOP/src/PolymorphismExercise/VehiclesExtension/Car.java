package PolymorphismExercise.VehiclesExtension;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION
        ,tankCapacity);
    }
}
