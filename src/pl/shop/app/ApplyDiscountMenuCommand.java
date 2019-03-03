package pl.shop.app;

import pl.shop.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ApplyDiscountMenuCommand implements MenuCommand<Order> {
    @Override
    public String getText() {
        return "Apply discount";
    }

    @Override
    public void execute(Order orders) {

        System.out.println("Total price before discount" + orders.getTotal());
        // chyba dodać if'a w zależności czy jest fixed czy cupon

        // orders.getDiscountPolicy;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter discount coupon if you have, for fixed discount policy enter anything:");
        orders.applyDiscount(scanner.next());
//        System.out.println("Select discount policy: 1 for coupon, 2 for fixed:");
//        int i = scanner.nextInt();
//        switch (i) {
//            case 1:
//                System.out.println("Enter discount code:");
//                orders.applyDiscount(scanner.next());
//                break;
//            case 2:
//                System.out.println("Checking and applying dicount");
//                orders.applyDiscount("");
//                break;
//            default:
//                System.out.println("Invalid");
//        }

        System.out.println("Final order price after discount: " + orders.getTotal());
    }
}
