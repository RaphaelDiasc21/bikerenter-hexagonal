package com.raphaeldias.bikerenter.adapters.outputs.repositories;

import com.raphaeldias.bikerenter.adapters.outputs.entities.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentRepository extends JpaRepository<RentEntity,Integer> {
    Optional<RentEntity> findById(Integer id);
}
