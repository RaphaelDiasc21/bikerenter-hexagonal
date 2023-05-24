package com.raphaeldias.bikerenter.adapters.outputs.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserEntity {
    @Id
    @Column(name="id",insertable = false, updatable = false)
    private Integer id;
    @Column
    private String name;
}
