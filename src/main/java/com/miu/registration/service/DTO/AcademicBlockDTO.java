package com.miu.registration.service.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicBlockDTO {
    private long id;
    private String code;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    private Collection<CourseOfferingDTO> courseOfferings;

    public void addCourseOfferings(Collection<CourseOfferingDTO> courseOfferings){
        this.courseOfferings.addAll(courseOfferings);
    }
}
