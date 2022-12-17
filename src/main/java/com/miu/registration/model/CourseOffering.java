package com.miu.registration.model;

import javax.persistence.*;

@Entity
@Table
public class CourseOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int courseId;

    private String code ;




}
