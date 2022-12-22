package com.miu.registration.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miu.registration.utils.PasswordUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    private String username;

    @JsonIgnore
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String password, Role role){
        this.username = username;
        this.password = PasswordUtil.encodePassword(password);
        this.role = role;
    }
}
