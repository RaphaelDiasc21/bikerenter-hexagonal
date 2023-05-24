package com.raphaeldias.bikerenter.adapters.inputs.controllers;

import com.raphaeldias.bikerenter.application.domain.Bike;
import com.raphaeldias.bikerenter.application.ports.inputs.BikeInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bikes")
public class BikeController {
    @Autowired
    private BikeInputPort bikeInputPort;

    @PostMapping()
    public ResponseEntity<Bike> create(@RequestBody Bike bike) {
        Bike bikeCreated = bikeInputPort.save(bike);
        return ResponseEntity.ok(bikeCreated);
    }

    @GetMapping()
    public ResponseEntity<List<Bike>> findAll() {
        List<Bike> bikes = bikeInputPort.listAll();
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("{id}")
    public ResponseEntity<Bike> findById(@PathVariable("id") Integer id) {
        Bike bike = bikeInputPort.findById(id);
        return ResponseEntity.ok(bike);
    }
}
