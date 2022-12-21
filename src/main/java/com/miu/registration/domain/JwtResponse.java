package com.miu.registration.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
//    private final String jwttoken;
    private String jwttoken;
    public String getToken() {
        return this.jwttoken;
    }
}
