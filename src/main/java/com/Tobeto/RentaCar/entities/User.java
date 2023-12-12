package com.Tobeto.RentaCar.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",length = 30, nullable = false)
    private String name;
    @Column(name ="surname",length = 30, nullable = false)
    private String surname;
    @Column(name = "gsm",length = 30, nullable = true)
    private String gsm;
    @Column(name = "email",length = 50, nullable = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Customer> customers;

    @OneToMany(mappedBy = "user")
    private List<Employee> employees;
}
