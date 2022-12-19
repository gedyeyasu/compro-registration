package com.miu.registration.Service;

import com.miu.registration.model.Registration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegistrationInterface  {
    public List<Registration> registrationList();
}
