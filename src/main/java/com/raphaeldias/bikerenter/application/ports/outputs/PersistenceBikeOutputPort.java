package com.raphaeldias.bikerenter.application.ports.outputs;

import com.raphaeldias.bikerenter.application.domain.Bike;
import com.raphaeldias.bikerenter.application.domain.User;

import java.util.List;

public interface PersistenceBikeOutputPort {
    Bike save(Bike bike);
    List<Bike> listAll();
    Bike findById(Integer id);
    void deleteById(Integer id);
}
