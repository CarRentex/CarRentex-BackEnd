package com.Tobeto.RentaCar.entities.concretes;
import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {

    @Column(name = "first_name",length = 30, nullable = false)
    private String firstName;
    @Column(name = "last_name",length = 30, nullable = false)
    private String lastName;


}
