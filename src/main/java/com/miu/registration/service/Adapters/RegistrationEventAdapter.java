package com.miu.registration.service.Adapters;

import com.miu.registration.domain.RegistrationEvent;
import com.miu.registration.service.DTO.RegistrationEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistrationEventAdapter implements IAdapter<RegistrationEvent, RegistrationEventDTO> {

    @Override
    public RegistrationEvent getDomainFromDTO(RegistrationEventDTO registrationEventDTO) {
        return null;
    }

    @Override
    public RegistrationEventDTO getDTOFromDomain(RegistrationEvent registrationEvent) {
        RegistrationEventDTO registrationEventDTO = new RegistrationEventDTO();
        registrationEventDTO.setRegistrationGroups(registrationEvent.getRegistrationGroups());
        registrationEventDTO.setStartDate(registrationEvent.getStartDate());
        return registrationEventDTO;
    }

    @Override
    public List<RegistrationEvent> getDomainsFromDTOs(List<RegistrationEventDTO> registrationEventDTOS) {
        return null;
    }

    @Override
    public List<RegistrationEventDTO> getDTOsFromDomains(List<RegistrationEvent> registrationEvents) {
        return null;
    }
}
