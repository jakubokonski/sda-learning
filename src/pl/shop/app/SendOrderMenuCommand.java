package pl.shop.app;

import pl.shop.model.Account;
import pl.shop.model.Address;
import pl.shop.model.Order;
import pl.shop.utils.ListUtils;

import java.util.List;
import java.util.Scanner;

public class SendOrderMenuCommand implements MenuCommand<Order> {
    @Override
    public String getText() {
        return "Send Order";
    }

    @Override
    public void execute(Order order) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String street = "";
        String city = "";
        String postcode = "";

        System.out.println("Pick address:");
        if (order.getAccount().getCustomer().getAddresses().isEmpty()) {

            System.out.println("No address, please create one: ");
            Address address = new Address(name, street, city, postcode);
            System.out.println("Address name:");
            address.setName(scanner.nextLine());
            System.out.println("Street");
            address.setStreet(scanner.nextLine());
            System.out.println("City");
            address.setCity(scanner.nextLine());
            System.out.println("Postcode");
            address.setPostcode(scanner.nextLine());
            order.getAccount().getCustomer().addAddresses(address);
            System.out.println(address.toString());
            System.out.println("Address successfully added! (hopefully)");
            order.sendOrder(order.getAccount().getCustomer().getAddresses().get(0));
            System.out.println("Order dispatched to the address: " + order.getAccount().getCustomer().getAddresses().get(0));

        } else {
            System.out.println("Select address from the list: ");
            String addressList = ListUtils.toNumeratedList(order.getAccount().getCustomer().getAddresses());
            System.out.println(addressList);
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    order.sendOrder(order.getAccount().getCustomer().getAddresses().get(i-1));
                    System.out.println("Order sent to address: " + order.getAccount().getCustomer().getAddresses().get(i-1));
                    break;
                case 2:
                    order.sendOrder(order.getAccount().getCustomer().getAddresses().get(i-1));
                    System.out.println("Order sent to address: " + order.getAccount().getCustomer().getAddresses().get(i-1));
                    break;
            }
            System.out.println("Order status: " + order.getStatus());
        }

    }
}
