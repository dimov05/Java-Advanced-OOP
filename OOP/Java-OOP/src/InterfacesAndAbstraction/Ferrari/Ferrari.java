package InterfacesAndAbstraction.Ferrari;

public class Ferrari implements Car {
    private String driverName;
    private String MODEL = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.MODEL, brakes(), gas(), this.driverName);
    }


    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }
}
