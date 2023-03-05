package com.flickspot.demo.controller;

import com.flickspot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) throws Exception {
        userService.createUser(userDto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
        final UserDetails userDetails = userService.loadUserByUsername(userDto.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") long userId) {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") long userId, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(userId, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}