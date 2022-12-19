package com.miu.registration.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Enumerated
    private RegistrationGroupEnum groupEnum;



    private Long registrationeventid;

    @JsonManagedReference
    @OneToMany(mappedBy = "registrationGroups",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Student> students;

    @ManyToMany
    private List<CourseOffering> courseOfferingList;

}
