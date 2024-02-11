package com.Tobeto.RentaCar.entities.concretes;

import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    @Column(name = "city_name")
    private String cityName;

    // Bir şehirin birçok ilçesi olabilir
    @OneToMany(mappedBy = "city")// cascade = CascadeType.ALL
    private List<District> districts;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<User> users;
}
