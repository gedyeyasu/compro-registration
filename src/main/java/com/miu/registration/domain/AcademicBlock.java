package com.miu.registration.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;


@AllArgsConstructor
@NoArgsConstructor
@Data
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
    @JoinColumn(name = "Academic_Block")
    private Collection<CourseOffering> courseOfferings;
}
