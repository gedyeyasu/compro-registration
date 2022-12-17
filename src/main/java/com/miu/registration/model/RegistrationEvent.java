package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long registrationeventid;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "yyyy-MM-dd")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "yyyy-MM-dd")
    private Date endDate ;

    @OneToMany
    @JoinColumn(name="re_id")
    private List<RegistrationGroups> registrationGroupsList = new ArrayList<RegistrationGroups>();
}
