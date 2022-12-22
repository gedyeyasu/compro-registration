package com.miu.registration.service.DTO;

import com.miu.registration.domain.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationEventResponseDTO {
    private EventStatus eventStatus;
    private RegistrationEventDTO latestRegistrationEvent;
}
