package com.miu.registration.service;


import com.miu.registration.domain.RegistrationGroups;
import com.miu.registration.service.DTO.RegistrationGroupsDTO;

import java.util.List;

public interface RegistrationGroupsInterface {

    public List<RegistrationGroups> getAllRegistrationGroups();
    public void viewRegistrationGroups(RegistrationGroupsDTO registrationGroupsDTO);

}
