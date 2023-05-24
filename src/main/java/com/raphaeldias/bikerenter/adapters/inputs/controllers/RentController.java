package com.raphaeldias.bikerenter.adapters.inputs.controllers;

import com.raphaeldias.bikerenter.application.domain.Bike;
import com.raphaeldias.bikerenter.application.domain.Rent;
import com.raphaeldias.bikerenter.application.ports.inputs.BikeInputPort;
import com.raphaeldias.bikerenter.application.ports.inputs.RentInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentController {
    @Autowired
    private RentInputPort rentInputPort;

    @PostMapping()
    public ResponseEntity<Rent> create(@RequestBody Rent rent) {
        Rent rentCreated = rentInputPort.save(rent);
        return ResponseEntity.ok(rentCreated);
    }

    @GetMapping()
    public ResponseEntity<List<Rent>> findAll() {
        List<Rent> rents = rentInputPort.listAll();
        return ResponseEntity.ok(rents);
    }

    @GetMapping("{id}")
    public ResponseEntity<Rent> findById(@PathVariable("id") Integer id) {
        Rent rent = rentInputPort.findById(id);
        return ResponseEntity.ok(rent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        rentInputPort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
