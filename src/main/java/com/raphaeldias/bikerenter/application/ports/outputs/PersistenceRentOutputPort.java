package com.raphaeldias.bikerenter.application.ports.outputs;

import com.raphaeldias.bikerenter.application.domain.Rent;
import com.raphaeldias.bikerenter.application.domain.User;

import java.util.List;

public interface PersistenceRentOutputPort {
    Rent save(Rent rent);
    List<Rent> listAll();
    Rent findById(Integer id);
    void deleteById(Integer id);
}
