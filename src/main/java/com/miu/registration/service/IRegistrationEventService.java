package com.miu.registration.service;


import com.miu.registration.domain.EventStatus;
import com.miu.registration.domain.RegistrationEvent;
import com.miu.registration.service.DTO.RegistrationEventDTO;

import java.util.List;

public interface IRegistrationEventService {

    public List<RegistrationEvent> getAllRegistrationEvent();

//    public void viewRegisterationEvent(RegistrationEventDTO registrationEventDTO);
    public RegistrationEvent latest(long studentID);
}
