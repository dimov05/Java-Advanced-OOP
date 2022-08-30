package PolymorphismExercise.Vehicles;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION = 1.6;

    protected Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}