package com.miu.registration.service;




import com.miu.registration.service.DTO.RegistrationRequestDTO;

import java.util.Collection;

public interface IRegistrationRequestService {
    Collection<RegistrationRequestDTO> getAllSubmitRequests();
    RegistrationRequestDTO getSubmittedRequest(long id);
    void createSubmittedRequest(RegistrationRequestDTO requestDTO);
    void updateRequest(long id,RegistrationRequestDTO registrationRequestDTO);
    void deleteRequest(long id);


}
