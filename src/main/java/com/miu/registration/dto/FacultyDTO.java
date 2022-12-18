package com.miu.registration.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDTO {
    private Long id;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

}
