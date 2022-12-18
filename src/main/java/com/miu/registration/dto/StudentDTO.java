package com.miu.registration.dto;

import com.miu.registration.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Address mailAddress;
    private Address homeAddress;

    // private Long studentId;

}