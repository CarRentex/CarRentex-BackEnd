package com.Tobeto.RentaCar.entities.concretes;

import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="locations")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "startLocation")
    private List<Rental> startRentals;

    @OneToMany(mappedBy = "endLocation")
    private List<Rental> endRentals;




}
