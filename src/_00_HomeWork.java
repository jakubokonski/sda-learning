import java.util.Arrays;
import java.util.Scanner;

public class _00_HomeWork {
    public static void main(String[] args) {

        // 1. ZADANIE.---------------------------------------------
/*
        System.out.println("Zadanie 1:");
        int sum = 0;
        int counter = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 21 == 0) {
                // System.out.println(i);
                sum += i;
                counter++;
            }
        }
        System.out.println("Suma liczb: " + sum);
        System.out.println("Liczba operacji: " + counter);
*/

        // ZADANIE 2:-----------------------------------------------

        int[] numbers = new int[] { 10, 20, -3, 9, 15, -8 };
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            max = max < number ? number : max;
        }

        // Sort array
/*
        System.out.println("Zadanie 2:");
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        min = numbers[0];
        max = numbers[numbers.length - 1];

        System.out.println("Min value: " + min);
        System.out.println("Max value: " + max);
*/
        // for while loop

        min = numbers[0];
        max = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] > max ) {
                max = numbers[i];
            }
            while (numbers[i] < min) {
                min = numbers[i];
            }

        }
        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);

        // ZADANIE 3A:---------------------------------------------------------

        // Stars

        StringBuilder builder = new StringBuilder();
        int stars = 5;

        for (int i = 0; i < stars; i++) {
            builder.append("* ");
            System.out.println(builder.toString());
        }


        // ZADANIE 3B:--------------------------------------------------------

        // Choinka
        System.out.println("Choinka:");
        int l = 6;
        int r = 10;

        StringBuilder choinka = new StringBuilder( "        *        ");
        System.out.println(choinka.length());
        System.out.println(choinka);
        for (int i = 0; i < 4; i++) {
            choinka.replace(l,l+1, "*").replace(r,r+1, "*");
            l = l - 2;
            r = r + 2;
            System.out.println(choinka);
        }

        // Choinka II
        System.out.println("CHOINKA II");

        // INPUT TREE HEIGHT:
/*
        Scanner input = new Scanner(System.in);
        System.out.println("Enter tree height:");
        int height = input.nextInt(); // Scans the next token of the input as an int.
        //once finished
        input.close();
        int spaces = ((height - 1) * 4) + 1;
        int m;

        System.out.println("Tree width: " + spaces);
*/
        // INPUT TREE WIDTH:

        Scanner input = new Scanner(System.in);
        System.out.println("Enter tree width:");
        int spaces = input.nextInt(); // Scans the next token of the input as an int.
        //once finished
        input.close();

        int m;

        if (spaces % 2 == 0) {
            spaces += 1;
        }
        System.out.println("Tree width: " + spaces);

        // TREE PRINT
        StringBuilder choinka2 = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            choinka2.append(" ");
        }
        m = ((spaces - 1) / 2);
        l = m - 2;
        r = m + 2;

        choinka2.replace(m,m+1, "*");
        System.out.println(choinka2);
        for (int i = 0; i < (spaces / 4); i++) {
            choinka2.replace(l,l+1, "*").replace(r,r+1, "*");
            l -= 2;
            r += 2;
            System.out.println(choinka2);
        }


    }
}

