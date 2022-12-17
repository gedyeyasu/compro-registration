package com.miu.registration.Service;

import com.miu.registration.Repository.RegistrationEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationEventService {

    @Autowired
    private RegistrationEventRepository registrationEventRepository;
}
