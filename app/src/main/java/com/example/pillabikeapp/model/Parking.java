package com.example.pillabikeapp.model;

import java.time.LocalDate;

public class Parking {

    private long id;
    private String name;
    private String city;
    private LocalDate open;
    private LocalDate close;
    private boolean isFull;

    /**
     *Constructor para añadir y modificar
     */
    public Parking(String name, String city, LocalDate open, LocalDate close, boolean isFull) {
        this.name = name;
        this.city = city;
        this.open = open;
        this.close = close;
        this.isFull = isFull;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getOpen() {
        return open;
    }

    public void setOpen(LocalDate open) {
        this.open = open;
    }

    public LocalDate getClose() {
        return close;
    }

    public void setClose(LocalDate close) {
        this.close = close;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
