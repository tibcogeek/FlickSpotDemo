package com.flickspot.demo.service;

import com.flickspot.demo.dto.UserDTO;
import com.flickspot.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    User register(UserDTO userDTO);

    User findByEmail(String email);

    User findById(Long id);

    User createUser(UserDTO userDto);

    

    


    UserDetails loadUserByUsername(String email);

    UserDTO getUserById(long userId);

    UserDTO updateUser(long userId, UserDTO userDto);

    void deleteUser(long userId);
}
