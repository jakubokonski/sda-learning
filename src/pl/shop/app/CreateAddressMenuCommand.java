package pl.shop.app;

import pl.shop.model.Account;
import pl.shop.model.Address;
import pl.shop.model.Customer;
import pl.shop.utils.OptionSelector;

import java.util.List;
import java.util.Scanner;

public class CreateAddressMenuCommand implements MenuCommand<Account> {

    public static final OptionSelector<String> YES_NO_SELECTOR = new OptionSelector<>("Yes", "No");
    public static final int NO_ANSWER = 2;

    @Override
    public String getText() {
        return "Create address";
    }

    @Override
    public void execute(Account account) {
        Scanner scanner = new Scanner(System.in);
        boolean finish;
        System.out.println("Please add address:");
        String name = "";
        String street = "";
        String city = "";
        String postcode = "";
        do {
            Address address = new Address(name, street, city, postcode);
            System.out.println("Address name:");
            address.setName(scanner.nextLine());
            System.out.println("Street");
            address.setStreet(scanner.nextLine());
            System.out.println("City");
            address.setCity(scanner.nextLine());
            System.out.println("Postcode");
            address.setPostcode(scanner.nextLine());
            account.getCustomer().addAddresses(address);
            System.out.println(address.toString());

            System.out.println("Add another address?");
            int addNext = YES_NO_SELECTOR.select();
            finish = (addNext == NO_ANSWER);

        } while (!finish);

    }
}
