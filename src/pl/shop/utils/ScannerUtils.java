package pl.shop.utils;

import java.util.Scanner;

public final class ScannerUtils {

    public static int nextInt(int from, int to) { // int from and to are menu boundaries, defined later
        Scanner scanner = new Scanner(System.in);
        while (true) { // loot to check user selection
            int selection = scanner.nextInt();
            if (selection >= from && selection <= to) {
                return selection;
            }
            System.out.printf("Invalid option. Please select one between %d and %d\n", from, to);
        }
    }
}
