import pl.company.model.Employee;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class _20_Object {
    public static void main(String[] args) {
        // Object is superclass for every class

        // popular object methods: (equals, hashcode, toString)

        Employee employee = new Employee( // create employee object in Employee class using Employee constructor
                "Jan", "kowalski", "34234", LocalDate.of(2000, 1, 1)
        );
        System.out.println("Employee is " + employee); // default implementation from superclass object is .toString

        // hashcode and equals
        String s1 = "test";
        String s2 = "test";
        boolean areEquals = s1.equals(s2); // look inside equals for string

        // instance of example - sprawdzamy czy dany obiekt jest danego typu
        Object x1 = 50;
        Object x2 = "50";
        if (x1 instanceof Integer) {
            System.out.println("x1 is Integer");
            int sum = (Integer) x1 + 100; // rzutowanie (cast) typu zmiennej na zmienną x1, wcześniej Java nie wie jakiego typu jest ten obiekt
        }
        if (x2 instanceof String) {
            System.out.println("x2 is String");
        }
        if (x1 instanceof String) {
            System.out.println("x1 is String");
        }
        if (x2 instanceof Integer) {
            System.out.println("x2 is integer");
        }

        // test employee equality
        Employee employee2 = new Employee( // create employee object in Employee class using Employee constructor
                "Jan", "kowalski", "34234", LocalDate.of(2000, 1, 1));
        System.out.println("are equals " + employee.equals(employee2)); // by default porówbujemy referencje

        int firstHashcode = employee.hashCode();
        int secondHashcode = employee2.hashCode();
        System.out.println("First " + firstHashcode);
        System.out.println("Second " + secondHashcode);

        // draw.io
        // klasy abstrakcyjne, nie można tworzyć z konstruktra, służą do trzymania wspólnych elementów
        // klasy konkretne, mają konstruktory
    }

}
