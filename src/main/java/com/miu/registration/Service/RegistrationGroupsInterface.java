package com.miu.registration.Service;

import com.miu.registration.dto.RegistrationGroupsDTO;
import com.miu.registration.model.RegistrationGroup;

import java.util.List;

public interface RegistrationGroupsInterface {

    public List<RegistrationGroup> getAllRegistrationGroups();
    public void addRegistrationGroups(RegistrationGroupsDTO registrationGroupsDTO);

}
