package com.miu.registration.domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.DenyAll;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private String description;

}
