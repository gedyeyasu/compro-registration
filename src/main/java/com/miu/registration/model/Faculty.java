package com.miu.registration.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Faculty extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String facultyId;

    private String firstname;

    private String email ;

    private String title;

    @OneToMany
    @JoinColumn(name = "fc_id")
    private List<CourseOffering> courseOfferingList = new ArrayList<CourseOffering>();


    public Faculty(int id, String street, String city, String postalCode, String province, String facultyId, String firstname, String email, String title, List<CourseOffering> courseOfferingList) {
        super(id, street, city, postalCode, province);
        this.facultyId = facultyId;
        this.firstname = firstname;
        this.email = email;
        this.title = title;
        this.courseOfferingList = courseOfferingList;
    }

    public Faculty() {

    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
