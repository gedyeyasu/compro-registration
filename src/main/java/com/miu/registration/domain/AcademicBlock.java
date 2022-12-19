package com.miu.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;


    @OneToMany (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn
    private Collection<CourseOffering> courseOfferings;
}
