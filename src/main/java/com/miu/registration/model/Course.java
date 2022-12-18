package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long courseId;
    private String coursecode;
    private String coursename;
    private String description;
    @OneToMany
    @JoinColumn(name="course_id")
    private List<CourseOffering> courseOfferingList = new ArrayList<>();



}
