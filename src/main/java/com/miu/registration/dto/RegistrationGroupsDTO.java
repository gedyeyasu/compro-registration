package com.miu.registration.dto;

import com.miu.registration.model.RegistrationGroupEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroupsDTO {

    private RegistrationGroupEnum groupEnum;
    private Long registrationeventid;


}
