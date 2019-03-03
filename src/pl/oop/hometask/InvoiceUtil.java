package pl.oop.hometask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvoiceUtil {
//  1. List<Invoice> findByContractor(Contractor contractor, List<Invoice> invoices)
//     - na przekazanej liście faktur znajdź i zwróć tylko te, które należą do danego kontrahenta
//  2. List<Invoice> findByNumberStartingWith(String number, List<Invoice> invoices)
//     - znajdź i zwróć faktury, których numer zaczyna się od podanego.
//  3. Invoice getWithHigherGrossValue(Invoice i2, Invoice i2) - zwróć tą fakturę, której wartość brutto jest większa
//  4. int countItems(List<Invoice> invoices) - zwróć ile Item'ów znajduje się we wszystkich fakturach.

    List<Invoice> findByContractor (Contractor contractor, List<Invoice> invoices) {
        if (invoices.size() == 0) {             // sprawdzic czy nie jest pusta, return .emptyList
        return Collections.emptyList();
        }

        List<Invoice> result = new ArrayList<>();
        return null;
    }

    List<Invoice> findByNumberStartingWith (String number, List<Invoice> invoices) {
        return null;
    }
}
