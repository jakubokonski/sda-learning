import pl.shop.model.CuponDiscountPolicy;
import pl.shop.model.DiscountPolicy;
import pl.shop.model.FixedDiscountPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _22_OOP_Shop_DiscountPolicy {

    public static void main(String[] args) {

        List<DiscountPolicy> policies = new ArrayList<>(); // nowa lista na różne polityki rabatowe

        // fixed discount policy added to the polices list
        DiscountPolicy fixedDiscountPolicy = new FixedDiscountPolicy(0.2f);
        policies.add(fixedDiscountPolicy);

        // cupon disc policy added to the list of policies
        List<String> codes = new ArrayList<>();
        codes.add("ABC123");
        codes.add("ABC122");
        codes.add("ABC121");
        DiscountPolicy cuponDiscountPolicy = new CuponDiscountPolicy(0.5f, codes);
        policies.add(cuponDiscountPolicy);

        // apply discount
        float amount = 1000;
        DiscountPolicy policy;
        Random random = new Random();
        if (random.nextInt() % 2 == 0) { // wybór polityki rabatowej
            policy = policies.get(0);
        } else {
            policy = policies.get(1);
        }
        float discount = policy.getDiscount("ABC123");
        System.out.println("Amount with discount is " + (amount - (amount * discount))); // i co to nam tu wyszło
    }
}
