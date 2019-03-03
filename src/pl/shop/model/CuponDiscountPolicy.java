package pl.shop.model;

import java.util.List;

public final class CuponDiscountPolicy implements DiscountPolicy {

    private final float discount; // rabat
    private final List<String> codes; // lista kodów

    public CuponDiscountPolicy(float discount, List<String> codes) {
        this.discount = discount;
        this.codes = codes;
    }

    @Override
    public float getDiscount(String code) {
        return codes.contains(code) ? discount : 0; // jesli code w liście codes jest to zwróci discount, inaczej 0.
    }



}
