package com.miu.registration.Service;

import com.miu.registration.dto.RegistrationGroupsDTO;
import com.miu.registration.model.RegistrationGroups;

import java.util.List;

public interface RegistrationGroupsInterface {

    public List<RegistrationGroups> getAllRegistrationGroups();
    public void viewRegistrationGroups(RegistrationGroupsDTO registrationGroupsDTO);

}
