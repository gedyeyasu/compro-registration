package com.miu.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    private AcademicBlockEnum academicBlockEnum;
    private String code;
    private String name;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "yyyy-MM-dd")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "yyyy-MM-dd")
    private Date endDate;

//    @OneToMany
//    private List<CourseOffering> courseOfferingList = new ArrayList<>();

    @OneToMany (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn
    private Collection<CourseOffering> courseOfferings;
}




