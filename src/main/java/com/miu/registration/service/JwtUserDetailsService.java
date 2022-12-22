package com.miu.registration.service;

import com.miu.registration.domain.*;
import com.miu.registration.repositories.AdminRepository;
import com.miu.registration.repositories.FacultyRepository;
import com.miu.registration.repositories.StudentRepository;
import com.miu.registration.repositories.UserRepository;
import com.miu.registration.service.Adapters.UserAdapter;
import com.miu.registration.service.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private UserAdapter userAdapter;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.miu.registration.domain.User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public com.miu.registration.domain.User save(UserDTO userDTO){
        com.miu.registration.domain.User user = userAdapter.getUserFromUserDTO(userDTO);
        user.setUsername(user.getUsername());
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public com.miu.registration.domain.User getRequestUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        com.miu.registration.domain.User domainUser = userRepository.findByUsername(user.getUsername());
        return domainUser;
    }
    public void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
    public Person getRequestDomain(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        com.miu.registration.domain.User domainUser = userRepository.findByUsername(user.getUsername());
        if(domainUser.getRole() == Role.FACULTY){
            Faculty faculty = facultyRepository.findFacultiesByUser(domainUser);
            return faculty;
        }
        if(domainUser.getRole() == Role.ADMIN){
            Admin admin = adminRepository.findAdminByUser(domainUser);
            return admin;
        } else{
            Student student = studentRepository.findStudentByUser(domainUser);
            return  student;
        }
    }
}
