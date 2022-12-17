package com.miu.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Faculty extends Person{
    private Long facultyId;
    private String title;

    public Faculty(String firstName, String lastName, String email,
                   String userName, String password, Long facultyId, String title) {
        super(firstName, lastName, email, userName, password);
        this.facultyId = facultyId;
        this.title = title;
    }
}
