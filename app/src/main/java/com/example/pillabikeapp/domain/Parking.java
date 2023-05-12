package com.example.pillabikeapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Parking implements Serializable {

    private long id;
    private String name;
    private String city;
    private LocalTime open;
    private LocalTime close;
    private boolean isFull;

    /**
     *Constructor para añadir y modificar
     */
    public Parking(String name, String city, LocalTime open, LocalTime close, boolean isFull) {
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

    public LocalTime getOpen() {
        return open;
    }

    public void setOpen(LocalTime open) {
        this.open = open;
    }

    public LocalTime getClose() {
        return close;
    }

    public void setClose(LocalTime close) {
        this.close = close;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
