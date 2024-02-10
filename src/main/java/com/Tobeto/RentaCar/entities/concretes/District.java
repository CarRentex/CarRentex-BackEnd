package com.Tobeto.RentaCar.entities.concretes;

import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "districts")
public class District extends BaseEntity {

    @Column(name = "district_name")
    private String districtName;

    // Bir ilçenin bir şehri olabilir
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
