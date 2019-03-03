import pl.shop.model.*;

import java.util.Arrays;
import java.util.List;

public class _21_OOP_Shop {
    public static void main(String[] args) {
        // cannot create object from abstract classes
        // Customer customer = new Customer();

        // create customer
        Customer person = new Person("Jan", "Kowalski");
        Customer company = new Company("XYZ Sp.z.o.o", "VAT4237402347");
        // poziom widoczności jest z klasy Customer, nie ma dostepu do name, last name. jest tylko adres.
        // klasa nadrzędna pozwala stworzyć listę róznych klientów

        List<Customer> customers = Arrays.asList(person, company);
        for (Customer customer : customers) {
            System.out.println(customer.getName());
            System.out.println(customer);
        }

        if (person instanceof Person) {
            Person person1=(Person) person;
            System.out.println("Person first name: " + person1.getFirstName()); // rzutujemy żeby wyciągnąć first name z person
        }

        if (company instanceof Company) {
            Company cmp = (Company) company;
            System.out.println("Company vat number: " + cmp.getVatNumber());
        }

        // add addresses
        person.addAddresses(new Address("Delivery", "Street 1", "City 1", "01-200"));
        person.addAddresses(new Address("Delivery 2", "Street 2", "City 2", "01-565"));

        company.addAddresses(new Address("Delivery", "Cmp Street 1", "Cmp City 1", "01-340"));
        // drukuj adresy dla zmiennych person i company:
        System.out.println("person " + person.getAddresses());
        System.out.println("company " + company.getAddresses());

        // print addresses from loop (w linijkach):
        for (Address address : person.getAddresses()) {
            System.out.println(address);
        }

        // create account
        Account personAccount = new Account(person);
        Account companyAccount = new Account(company);

        Customer c1 = personAccount.getCustomer();
        if (c1 instanceof Company) {
            Company cmp2 = (Company) c1;
            System.out.println("Is company: " + cmp2.getVatNumber());
        } else if (c1 instanceof Person) {
            Person person1 = (Person) c1;
            System.out.println("is person: " + person1.getLastName());
        }

        Customer c2 = companyAccount.getCustomer();
        if (c2 instanceof Company) {
            Company cmp2 = (Company) c2;
            System.out.println("Is company: " + cmp2.getVatNumber());
        } else if (c2 instanceof Person) {
            Person person1 = (Person) c2;
            System.out.println("is person: " + person1.getLastName());
        }
    }
}
