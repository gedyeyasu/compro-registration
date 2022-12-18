package com.miu.registration.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseofferingId;
    private String courseoffercode;
    private int capacityofStudents;
    private int avaivableseats;

    @ManyToOne
    @JoinColumn(name="course_c")
    private Course course;

    @ManyToOne
    @JoinTable(name="course_acaedmicblock")
    private AcademicBlock academicBlock;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;



}
