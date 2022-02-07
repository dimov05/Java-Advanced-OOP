package WorkingWithAbstraction.HotelReservation;

public class PriceCalculator {
    double total;
    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private DiscountType discountType;
    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculatePrice(){
        return this.numberOfDays * this.pricePerDay * this.season.getMultiplier()
                * (1-this.discountType.getDiscount()/100.00);
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
