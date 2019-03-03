package pl.fiatek.carfactory.model;

// by default if there is no visibility mod class is visible in package: class - package, public class - visible anywhere
public class Car {

    // static fields, pola stałe, niezmienne
    public static final String STATUS_COMPANY = "company";
    public static final String STATUS_PERSONAL = "personal";

    // immutable class fields, pola niezmienne
    private final String type; // private - hide properties, encapsulate,
    private final String model;
    private final float engine;
    private final int weight;
    private final String vin;

    // mutable fields, pola zmienne
    private int distance = 0;
    private String registrationNo;
    private String status;

    // Constructor

    // default constructor
    // public Car() {
    // }

    public Car(String type, String model, float engine, int weight, String vin) {
        this.type = type;
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.vin = vin;
    }


    // getters
    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public float getEngine() {
        return engine;
    }

    public int getWeight() { return weight; }

    public String getVin() {
        return vin;
    }


    public int getDistance() {
        return distance;
    }
    public void addDistance(int km) {
        if (km > 0) {
            distance += km;
        }
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    // setter
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public float getPower() {
        return engine * 1000 / weight;
    }
}
