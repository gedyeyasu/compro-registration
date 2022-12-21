package com.miu.registration.service.Adapters;

import com.miu.registration.domain.User;
import com.miu.registration.service.DTO.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    public User getUserFromUserDTO(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }
    public UserDTO getUserDTOFromUser(User user){
        UserDTO userDTO = new UserDTO();
        user.setUsername(userDTO.getUsername());
        user.setRole((user.getRole()));
        return userDTO;
    }
}
