package com.miu.registration.domain;

import lombok.*;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int priority;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private CourseOffering courseOffering;

    @ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Student student;
}
