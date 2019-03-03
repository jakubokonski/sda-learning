package pl.oop.hometask;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private String name;
    private float netValue;
    private float tax;


    public Items(String name, float netValue, float tax) {
        this.name = name;
        this.netValue = netValue;
        this.tax = tax;
    }

    List<Items> itemsList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNetValue() {
        return netValue;
    }

    public void setNetValue(float netValue) {
        this.netValue = netValue;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getGrossValue() {
        return netValue + (netValue * tax);
    }

}
