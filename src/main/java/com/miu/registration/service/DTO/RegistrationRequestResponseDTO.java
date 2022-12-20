package com.miu.registration.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RegistrationRequestResponseDTO {
    private long studentId;
    private List<RegistrationRequestDTO> registrationRequestDTOS;
}
