package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Registration {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Student student;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<CourseOffering> courseOfferingList;

}
