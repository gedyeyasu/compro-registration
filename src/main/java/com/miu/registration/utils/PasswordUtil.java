package com.miu.registration.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {
    public static String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
