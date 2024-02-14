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
    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "location")
    private List<Car> cars;
}
