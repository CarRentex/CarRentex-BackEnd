package com.Tobeto.RentaCar.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "kilometer", length = 30, nullable = false)
    private int kilometer;

    @Column(name = "year" ,length = 6, nullable = false)
    private int year;

    @Column(name = "daily_price",  length = 30, nullable = false)
    private double dailyPrice;

    @Column(name = "plate",  length = 30, nullable = false, unique = true)
    private String plate;

    // foreignkey

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;


    @ManyToOne
    @JoinColumn(name = "color_id")
    private  Color color;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private  Model model;


}
