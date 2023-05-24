package com.raphaeldias.bikerenter.adapters.outputs.entities;

import com.raphaeldias.bikerenter.application.domain.Bike;
import com.raphaeldias.bikerenter.application.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rents")
@EqualsAndHashCode(of = "id")
public class RentEntity {
    @Id
    @Column(name="id",insertable = false, updatable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bike_id")
    private BikeEntity bike;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
