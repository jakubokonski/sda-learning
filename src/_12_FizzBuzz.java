public class _12_FizzBuzz {
    public static void main(String[] args) {

        // write a program that prints numbers 1 to 100, but
        // for multiples of 3 prints "Fizz",
        // for multiples of 5 prints "Buzz"
        // for multiples of 3 and 5 prints "FizzBuzz"

        int n = 30;
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}
