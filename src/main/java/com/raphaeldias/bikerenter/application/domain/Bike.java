package com.raphaeldias.bikerenter.application.domain;

public class Bike {
    private Integer id;
    private String model;
    private String gear;
    private Location location;

    public Bike() {}
    public Bike(Integer id, String model, String gear, Location location) {
        this.id = id;
        this.model = model;
        this.gear = gear;
        this.location = location;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
