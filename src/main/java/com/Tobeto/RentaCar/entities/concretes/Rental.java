package com.Tobeto.RentaCar.entities.concretes;
import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rentals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental extends BaseEntity {

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
    @Column(name = "total_price", length =30)
    private double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_location_id")
    private Location startLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end_location_id")
    private Location endLocation;


    //foreignkey

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "corporate_id")
    private CorporateCustomer corporate;




    @OneToMany(mappedBy = "rental")
    private List<Invoice> invoices;

}
