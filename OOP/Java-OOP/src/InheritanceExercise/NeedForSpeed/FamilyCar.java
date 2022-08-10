package InheritanceExercise.NeedForSpeed;

public class FamilyCar extends Car {
    private static final double DEFAULT_FUEL_CONSUMPTION = 3;

    public FamilyCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
