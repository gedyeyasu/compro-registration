package com.miu.registration.Service;


import com.miu.registration.Repository.RegistrationGroupsRepository;
import com.miu.registration.model.RegistrationGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationGroupsService {

    @Autowired
    private RegistrationGroupsRepository registrationGroupsRepository;
}
