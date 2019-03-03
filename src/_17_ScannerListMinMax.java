import java.sql.SQLOutput;
import java.util.*;

public class _17_ScannerListMinMax {
    public static void main(String[] args) {
        // initialize array list of integers
        List<Integer> numbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // get numbers from user and add to numbers list
        int input;

        do {
            System.out.println("Provide number: ");
            input = scanner.nextInt();
            if (input != 0) numbers.add(input);

        } while (input != 0);

        System.out.println("MIN: " + Collections.min(numbers));
        System.out.println("MAX: " + Collections.max(numbers));

        /*do {
            numbers.add(input);
        } while (input == 0);
*/
        System.out.println(numbers);



        // when user provide 0 loop ends

        // find min and max from numbers list and print

    }
}
