package com.miu.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long registrationid;

    private String fpptrack ;

    private String mpptrack;

}
