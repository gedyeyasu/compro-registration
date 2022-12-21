package com.miu.registration.domain;

import com.miu.registration.service.DTO.RegistrationDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseOffering {
    @Id
    @GeneratedValue
    private Long id;
    private String code;

    private Integer capacity=50;
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinColumn
    private Collection<Registration> registrationsOfStudents=new ArrayList<>();
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Course course;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Faculty faculty;
    @Transient
    private Integer availableSeat;
    public void addRegistrationOfStudents(Collection<Registration> registrationsOfStudents){
        this.registrationsOfStudents.addAll(registrationsOfStudents);
    }
    public CourseOffering(Integer capacity, Collection<Registration> registrationsOfStudents) {
        this.capacity = capacity;
        this.registrationsOfStudents = registrationsOfStudents;
    }

    public Integer getAvailableSeat() {
       return capacity-registrationsOfStudents.size();
    }

    public void setAvailableSeat(Integer availableSeat) {
        this.availableSeat = availableSeat;
    }
}