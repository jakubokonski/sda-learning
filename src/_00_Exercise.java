import java.util.Arrays;
import java.util.Random;

public class _00_Exercise {
    public static void main(String[] args) {

        // Create random int from array range

        int[] numbers = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(numbers));
        int number = (getRandomFromRange(1, 5) * 100) + (getRandomFromRange(1, 5) * 10) + getRandomFromRange(1, 5);
        System.out.println(number);
        System.out.println(getRandomFromRange(1, 5));
    }
    private static int getRandomFromRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;

    }

}
