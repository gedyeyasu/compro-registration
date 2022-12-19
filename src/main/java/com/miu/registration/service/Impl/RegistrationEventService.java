package com.miu.registration.service.Impl;


import com.miu.registration.repositories.RegistrationEventRepository;
import com.miu.registration.service.DTO.RegistrationEventDTO;
import com.miu.registration.domain.RegistrationEvent;
import com.miu.registration.service.IRegistrationEventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationEventService implements IRegistrationEventService {

    @Autowired
    private RegistrationEventRepository registrationEventRepository;

    @Override
    public List<RegistrationEvent> getAllRegistrationEvent() {
        return registrationEventRepository.findAll();
    }

    @Override
    public void viewRegisterationEvent(RegistrationEventDTO registrationEventDTO) {

        RegistrationEvent registrationEvent = new RegistrationEvent();
        BeanUtils.copyProperties(registrationEventDTO, registrationEvent);
        registrationEventRepository.save(registrationEvent);

    }
}
