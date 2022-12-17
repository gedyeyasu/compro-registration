package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long academicid;
    private String academiccode;
    private String fullname;
    private LocalDate startDate;
    private LocalDate endDate;



}
