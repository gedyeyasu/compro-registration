package com.miu.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private CourseOffering courseOffering;

    @ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Student student;
}
