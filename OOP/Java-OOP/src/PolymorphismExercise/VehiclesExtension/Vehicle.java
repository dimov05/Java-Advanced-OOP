package PolymorphismExercise.VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {


    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
    }

    protected void addConsumption(double additionalConsumption) {
        this.fuelConsumption += additionalConsumption;
    }

    protected void subtractConsumption(double subtraction) {
        this.fuelConsumption -= subtraction;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (fuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;
        if (fuelNeeded >= this.fuelQuantity) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.setFuelQuantity(this.fuelQuantity - fuelNeeded);
        DecimalFormat formatter = new DecimalFormat("#.##");

        return String.format("%s travelled %s km",
                this.getClass().getSimpleName(),
                formatter.format(distance));
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            if (this.fuelQuantity + liters > this.tankCapacity) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                this.setFuelQuantity(this.fuelQuantity + liters);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}
