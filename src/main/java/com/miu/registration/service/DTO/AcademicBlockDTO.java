package com.miu.registration.service.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter


public class AcademicBlockDTO {
    private long id;
    private String code;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    private Collection<CourseOfferingDTO> courseOfferings;
}
