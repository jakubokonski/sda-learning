package pl.shop.model;

import java.io.Serializable;

public interface DiscountPolicy extends Serializable {

    float DEFAULT_VALUE = 0; // pole (field), domyślnie "public static final" - właściwość interface, który może mieć tylko pola statyczne.

    /**
     * this method should result in numbers from 0.0 to 1.0
     * interface definiuje raczej usługi, niż obiekty
     *
     * @param code
     * @return discount percent
     */
    default float getDiscount(String code) { // domyślna metoda, domyślna implementacja nie daje rabatu
        return DEFAULT_VALUE;
    }
}
