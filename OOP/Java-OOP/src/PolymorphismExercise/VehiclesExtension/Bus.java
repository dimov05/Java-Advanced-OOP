package PolymorphismExercise.VehiclesExtension;

public class Bus extends Vehicle {
    private static final double AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION = 1.4;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public String driveWithPassenger(double distance) {
        super.addConsumption(AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION);
        String out = super.drive(distance);
        super.subtractConsumption(AIR_CONDITIONAL_ADDITIONAL_CONSUMPTION);
        return out;
    }

}
