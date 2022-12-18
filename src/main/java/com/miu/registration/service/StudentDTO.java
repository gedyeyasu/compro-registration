package com.miu.registration.service;

import com.miu.registration.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Long studentId;
    private AddressDTO mailAddress;
    private AddressDTO homeAddress;

    public StudentDTO(String firstName, String lastName, String email, Long studentId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentId = studentId;
    }

}
