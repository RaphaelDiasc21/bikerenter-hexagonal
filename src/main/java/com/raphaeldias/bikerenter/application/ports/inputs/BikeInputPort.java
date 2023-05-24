package com.raphaeldias.bikerenter.application.ports.inputs;

import com.raphaeldias.bikerenter.application.domain.Bike;

import java.util.List;

public interface BikeInputPort {
    Bike save(Bike user);
    List<Bike> listAll();
    Bike findById(Integer id);
    void deleteById(Integer id);
}
