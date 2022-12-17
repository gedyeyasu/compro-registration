package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long registrationeventid;
    private LocalDate startDate;
    private LocalDate endDate ;

    @OneToMany
    @JoinColumn(name="re_id")
    private List<RegistrationGroups> registrationGroupsList = new ArrayList<RegistrationGroups>();
}
