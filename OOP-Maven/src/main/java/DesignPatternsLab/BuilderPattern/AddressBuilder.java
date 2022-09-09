package DesignPatternsLab.BuilderPattern;

public class AddressBuilder {
    private Address address;

    public AddressBuilder() {
        this.address = new Address();
    }

    public AddressBuilder withEmail(String email) {
        this.address.setEmail(email);
        return this;
    }

    public AddressBuilder withName(String name) {
        this.address.setName(name);
        return this;
    }

    public Address build() {
        return this.address;
    }
}
