package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public Person(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
