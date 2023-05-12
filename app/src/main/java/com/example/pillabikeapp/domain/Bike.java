package com.example.pillabikeapp.domain;

import java.time.LocalDate;

public class Bike {

    private long id;
    private String buyDate;
    private String description;
    private float price;
    private boolean electric;
    private Parking parking;

    /**
     * Construcctor para añadir
     */
    public Bike(String buyDate, String description, float price, boolean electric) {
        this.buyDate = buyDate;
        this.description = description;
        this.price = price;
        this.electric = electric;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String  getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String  buyDate) {
        this.buyDate = buyDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
