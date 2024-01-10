package com.Tobeto.RentaCar.entities.concretes;


import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand extends BaseEntity {


    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "logo_path")
    private String Logopath;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;
}



