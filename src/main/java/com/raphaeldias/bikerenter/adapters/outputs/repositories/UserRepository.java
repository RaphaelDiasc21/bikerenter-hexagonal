package com.raphaeldias.bikerenter.adapters.outputs.repositories;

import com.raphaeldias.bikerenter.adapters.outputs.entities.BikeEntity;
import com.raphaeldias.bikerenter.adapters.outputs.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findById(Integer id);
}
