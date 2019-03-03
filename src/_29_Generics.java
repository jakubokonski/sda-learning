import pl.shop.model.Customer;
import pl.shop.model.Person;

import java.util.ArrayList;
import java.util.List;

public class _29_Generics {
    public static void main(String[] args) {
        // define list type via generic, list can only store integers type data, Integer is a generic type:
        // bez podania <Integers> typu listy, domyślnie będzie to Object (z poprzednich wersji).
        // W czasie kompilacji wszystko zmienione jest na Object i rzutowane, np: i1 = (Integer) integers.get(0);
        List<Integer> integers = new ArrayList<>();

        // use Pair class (szablon): class with types (generic), new object created with Pair constructor and arguments:
        Pair<String, Integer> pair1 = new Pair<>("one", 1);

        Pair<Customer, String> pair2 = new Pair<>(
                new Person("Jan", "Kowalski"),
                "Hello");

        // wyciągnięcie danych z obiektu
        String oneStr = pair1.getLeft();
        Integer oneInt = pair1.getRight();
    }
}

class Pair<L, R> { // w nawiasie placeholdery, niezdefiniowane typy, definiowane później.
    // Wyżej podajemy Pair<co to za typ 1, co to za typ 2>, potem podajemy własciwe argumenty w konstruktorze.
    private final L left;
    private final R right;

    Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}
