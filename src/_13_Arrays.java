import java.util.Arrays;
import java.util.Random;

public class _13_Arrays {

    public static void main(String[] args) {

        // arrays are indexed from 0
        // store values of the same type

        int[] arr1 = new int[10]; // 10 elementów od 0 do 9, wszystkie są zerami
        int i1 = arr1[0]; // pobranie pierwszego elemntu z tablicy
        System.out.println("arr1[0] = " + i1);

        arr1[0] = 1;
        System.out.println("arr1[0] = " + arr1[0]);

        arr1[1] = 2;
        arr1[2] = 5;
        arr1[3] = 15;

        // arr1[10] = 10; array out of bounds

        // init arrays with values
        String[] stringArray = new String[] { "zdzisiek", "kamil", "michał", "marcin" };
        System.out.println(Arrays.toString(stringArray)); // wydruk zawartości tablicy

        // sort array
        Arrays.sort(stringArray);
        System.out.println("Array to string: " + Arrays.toString(stringArray));

        // print via loop
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println("Name is " + stringArray[i]);
        }

        // for - enhanced for
        for (String name : stringArray) {
            System.out.print(name + ", ");
        }

        System.out.println();

        // sum array elements
        Random random = new Random();
        double[] elements = new double[5];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = random.nextDouble();
        }
        System.out.println("random " + Arrays.toString(elements));

        // calc average
        double sum = 0.0;
        for (double element : elements) {
            sum += element;
            System.out.println("El " + element + " Sum " + sum);
        }
        double average = sum / elements.length;
        System.out.println("AV " + average);

        // Sito Erattostenesa
        int n = 100;
        boolean[] primes = new boolean[n];
        for (int i = 2; i <= Math.sqrt(n); i++) { // pierwiastek
            if (primes[i]) {
                continue; // go for next if
            }
            for (int j = i * i; j < n; j += i) { // wartosc true w tablei dla liczb niewykreślonych
                primes[j] = true;
            }
        }
        for (int i = 1; i < primes.length; i++) { // drukowanie wyników
            if (!primes[i]) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();

        System.out.println("is 9 prime " + !primes[9]); // sprawdzenie wartości w tablicy

        // multidimensional arrays / tablice w tablicy
        int[][] multi = new int[10][];

        multi[0] = new int[10];
        multi[1] = new int[5];

        multi[0][0] = 1; // przypisanie wartości w tab 0 0

        for (int i = 0; i < multi.length; i++) {
            multi[i] = new int[10];
            for (int j = 0; j < multi[i].length; j++) {
                multi[i][j] = random.nextInt(100);
            }
        }

        for (int i = 0; i < multi.length; i++) {
            System.out.println(Arrays.toString(multi[i]));
        }
        System.out.println("element in [0, 9]: " + multi[0][9]);

        // fill in loop and print
        /* 1 2 3 4 5
           2 4 6 8 10
           3 6 9 12 15
           4 8 12 16 20
           5 10 15 20 25
        */

        int[][] values = new int[5][5];

        for (int i = 0; i < values.length; i++) {
          for (int j = 0; j < values.length; j++) {
              values[i][j] = (i + 1) * (j + 1);
            }
        }
        for (int i = 0; i < values.length; i++) {
            System.out.println(Arrays.toString(values[i]));
        }


    }
}
