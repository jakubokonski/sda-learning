package pl.oop.hometask;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private String invoiceNumber;
    private Items items;
    private Contractor contractor;

    List<Items> itemsList = new ArrayList<>();

    public Invoice(String invoiceNumber, Contractor contractor) {
        this.invoiceNumber = invoiceNumber;
        this.contractor = contractor;
    }

    float getNetTotal = itemsList.size();




}
