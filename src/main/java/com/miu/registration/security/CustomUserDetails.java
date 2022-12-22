package com.miu.registration.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miu.registration.domain.Role;
import com.miu.registration.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class CustomUserDetails implements UserDetails {
        private String username;

        @JsonIgnore
        private String password;

        private Role role;

        private Long id;


        public CustomUserDetails(User user) {
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.role = user.getRole();
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<SimpleGrantedAuthority> result= new ArrayList<>();
            result.add(new SimpleGrantedAuthority(this.role.toString()));
            return result;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

