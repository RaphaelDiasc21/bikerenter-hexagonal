package com.raphaeldias.bikerenter.adapters.outputs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raphaeldias.bikerenter.adapters.outputs.entities.BikeEntity;
import com.raphaeldias.bikerenter.adapters.outputs.entities.RentEntity;
import com.raphaeldias.bikerenter.adapters.outputs.entities.UserEntity;
import com.raphaeldias.bikerenter.adapters.outputs.repositories.RentRepository;
import com.raphaeldias.bikerenter.adapters.outputs.repositories.UserRepository;
import com.raphaeldias.bikerenter.application.domain.Rent;
import com.raphaeldias.bikerenter.application.domain.User;
import com.raphaeldias.bikerenter.application.ports.inputs.RentInputPort;
import com.raphaeldias.bikerenter.application.ports.outputs.PersistenceRentOutputPort;
import com.raphaeldias.bikerenter.application.ports.outputs.PersistenceUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersistenceRentInputAdapter implements RentInputPort {
    @Autowired
    private RentRepository rentRepository;

    @Override
    public Rent save(Rent rent) {
        RentEntity rentEntity = new RentEntity();
        rentEntity.setBike(new ObjectMapper().convertValue(rent.getBike(), BikeEntity.class));
        rentEntity.setUser(new ObjectMapper().convertValue(rent.getUser(), UserEntity.class));
        return new ObjectMapper().convertValue(this.rentRepository.save(rentEntity),Rent.class);
    }

    @Override
    public List<Rent> listAll() {
        List<RentEntity> rentEntities = rentRepository.findAll();
        List<Rent> rents = new ArrayList<>();

        rentEntities.forEach(userEntity -> {
            rents.add(new ObjectMapper().convertValue(rentEntities,Rent.class));
        });
        return rents;
    }

    @Override
    public Rent findById(Integer id) {
        Optional<RentEntity> rentOpt = this.rentRepository.findById(id);
        return new ObjectMapper().convertValue(rentOpt.get(),Rent.class);
    }

    @Override
    public void deleteById(Integer id) {
        this.rentRepository.deleteById(id);
    }
}
