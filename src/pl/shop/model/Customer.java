package pl.shop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Customer implements Serializable { // abstract class, no constructor

    private final List<Address> addresses; // final - przypisnanie do pola zmiennej adresses nie można zmienić, ale zawartość można
                                            // initialize from constructor

    // protected is visible/available only to subclasses (person, company)
    protected Customer() { // nowa pusta lista adresów
        addresses = new ArrayList<>();
    }

    public abstract String getName(); // klasa abstrakcyjna powinna mieć przynajmniej jedną metodę abstakcyjną, ta metoda w tym miejscy nie ma implementacji, to tylko definicja
    // to jak ma działać zdefiniuje klasa podrzędna


    public List<Address> getAddresses() { // getter zwraca zawartość listy adresów
        return addresses;
    }

    public void addAddresses(Address address) { // metoda setter dla dodawania adresów
        addresses.add(address);
    }
}
