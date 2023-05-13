package com.example.pillabikeapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Parking implements Serializable {

    private long id;
    private String name;
    private String city;
    private String  open;
    private String  close;
    private boolean isFull;

    /**
     *Constructor para añadir y modificar
     */
    public Parking(String name, String city, String open, String close, boolean isFull) {
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

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
