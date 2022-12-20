package com.miu.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroup{
    @Id
    @GeneratedValue
    private Long id;


    @Enumerated
    private RegistrationGroupEnum groupEnum;


    private Long registrationEventId;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Student> students;

    @ManyToMany
    private List<CourseOffering> courseOfferings;


    @JoinColumn(name="academicid")
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<AcademicBlock> academicBlocks ;

}
