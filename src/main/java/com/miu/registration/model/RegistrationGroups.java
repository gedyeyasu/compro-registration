package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String fpptrack ;
    private String mpptrack;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students;
    @ManyToMany
    private List<CourseOffering> courseOfferingList;

}
