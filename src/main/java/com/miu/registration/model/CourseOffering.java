package com.miu.registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int courseId;

    private String code ;


}
