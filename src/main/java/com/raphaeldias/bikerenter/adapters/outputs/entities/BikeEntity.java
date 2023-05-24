package com.raphaeldias.bikerenter.adapters.outputs.entities;

import com.raphaeldias.bikerenter.application.domain.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bikes")
public class BikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String model;
    @Column
    private String gear;
    @Embedded
    private Location location;
}
