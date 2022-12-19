package com.miu.registration.service;


import com.miu.registration.domain.RegistrationEvent;
import com.miu.registration.service.DTO.RegistrationEventDTO;

import java.util.List;

public interface RegistrationEventInterface {

    public List<RegistrationEvent> getAllRegistrationEvent();

    public void viewRegisterationEvent(RegistrationEventDTO registrationEventDTO);
}
