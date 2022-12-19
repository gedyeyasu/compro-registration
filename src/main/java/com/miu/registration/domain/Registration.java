package com.miu.registration.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Registration {
    @Id
    @GeneratedValue
    private Long id;
}
