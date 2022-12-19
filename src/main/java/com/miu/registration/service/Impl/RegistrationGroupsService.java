package com.miu.registration.service.Impl;


import com.miu.registration.service.DTO.RegistrationGroupsDTO;
import com.miu.registration.domain.RegistrationGroups;
import com.miu.registration.repositories.RegistrationGroupsRepository;
import com.miu.registration.service.IRegistrationGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationGroupsService implements IRegistrationGroupService {

    @Autowired
    private RegistrationGroupsRepository registrationGroupsRepository;

    @Override
    public List<RegistrationGroups> getAllRegistrationGroups() {
        return null;
    }

    @Override
    public void viewRegistrationGroups(RegistrationGroupsDTO registrationGroupsDTO) {

        RegistrationGroups registrationGroups = new RegistrationGroups();
        BeanUtils.copyProperties(registrationGroupsDTO,registrationGroups);
        registrationGroupsRepository.save(registrationGroups);
    }
}
