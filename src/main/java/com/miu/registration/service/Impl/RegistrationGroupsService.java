package com.miu.registration.service.Impl;


import com.miu.registration.service.DTO.RegistrationGroupsDTO;
import com.miu.registration.domain.RegistrationGroup;
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
    public List<RegistrationGroup> getAllRegistrationGroups() {
        return null;
    }

    @Override
    public void viewRegistrationGroups(RegistrationGroupsDTO registrationGroupsDTO) {

        RegistrationGroup registrationGroups = new RegistrationGroup();
        BeanUtils.copyProperties(registrationGroupsDTO,registrationGroups);
        registrationGroupsRepository.save(registrationGroups);
    }
}
