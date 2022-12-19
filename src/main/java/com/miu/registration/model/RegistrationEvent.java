package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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


    @JoinColumn(name="registrationeventid")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<RegistrationGroup> registrationGroupsList ;
}
