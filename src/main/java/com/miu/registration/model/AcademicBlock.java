package com.miu.registration.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int acdemicId;

    private String code ;

    private String firstname ;

    private String lastname ;

    private LocalDate startDate ;

    private LocalDate endDate ;

    @OneToMany
    @JoinColumn(name = "Ac_id")
    private List<CourseOffering> courseOfferingList = new ArrayList<CourseOffering>();

    public AcademicBlock(int acdemicId, String code, String firstname, String lastname, LocalDate startDate, LocalDate endDate, List<CourseOffering> courseOfferingList) {
        this.acdemicId = acdemicId;
        this.code = code;
        this.firstname = firstname;
        this.lastname = lastname;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseOfferingList = courseOfferingList;
    }

    public AcademicBlock() {

    }

    public int getAcdemicId() {
        return acdemicId;
    }

    public void setAcdemicId(int acdemicId) {
        this.acdemicId = acdemicId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
