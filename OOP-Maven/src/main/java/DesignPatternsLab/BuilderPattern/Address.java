package DesignPatternsLab.BuilderPattern;

public class Address {
    private String name;
    private String email;
    private String phoneNumber;
    private String country;
    private String state;
    private String city;
    private String addressLine1;
    private String addressLine2;

    public Address() {

    }

    public Address setName(String name) {
        this.name = name;
        return this;
    }

    public Address setEmail(String email) {
        this.email = email;
        return this;
    }

    public Address setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Address setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public Address setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }
}
