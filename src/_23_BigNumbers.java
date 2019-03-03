import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class _23_BigNumbers {

    public static void main(String[] args) {

        // factorial with bigInteger
        int n = 20;
        BigInteger result = BigInteger.valueOf(1); // define big intieger with value

        // big integer ma stałe statyczne zdefiniowane do wykorzystania
        // result = BigInteger.ONE; // uzycie zdefiniowanej wartości

        for (int i = 1; i < n; i++) {
            result = result.multiply(BigInteger.valueOf(i));    // na klasie BigIntegr nie można zrobić działań, trzeba przez wywołanie metod, BigInteger nie ma autoboxingu
        }
        System.out.printf("Factorial for %d is: %d \n", n, result);

        // BigDecimal
        BigDecimal n1 = new BigDecimal(1); // niezmienne
        BigDecimal n2 = n1.add(new BigDecimal(5)).subtract(new BigDecimal(10)); // wywołania tworzą nowe obiekty, BigDec jest niezmienne
        System.out.println("n2 is equal " + n2.toString());

        // double float and big dec
        double d1 = 0.3;
        double d2 = 0.2;
        System.out.println("0.3 - 0.2 = " + (d1 - d2)); // wynik 0.09999 niedokłady, zapis bitowy 0.1 jest niedokładnyc

        BigDecimal bd1 = new BigDecimal("0.3"); // zapis jako string np. wprowadzone przez uzytkownika jako string, zamienione potem na wartośc big dec
        BigDecimal bd2 = new BigDecimal("0.2");
        System.out.println("Big Decimal bd1 - bd2 = " + bd1.subtract(bd2));

        BigDecimal bd3 = new BigDecimal(0.3).setScale(2, RoundingMode.HALF_UP); // metoda salowania określa miejsca po przecinku i zaokraglenia
        BigDecimal bd4 = new BigDecimal(0.2).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Big Decimal doubles 0.3 - 0.2 = " + bd3.subtract(bd4));

        // watch out!!!
        double d3 = 10.0;
        double d4 = 3.0;
        System.out.println("Double 10.0 / 3.0 = " + (d3 / d4));

        BigDecimal bd5 = new BigDecimal(10);
        BigDecimal bd6 = new BigDecimal(3);
        // if you don't use rounding it will generate error
        System.out.println("BigDecimal 10 / 3 = " + bd5.divide(bd6, 10, RoundingMode.HALF_UP));
    }

}
