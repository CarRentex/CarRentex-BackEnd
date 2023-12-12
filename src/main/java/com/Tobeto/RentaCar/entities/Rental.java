package com.Tobeto.RentaCar.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "rentals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "start_date", length =20, nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", length =20, nullable = false)
    private LocalDate endDate;
    @Column(name = "return_date", length =20)
    private LocalDate returnDate;
    @Column(name = "start_kilometer", length =30)
    private int startKilometer;
    @Column(name = "end_kilometer", length =30)
    private int endKilometer;
    @Column(name = "total_price", length =30, nullable = false)
    private double totalPrice;
    @Column(name = "discount", length =10)
    private double discount;


    //foreignkey
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
