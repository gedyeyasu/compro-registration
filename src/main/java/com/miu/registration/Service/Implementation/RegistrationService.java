package com.miu.registration.Service.Implementation;

import com.miu.registration.Repository.RegistrationRepository;
import com.miu.registration.Service.RegistrationInterface;
import com.miu.registration.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService implements RegistrationInterface {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Override
    public List<Registration> RegistrationList() {
        return registrationRepository.findAll();
    }
}
