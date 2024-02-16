package com.Tobeto.RentaCar.entities.concretes;
import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
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
public class Car extends BaseEntity {

    @Column(name = "kilometer", length = 30, nullable = false)
    private int kilometer;
    @Column(name = "year" ,length = 6, nullable = false)
    private int year;
    @Column(name = "daily_price",  length = 30, nullable = false)
    private double dailyPrice;
    @Column(name = "plate",  length = 30, nullable = false, unique = true)
    private String plate;
    @Column(name = "min_findeks_rate")
    private short minFindeksRate;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "passenger_capacity")
    private short passengerCapacity;


    @Enumerated(EnumType.STRING)
    @Column(name ="category")
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name="gear_type")
    private GearType gearType;

    @Enumerated(EnumType.STRING)
    @Column(name="fuel_type")
    private FuelType fuelType;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(name = "is_active")
    private boolean isActive = true;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

}
