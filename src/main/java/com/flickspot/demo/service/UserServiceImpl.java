package com.flickspot.demo.service;

import com.flickspot.demo.dto.UserDTO;
import com.flickspot.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public class UserServiceImpl implements UserService {



    @Override
    public User register(UserDTO userDTO) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User createUser(UserDTO userDto) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return null;
    }


    @Override
    public UserDTO getUserById(long userId) {
        return null;
    }

    @Override
    public UserDTO updateUser(long userId, UserDTO userDto) {
        return null;
    }

    @Override
    public void deleteUser(long userId) {

    }


}
