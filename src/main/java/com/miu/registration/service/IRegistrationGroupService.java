package com.miu.registration.service;


import com.miu.registration.domain.RegistrationGroup;
import com.miu.registration.service.DTO.RegistrationGroupsDTO;

import java.util.List;

public interface IRegistrationGroupService {

    public List<RegistrationGroup> getAllRegistrationGroups();
    public void viewRegistrationGroups(RegistrationGroupsDTO registrationGroupsDTO);

}
