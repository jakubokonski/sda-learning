import pl.fiatek.carfactory.model.Car;
import pl.fiatek.carfactory.model.CarUtil;

import java.util.Random;

public class _18_OOP_Basics {
    public static void main(String[] args) {
        // w clasie car tworzymy zmienną skoda z parametrami z konstruktora
        Car skoda = new Car("Sedan", "Skoda", 1.2f, 1350, "XSD2334234K");
        System.out.println("Car is: type=" + skoda.getType() + ", model=" + skoda.getModel());

        // car is sold. nadajemy wartości parametrom regno i status
        skoda.setRegistrationNo("AW3023");
        skoda.setStatus("personal");

        System.out.println("Skoda is: " + skoda.getType() + ", reg: " + skoda.getRegistrationNo());

        // change distance
        Random random = new Random();
        System.out.println("Skoda dist: " + skoda.getDistance());
        skoda.addDistance(random.nextInt(500));
        skoda.addDistance(random.nextInt(200));
        System.out.println("new dist: " + skoda.getDistance());

        // second car
        Car lexus = new Car("Sedan", "Lexus", 4.0f, 1800, "EW213423");

        // add them to array
        Car[] cars = new Car[] {skoda, lexus };
        for (Car car : cars) {
            System.out.printf("Car is %s, type=%s, engine=%s, weight=%s\n", car.getModel(), car.getType(), car.getEngine(), car.getWeight());
        }

        lexus.setStatus(Car.STATUS_COMPANY); // odwołanie do stałej globalnej klasy car

        Car fastestCar = CarUtil.getFastestCar(cars);
        System.out.println("Fastest car is " + fastestCar.getModel());

        // overloaded method getFastestCar
        fastestCar = CarUtil.getFastestCar(skoda, lexus); // ręcznie wprowadzenie zmiennych tego samego typu, pojawią sie później w tablicy, OVERLOADING, lub może być jak wyżej nowa tablica.

    }

}

