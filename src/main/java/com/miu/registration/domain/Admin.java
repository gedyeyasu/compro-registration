package com.miu.registration.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Admin extends Person{
    public Admin(String firstName, String lastName, String email, String userName, String password) {
        super(firstName, lastName, email, new User(userName,password, Role.ADMIN));
    }
}
