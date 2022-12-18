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
public class RegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long registrationrequestid;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Student Student;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<CourseOffering> courseOfferingList;


}
