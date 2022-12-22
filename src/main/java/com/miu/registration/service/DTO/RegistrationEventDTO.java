package com.miu.registration.service.DTO;

import com.miu.registration.domain.RegistrationGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEventDTO {

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate endDate ;

    private List<RegistrationGroup> registrationGroups = new ArrayList<>();
}
