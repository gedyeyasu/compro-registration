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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroup{
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private RegistrationGroupEnum groupEnum;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;

    @JoinColumn(name="academic_block_id")
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<AcademicBlock> academicBlocks; ;





}
