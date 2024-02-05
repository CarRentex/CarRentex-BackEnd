package com.Tobeto.RentaCar.entities.concretes;
import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class  Customer extends User {

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "surname", length = 50)
    private String surname;

    @Column(name = "nationality_id", nullable = false)
    private String nationalityId;

}
