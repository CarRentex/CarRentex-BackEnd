package com.Tobeto.RentaCar.entities.concretes;

import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "images")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ImageData{


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Lob
    @Column(name = "image_data", length = 1000)
    private byte[] imageData;

    @Column(name = "image_Url", length = 1000)
    private String imageUrl;
}
