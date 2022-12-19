package com.miu.registration.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String courseoffercode;
    private int capacityofStudents;
    private int avaivableseats;

//    @ManyToOne
//    @JoinColumn(name="course_c")
//    private Course course;

//    @ManyToOne
//    @JoinTable(name="course_acaedmicblock")
//    private AcademicBlock academicBlock;

//    @ManyToOne
//    @JoinColumn(name = "faculty_id")
//    private Faculty faculty;



    /**
     Each CourseOffering also has a capacity and a calculated field “availableSeats”.
     AvailableSeats is calculated based on (Capacity – Number of students registered)
     */
//    @Transient
//    Integer  initialValue=50;
    private Integer capacity=50;
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinColumn
    private Collection<Registration> registrationsOfStudents=new ArrayList<>();
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Course course;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Faculty faculty;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private AcademicBlock academicBlock;
    private Integer availableSeat=capacity-registrationsOfStudents.size();

    public CourseOffering(Integer capacity, Collection<Registration> registrationsOfStudents) {
        this.capacity = capacity;
        this.registrationsOfStudents = registrationsOfStudents;
    }

    public Integer getAvailableSeat() {

        if(getCapacity()!=0){
            return availableSeat;
        }else{
            return 0;
        }
    }

    public void setAvailableSeat(Integer availableSeat) {
        this.availableSeat = availableSeat;
    }
}




