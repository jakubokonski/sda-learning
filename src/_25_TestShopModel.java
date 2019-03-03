import pl.shop.model.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class _25_TestShopModel {
    public static void main(String[] args) {
        // zaczynamy od klienta, potem konto
        // 1. create customer
        Customer customer = new Company("Company XWQ", "PL23423");

        // 2. create account
        Account account = new Account(customer);
        System.out.println("Created account " + account); // domyślnie zostanie użyta metoda toString

        // 3. add addres to customer
        Address deliveryAddress = new Address("Delivery", "Dziada 4", "Dziadków", "01-111");
        customer.addAddresses(deliveryAddress);
        Address contactAddress = new Address("Contact", "Pradziada 3", "Dziadków", "01-111");
        customer.addAddresses(contactAddress);

        System.out.println("Generated addresses: " + customer.getAddresses());

        // 4. Create discount policy
        List<String> codes = Arrays.asList("ABC123", "ABC124", "ABC125");
        DiscountPolicy couponPolicy = new CuponDiscountPolicy(0.2f, codes);
        DiscountPolicy fixedPolicy = new FixedDiscountPolicy(0.1f);

        // 5. add orders
        Order order1 = new Order(account, couponPolicy);
        order1.addItem(new Item("TV1", new BigDecimal("1025.10"), 1));
        order1.addItem(new Item("żelazko", new BigDecimal("212.65"), 3));

        System.out.println("My order is: " + order1);

        Order order2 = new Order(account, fixedPolicy);
        order2.addItem(new Item("Grabki", new BigDecimal("229.9"), 3));
        order2.addItem(new Item("Szpadel", new BigDecimal("189.98"), 5));

        System.out.println("My second order is: " + order2);

        // 6. Apply discount (optional)
        order1.applyDiscount("ABC123");
        order2.applyDiscount("");

        System.out.println("Order 1 total: " + order1.getTotal());
        System.out.println("Order 2 total: " + order2.getTotal());

        // 7. Send order
        order1.sendOrder(customer.getAddresses().get(0));
        order2.sendOrder(customer.getAddresses().get(1));

        System.out.println("Order 1: " + order1);
        System.out.println("Order 2: " + order2);
    }
}
