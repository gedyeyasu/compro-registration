package com.miu.registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

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

    public AcademicBlock(int acdemicId, String code, String firstname, String lastname, LocalDate startDate, LocalDate endDate) {
        this.acdemicId = acdemicId;
        this.code = code;
        this.firstname = firstname;
        this.lastname = lastname;
        this.startDate = startDate;
        this.endDate = endDate;
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
