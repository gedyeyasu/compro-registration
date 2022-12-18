package com.miu.registration.Service;


import com.miu.registration.dto.RegistrationEventDTO;
import com.miu.registration.model.Registration;
import com.miu.registration.model.RegistrationEvent;

import java.util.List;

public interface RegistrationEventInterface {

    public List<RegistrationEvent> getAllRegistrationEvent();
    public List< RegistrationEvent> getFetchRegistrationList();
    public void viewRegisterationEvent(RegistrationEventDTO registrationEventDTO);

    void deleteRegistrationList(Long registrationeventId);

    public RegistrationEvent getlatesetevent();


}
