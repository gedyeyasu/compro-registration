package com.miu.registration.dto;

import com.miu.registration.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroupsDTO {

    private Long registrationid;

    private String fpptrack ;

    private String mpptrack;

    @OneToMany
    @JoinColumn
    private List<Student> studentList = new ArrayList<>();
}
