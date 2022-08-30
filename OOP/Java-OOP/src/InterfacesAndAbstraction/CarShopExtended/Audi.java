package InterfacesAndAbstraction.CarShopExtended;

public class Audi extends CarImpl implements Rentable {
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentPerDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentPerDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "Minimum rental period for " + getMinRentDay() + " days. Price per day " + getPricePerDay();
    }
}
