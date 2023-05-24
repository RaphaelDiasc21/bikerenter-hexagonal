package com.raphaeldias.bikerenter.adapters.outputs.repositories;

import com.raphaeldias.bikerenter.adapters.outputs.entities.BikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BikeRepository extends JpaRepository<BikeEntity,Integer> {
    Optional<BikeEntity> findById(Integer id);
}
