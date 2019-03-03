package pl.shop.model;

import java.io.Serializable;
import java.util.Objects;

public final class Address implements Serializable { // final class, ostateczna, nic nie może dziedziczyć z tej klasy. you cannot extends class marked as final

    private String name;
    private String street;
    private String city;
    private String postcode;

    public Address(String name, String street, String city, String postcode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override // override equals to compare objects contains, not references as in default equals method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(name, address.name) &&
                Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(postcode, address.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, street, city, postcode);
    }

    @Override // override to get strings not reference
    public String toString() {
        return "Address: " + "\n" +
                "Type: " + name + "\n" +
                "Street: " + street + "\n" +
                "City: " + city + "\n" +
                "Postcode: " + postcode;
    }
}
