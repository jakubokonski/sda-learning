public class _11_Loops {
    public static void main(String[] args) {

        // while loop
        int sum = 0;
        while (sum < 100) {
            sum += 10;
//            System.out.println(sum);
        }
        System.out.println("sum is " + sum);

        // do ... while
        sum = 105;
        do {
            sum += 10;
        } while (sum <100);
        System.out.println("do while sum is " + sum);

        // infinity loop/break
        sum = 0;
        while (true) {
//            System.out.println("sum is " + sum);
            sum++; // loopbreak
            if (sum == 999) {
                break;
            }
        }
        System.out.println("sum is " + sum);

        // infinity for loop
        // for ( ; ; ;) {
        //
        // }

        // for loop
        int result = 10;
        for (int i = 0; i < 100; i++) {
            result += i * i;
        }
        System.out.println("result is " + result);

        // factorial silnia
        int n = 10;
        result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i; // result = result * i
        }
        System.out.printf("factorial for: %d is %d \n", n, result);

        // factorial with while
        result = 1;
        int j = 1;
        while (j <= n) {
            result *= j;
            j++;
        }
        System.out.printf("factorial while: %d is %d \n", n, result);

        // fibonacci
        n = 11;
        int n1 = 0, n2 = 1;
        result = 0;
        for (int i = 2; i <= n; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        System.out.println("Fibonacci " + result);

        // prime numbers
        n = 100; // ilosc liczb
        int i = 0; // liczba sprawdzana
        j = 0; // dzielnik
        StringBuilder prime = new StringBuilder();
        for (i = 2; i <= n; i++) {
            int counter = 0;
            for (j = i; j >= 2; j--) {
                if (i % j == 0) {
                    counter++;
                    if (counter == 2) {
                        break;
                    }
                }
            }
                if (counter < 2) {
                    prime.append(i).append(" ");
                }
        }
        System.out.println("Numbers: " + prime.substring(0, prime.length() - 1));




    }
}
