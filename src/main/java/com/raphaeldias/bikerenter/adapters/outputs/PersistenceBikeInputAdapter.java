package com.raphaeldias.bikerenter.adapters.outputs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raphaeldias.bikerenter.adapters.outputs.entities.BikeEntity;
import com.raphaeldias.bikerenter.adapters.outputs.repositories.BikeRepository;
import com.raphaeldias.bikerenter.application.domain.Bike;
import com.raphaeldias.bikerenter.application.ports.inputs.BikeInputPort;
import com.raphaeldias.bikerenter.application.ports.outputs.PersistenceBikeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersistenceBikeInputAdapter implements BikeInputPort {
    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public Bike save(Bike bike) {
        BikeEntity bikeEntity = new BikeEntity();
        bikeEntity.setGear(bike.getGear());
        bikeEntity.setModel(bike.getModel());
        bikeEntity.setLocation(bike.getLocation());
        return new ObjectMapper().convertValue(this.bikeRepository.save(bikeEntity),Bike.class);
    }

    @Override
    public List<Bike> listAll() {
        List<BikeEntity> bikeEntities = bikeRepository.findAll();
        List<Bike> bikes = new ArrayList<>();

        bikeEntities.forEach(bikeEntity -> {
            bikes.add(new ObjectMapper().convertValue(bikeEntity,Bike.class));
        });
        return bikes;
    }

    @Override
    public Bike findById(Integer id) {
        Optional<BikeEntity> bikeOpt = this.bikeRepository.findById(id);
        return new ObjectMapper().convertValue(bikeOpt.get(),Bike.class);
    }

    @Override
    public void deleteById(Integer id) {
        this.bikeRepository.deleteById(id);
    }
}
