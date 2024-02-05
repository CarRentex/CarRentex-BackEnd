package com.Tobeto.RentaCar.entities.concretes;

import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "corporate_customers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateCustomer extends User { //extends User

    @Column(name="company_name")
    private String companyName;
    @Column(name="tax_no")
    private String taxNo;


/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;*/

}



