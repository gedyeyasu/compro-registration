package com.miu.registration.domain;

import com.miu.registration.service.DTO.CourseOfferingDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "Academic_Block")
    private Collection<CourseOffering> courseOfferings = new ArrayList<>();
    private Semester semester;

    public AcademicBlock(String code, String name, LocalDate startDate, LocalDate endDate, Semester semester) {
        this.code = code;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.semester = semester;
    }

    public void addCourseOffering(CourseOffering courseOffering){
        this.courseOfferings.add(courseOffering);
    }
}
