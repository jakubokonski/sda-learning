package pl.shop.utils;

import java.util.List;

public final class ListUtils {

    public static <T> String toNumeratedList(List<T> list) { // generic method, static na poziomie klasy a nie obiektu
        StringBuilder builder = new StringBuilder("\n");
        int i = 1;
        for (T el : list) { // lista dodająca elementy do menu
            builder.append(i++).append(". ").append(el).append('\n');
        }
        return builder.toString();
    };
}
