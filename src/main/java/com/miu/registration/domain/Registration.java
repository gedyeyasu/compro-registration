package com.miu.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne( cascade = CascadeType.ALL)
    private Student student;

    @ManyToOne( cascade = CascadeType.ALL)
    private CourseOffering courseOffering;

}
