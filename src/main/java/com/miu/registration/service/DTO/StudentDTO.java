package com.miu.registration.service.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String username;

    @JsonIgnore
    private String password;
    private Long studentId;
    private AddressDTO mailAddress;
    private AddressDTO homeAddress;

    public StudentDTO(String firstName, String lastName, String email, Long studentId, String userName, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentId = studentId;
        this.username = userName;
        this.password = password;
    }

}
