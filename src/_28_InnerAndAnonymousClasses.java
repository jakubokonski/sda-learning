import pl.shop.model.Customer;
import pl.shop.model.DiscountPolicy;
import pl.shop.model.Person;

public class _28_InnerAndAnonymousClasses {
    public static void main(String[] args) {

        // Inner classes (rzadko używane, gdzieś w biliotekach, może w swing)-----------------------
        Outer outer = new Outer();
        Outer.InnerA innerA = outer.new InnerA(); // new wywołane na obiekcie
        innerA.increase();

        System.out.println("i is " + outer.getI());

        Outer.InnerB innerB = outer.new InnerB();
        innerB.decrease();

        System.out.println("i is " + outer.getI());

        Outer outer1 = new Outer();
        Outer.InnerA innerA1 = outer1.new InnerA();
        innerA1.increase();

        System.out.println("inner a1 " + outer1.getI());

        // static classes - częściej stosowane------------------------
        StaticClassExample.InnerStatic innerStatic = new StaticClassExample.InnerStatic();
        innerStatic.increase();

        // anonymous classes------------------------------------------
        // można w miejscu nadpisywac metody
        DiscountPolicy policy = new DiscountPolicy() {
            @Override
            public float getDiscount(String code) {
                return 0.9f;
            }
        };

        // anonymous class from Customer (abstract)
        Customer customer = new Customer() {
            @Override
            public String getName() {
                return null;
            }
        };

        Person person = new Person("Jan", "Kowalski") {
            // można inicjalizowac pola:
            private int i = 0;

            // można nadpisywać metody:
            @Override
            public String getFirstName() {
                return "Mrs. " + super.getFirstName();
            }
            // mozna tworzyć nowe metody
            private String prefix() {
                return "Mrs.";
            }
        };
        // wszystko powyższe dostepne jest na obiekcie person
        System.out.println("first name anonymous class: " + person.getFirstName());

        // you can define class in method:
        // nie używane, trochę bez sensu i potrzeby
        class AA {

        }
        abstract class BB {

        }

        AA a = new AA();
        BB b = new BB() {};
    }
}

class StaticClassExample {
    private int i = 0;

    static class InnerStatic { // wyodrębnione ze świata obiektowego
        private int i = 0;

        void increase() {
            i++; // tylko do i w klasie static, nie odwołuje się do i z klasy wyżej
        }

    }
}





class Outer {
    private int i = 0;

    class InnerA { // klasa wewnętrzna, obiekty klasy inner nie moga istnieć bez klasy outer
        // shadowing
        private int i = 0; // przykrywa wartość klasy outer,

        void increase() {
            i++; // dostęp do pół z klasy zewnętrznej
            Outer.this.i++; // dostęp do nienadpisanej zmiennej z klasy Outer
        }
        class C {
            void increase() {
                Outer.this.i++; // dostęp do klas wyższych
                InnerA.this.i++;
            }
        }
    }

    class InnerB {
        void decrease() {
            i--;
        }
    }
    public int getI() {
        return i;
    }
}