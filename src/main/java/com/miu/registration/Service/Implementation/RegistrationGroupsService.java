package com.miu.registration.Service.Implementation;


import com.miu.registration.Repository.RegistrationGroupsRepository;
import com.miu.registration.Service.RegistrationGroupsInterface;
import com.miu.registration.dto.RegistrationGroupsDTO;
import com.miu.registration.model.RegistrationGroups;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationGroupsService implements RegistrationGroupsInterface {

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
