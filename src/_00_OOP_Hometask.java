import pl.oop.hometask.Contractor;
import pl.oop.hometask.Invoice;
import pl.oop.hometask.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _00_OOP_Hometask {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Contractor> contractors = new ArrayList<>();
        List<Items> itemsList = new ArrayList<>();
        boolean finished = false;

        do {

            System.out.println("Name: ");
            String name = scanner.next();

            System.out.println("VAT Number: ");
            String vatNumber = scanner.next();

            System.out.println("Regon:");
            String regon = scanner.next();

            System.out.println("NIP:");
            String nip = scanner.next();

            Contractor contractor = new Contractor(name, vatNumber, regon, nip);
            contractors.add(contractor);

            System.out.println("YES for next item:");
            String response = scanner.next();
            finished = !response.equalsIgnoreCase("yes");

        } while (!finished);

        System.out.println("No of contractors created: " + contractors.size());
        // up contractors created

        // items:
        Items item1 = new Items("Szyszki", 100f, 0.23f);
        Items item2 = new Items("Jagody", 50f, 0.08f);
        Items item3 = new Items("Orzechy", 30f, 0.23f);

        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);

        System.out.println("No of items: " + itemsList.size());

        // net and gross value of all items:
        System.out.println("Net value: " + item1.getNetValue());
        System.out.println("Gross value: " + item1.getGrossValue());

    }

}
