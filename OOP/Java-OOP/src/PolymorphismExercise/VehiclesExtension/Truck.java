package PolymorphismExercise.VehiclesExtension;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION = 1.6;

    protected Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION,
                tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}