package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue

    private Long id;
    private String firstname;
    private String lastname;
    private String email;



}
