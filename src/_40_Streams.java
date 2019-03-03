import pl.shop.model.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class _40_Streams {
    public static void main(String[] args) {
        /*
        Stream:
        - sequence of elements,
        - it's an abstraction,
        - it's a pipeline of declared computations,
        - it can be made from array, collection, generator function or IO
         */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(numbers.stream()
                .filter(i -> i > 3)
                .filter(i -> i % 2 == 0)
                .mapToInt(i -> i * 2)
                // .reduce(0, (result, i) -> result + i) // sumujemy, zaczynamy od 0, dodajemy kolejne i. reduce może służyć do innych przetworzeń
                // .sum()
                .average()
        );

        OptionalDouble result = numbers.stream()
                .filter(i -> i > 3)
                .filter(i -> i % 2 == 0)
                .mapToInt(i -> i * 2)
                // .reduce(0, (result, i) -> result + i) // sumujemy, zaczynamy od 0, dodajemy kolejne i. reduce może służyć do innych przetworzeń
                // .sum()
                .average();
        if (result.isPresent()) {
            System.out.println(result.getAsDouble());
        }

        // find first element
        List<String> words = Arrays.asList("w1", "w3", "c1", "a2", "r4");

        Optional<String> resultWord = words.stream()
                .filter(word -> word.endsWith("1"))
                .findFirst();
        System.out.println(resultWord.orElse("q1")); // wydrukuj wynik jesli jest, a jesli nie ma to wydrukuj q1

        // collect filtered elements to list
        // DON'T
        List<Integer> integers = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 6, 7, 8);
        // double even numbers and put into list
//        List<Integer> resultInts = new ArrayList<>();
//        integers.stream()
//                .filter(i -> i % 2 == 0)
//                .map(i -> i* 2)
//                .forEach(i -> resultInts.add(i) ); // DON'T DO THIS

        // DO:
        List<Integer> resultCorrect = integers.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .collect(toList()); // collect jak reduce, przygotowana do zebrania elementów kolekcji do innej kolekcji
        System.out.println("Result correct: " + resultCorrect);

        // grouping and mapping
        List<Person> people = Arrays.asList(
                new Person("Jan", "Kowalski"),
                new Person("Jan", "Nowak"),
                new Person("Adam", "Cios"),
                new Person("Kamil", "Jasek"),
                new Person("Adam", "Kotek")
        );
        // list która do każdego imienia przyporzadkuje nazwiska, które może mieć.
        Map<String, List<String>> grouped = people.stream()
                .collect(groupingBy(Person::getFirstName, mapping(Person::getLastName, toList())));

        System.out.println("Grouped " + grouped);

        // stream 2 typy operacji: lazy (intermediate) and terminal

        // Stream is lazy:
        Stream<Integer> stream = Stream.of(12, 9,1,2,3,4,5,6,6,7)
                .distinct() // lazy
                .sorted(); // lazy
        System.out.println(stream);
        System.out.println(stream.collect(toList())); // terminal

        // stream.forEach(i -> System.out.println(i)); streamu który został wykonany i zamknięty nie można ponownie wykonać

        /*
            Stream has 2 operations:
            - lasy intermediate:
                * map
                * filter
                * sorted
                * limit
                * distinct
             - terminal (do it):
                * reduce
                * findFirst
                * findAny
                * anyMatch
                * sum
                * average
                * forEach
         */

        // how to create Stream from generator function
        Stream.iterate(1, e -> e + 1)
                .filter(i -> i % 3 == 0)
                .map(i -> i * 2)
                .skip(5)
                .limit(10)
                .forEach(System.out::println);

//        stream.reduce(1, Imperative::compute);

        int k = 4;
        int n = 3;
        int result2 = 0;
        int index = k;
        int count = 0;
        while (count < n) {
            if (index % 2 == 0 && Math.sqrt(index) > 20) {
                result2 += index * 2;
                count++;
            }
            index++;
        }
        System.out.println(result2);


//        Stream.iterate(k, e -> e + 1)
//                .filter(e -> e % 2 == 0)
//                .filter(e -> Math.sqrt(e) > 20)
//                .map(e -> e * 2)
//                .limit(n);

    }
}

class Imperative {
    /*
    starts with k, and finds the total of double of n even numberd, where sqrt of each number is > 20
     */
    static int compute(int k, int n) {
        int result = 0;
        int index = k;
        int count = 0;
        while (count < n) {
            if (index % 2 == 0 && Math.sqrt(index) > 20) {
                result += index * 2;
                count++;
            }
            index++;
        } return result;
    }
}

class Declarative {

    static int compute(int k, int n) {
        return Stream.iterate(k, e -> e + 1)
                .filter(e -> e % 2 == 0)
                .filter(e -> Math.sqrt(e) > 20)
                .mapToInt(e -> e * 2)
                .limit(n)
                .sum();
    }
}