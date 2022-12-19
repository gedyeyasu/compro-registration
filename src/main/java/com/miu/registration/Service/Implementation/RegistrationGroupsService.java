package com.miu.registration.Service.Implementation;


import com.miu.registration.Repository.RegistrationGroupsRepository;
import com.miu.registration.Service.RegistrationGroupsInterface;
import com.miu.registration.dto.RegistrationGroupsDTO;
import com.miu.registration.model.RegistrationGroup;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationGroupsService implements RegistrationGroupsInterface {

    @Autowired
    private RegistrationGroupsRepository registrationGroupsRepository;

    @Override
    public List<RegistrationGroup> getAllRegistrationGroups() {
        return null;
    }

    @Override
    public void addRegistrationGroups(RegistrationGroupsDTO registrationGroupsDTO) {

        RegistrationGroup registrationGroups = new RegistrationGroup();
        BeanUtils.copyProperties(registrationGroupsDTO,registrationGroups);
        registrationGroupsRepository.save(registrationGroups);
    }
}
