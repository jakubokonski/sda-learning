import java.util.*;

public class _39_Lambda {
    public static void main(String[] args) {
        /*
        Lambda
            - anonymous function, contains:
                * parameter list
                * body
            - it's interface implementation (like anonymous inner class)
              BUT
              it's only valid when there is single abstract method
            - cannot have a state
            - prefer lambda over anonymous classes
         */

        List<String> words =new ArrayList<>(Arrays.asList("w1", "w2", "w3")); // Arrays.asList tworzy listę a klasy AbstractList
        // enhanced loop - external iterator - how to do things

        // internal iterator - what to do.
        words.forEach(element -> System.out.println(element));

        words.removeIf(word -> word.endsWith("2"));
        System.out.println(words);

        // Method reference
        words.forEach(System.out::println);

        // lazy evaluation
        System.out.println("------------------LAzy EV------------------");
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "test");
        map.putIfAbsent(10, HardComputing.compute(10)); // if key 10 is empty put value.

        //-------------Do if necessary-------------------
        map.computeIfAbsent(10, HardComputing::compute);
        System.out.println(map);


        // BiFunction
        System.out.println("BiFunction: ");
        map.computeIfPresent(10, (key, value) -> HardComputing.compute(key, value)); // co to overriding (te same nazwy metody, różne argumenty) and overloading
        map.computeIfPresent(10, HardComputing::compute); // method reference for more than 1 argument

        System.out.println(map);
    }
}

class HardComputing {
    static String compute(Integer key) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return "test 2";
    }
    static String compute(Integer key, String value) {
        return (key * 2) + "_" + value;
    }
}

/*
    Functional interfaces:
    - Function<T,R>  - R apply(T t);
    - Predicate<T>  - return boolean test(T t);
    - Consumer<T>  - void accept(T t);
    - Supplier<T>  - T get();
    - BiFunction<T, V, R>  - R accept(T t, V v);

    Higher Order Functions:
    - you can pass function into function as an argument
    - you can return function from function
 */
@FunctionalInterface // annotation necessary to avoid adding another methods, functional interface can have only one abstract method
interface MyAwesomeFunctionalInterface<T,R> {
    R apply(T t);
}