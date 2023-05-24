package com.raphaeldias.bikerenter.application.domain;

import java.util.Date;

public class Rent {
    private Integer id;
    private Bike bike;
    private User user;

    public Rent() {}
    public Rent(Integer id, Bike bike, User user) {
        this.id = id;
        this.bike = bike;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
