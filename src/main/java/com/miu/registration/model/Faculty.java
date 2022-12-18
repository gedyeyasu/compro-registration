package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty extends Person{
    //private Long facultyId;


    private String title;

    @OneToMany
    private List<CourseOffering> courseOfferingList = new ArrayList<>();


}

