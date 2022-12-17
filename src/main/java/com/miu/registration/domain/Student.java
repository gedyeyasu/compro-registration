package com.miu.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Student extends Person{
    private Long studentId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address mailAddress;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address homeAddress;

    public Student(String firstName, String lastName, String email,
                   String userName, String password, Long studentId) {
        super(firstName, lastName, email, userName, password);
        this.studentId = studentId;
    }

    public Student(String firstName, String lastName, String email, String userName,
                   String password, Long studentId, Address mailAddress, Address homeAddress) {
        super(firstName, lastName, email, userName, password);
        this.studentId = studentId;
        this.mailAddress = mailAddress;
        this.homeAddress = homeAddress;
    }
}