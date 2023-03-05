package com.flickspot.demo.service;

import com.flickspot.demo.dto.UserDTO;
import com.flickspot.demo.model.User;

public interface UserService {

    User register(UserDTO userDTO);

    User findByEmail(String email);

    User findById(Long id);
}
