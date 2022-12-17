package com.miu.registration.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Data {
    @Id
    @GeneratedValue
    private long id;
    private String test;

    public Data(){};
    public Data(String test){
        this.test =test;
    }
}
