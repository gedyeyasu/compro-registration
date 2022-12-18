package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Long Id;
    private String street;
    private String city;
    private long postalCode;
    private String state;
    private String country;

    public Address(String street, String city, long postalCode, String state, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
    }
}