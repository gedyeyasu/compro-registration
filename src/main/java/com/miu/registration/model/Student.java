package com.miu.registration.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {


    //private Long studentId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address mailAddress;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address homeAddress;


    public Student(String firstName, String lastName, String email, String userName,
                   String password,  Address mailAddress, Address homeAddress) {
        super(firstName, lastName, email, userName, password);

        this.mailAddress = mailAddress;
        this.homeAddress = homeAddress;
    }


}
