package DesignPatternsLab.BuilderPattern;

public class Main {
    public static void main(String[] args) {
        Address address = new Address();
        address.setName("name")
                .setCity("Varna")
                .setAddressLine1("cityOne")
                .setAddressLine2("cityTwo")
                .setPhoneNumber("+359877779992");
        new AddressBuilder()
                .withEmail("email")
                .withName("name")
                .build();
    }
}
