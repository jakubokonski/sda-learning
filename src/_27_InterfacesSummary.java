import pl.shop.model.DiscountPolicy;
import pl.shop.model.NoDiscountPolicy;

import java.io.Serializable;

public class _27_InterfacesSummary {
    public static void main(String[] args) {
        /*
        Interfaces:
        - tylko deklaracje metod, implemetowaych w konkretnych klasach
        - metody default
        - static fields
        - dziedziczyć można tylko po jednej klasie, but concrete (konkretna) class can implement many interfaces
        - wszystkie metody są public abstract
        - no instance fields, just static
         */

        // default method implementation usage - nowa klasa konkretna, NoDiscountPolisy żeby można było używać domyślnej implementacji
        DiscountPolicy policy = new NoDiscountPolicy();
    }
}

class ExampleInterface implements DiscountPolicy, Runnable, Serializable { // class Exint implements two interfaces, serializable - markerinterface
    @Override
    public void run() {
        System.out.println("Example for implementing many interfaces.");
    }
}
