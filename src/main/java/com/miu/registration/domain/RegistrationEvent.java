package com.miu.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEvent {

    @Id
    @GeneratedValue
    private Long Id;
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate endDate ;

    @OneToMany
    //@JoinColumn(name="Registration Event_Id")
    private List<RegistrationGroup> registrationGroups = new ArrayList<RegistrationGroup>();

    public EventStatus getEventStatus() {
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isAfter(ChronoLocalDate.from(this.getStartDate().atStartOfDay()).minus(Period.ofDays(1))) &&
                currentDate.isBefore(ChronoLocalDate.from(this.getEndDate().atTime(LocalTime.parse("11:59pm")))))
            return EventStatus.OPEN;
        else
            return EventStatus.CLOSED;
    }
}
