package InterfacesAndAbstraction.CarShopExtended;

public abstract class CarImpl implements Car {
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    Integer TIRES = 4;


    public CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public String getCountryProduced() {
        return countryProduced;
    }

    @Override
    public String toString() {
        return "This is " + model + " produced in " + countryProduced + " and have " + Car.TIRES + " tires";
    }
}
