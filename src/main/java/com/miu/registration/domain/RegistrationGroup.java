package com.miu.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroup{
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated
    private RegistrationGroupEnum groupEnum;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

//    @ManyToMany
//    private List<CourseOffering> courseOfferings = new ArrayList<>();


    @JoinColumn(name="academic_block_id")
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<AcademicBlock> academicBlocks ;

    public void addStudent(Student student){
        students.add(student);
    }


}
