package com.miu.registration.service;




import com.miu.registration.service.DTO.RegistrationRequestDTO;
import com.miu.registration.service.DTO.RegistrationRequestResponseDTO;

import java.util.Collection;
import java.util.List;

public interface IRegistrationRequestService {
    Collection<RegistrationRequestDTO> getAllRegistrationRequests();
    List<RegistrationRequestDTO> getRegistrationRequestByStudentId(long id);
    void createRegistrationRequest(RegistrationRequestResponseDTO requestDTO) throws Exception;
    void updateRegistrationRequest(long id, RegistrationRequestDTO registrationRequestDTO);
    void deleteRegistrationRequest(long id);


}
