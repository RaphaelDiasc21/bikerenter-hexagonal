package com.raphaeldias.bikerenter.application.ports.inputs;

import com.raphaeldias.bikerenter.application.domain.Rent;

import java.util.List;

public interface RentInputPort {
    Rent save(Rent rent);
    List<Rent> listAll();
    Rent findById(Integer id);
    void deleteById(Integer id);
}
