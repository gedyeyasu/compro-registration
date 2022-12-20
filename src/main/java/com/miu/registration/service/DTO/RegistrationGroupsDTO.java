package com.miu.registration.service.DTO;

import com.miu.registration.domain.RegistrationGroupEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroupsDTO {


        private RegistrationGroupEnum groupEnum;
        private Long registrationEventId;
        private List<StudentDTO> studentDTOS;
        private List<CourseOfferingDTO> courseOfferings;
        private Collection<AcademicBlockDTO> academicBlocks;



    }