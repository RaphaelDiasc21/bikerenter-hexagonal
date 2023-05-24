package com.raphaeldias.bikerenter.adapters.inputs.controllers;

import com.raphaeldias.bikerenter.application.domain.Rent;
import com.raphaeldias.bikerenter.application.domain.User;
import com.raphaeldias.bikerenter.application.ports.inputs.RentInputPort;
import com.raphaeldias.bikerenter.application.ports.inputs.UserInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserInputPort userInputPort;

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) {
        User rentCreated = userInputPort.save(user);
        return ResponseEntity.ok(rentCreated);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getBike() {
        List<User> users = userInputPort.listAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getBike(@PathVariable("id") Integer id) {
        User user = userInputPort.findById(id);
        return ResponseEntity.ok(user);
    }

}
