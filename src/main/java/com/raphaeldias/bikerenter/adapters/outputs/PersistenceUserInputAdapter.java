package com.raphaeldias.bikerenter.adapters.outputs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raphaeldias.bikerenter.adapters.outputs.entities.BikeEntity;
import com.raphaeldias.bikerenter.adapters.outputs.entities.UserEntity;
import com.raphaeldias.bikerenter.adapters.outputs.repositories.BikeRepository;
import com.raphaeldias.bikerenter.adapters.outputs.repositories.UserRepository;
import com.raphaeldias.bikerenter.application.domain.Bike;
import com.raphaeldias.bikerenter.application.domain.User;
import com.raphaeldias.bikerenter.application.ports.inputs.UserInputPort;
import com.raphaeldias.bikerenter.application.ports.outputs.PersistenceBikeOutputPort;
import com.raphaeldias.bikerenter.application.ports.outputs.PersistenceUserOutputPort;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersistenceUserInputAdapter implements UserInputPort {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        return new ObjectMapper().convertValue(this.userRepository.save(userEntity),User.class);
    }

    @Override
    public List<User> listAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = new ArrayList<>();

        userEntities.forEach(userEntity -> {
            users.add(new ObjectMapper().convertValue(userEntity,User.class));
        });
        return users;
    }

    @Override
    public User findById(Integer id) {
        Optional<UserEntity> bikeOpt = this.userRepository.findById(id);
        return new ObjectMapper().convertValue(bikeOpt.get(),User.class);
    }

    @Override
    public void deleteById(Integer id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return user;
    }
}
