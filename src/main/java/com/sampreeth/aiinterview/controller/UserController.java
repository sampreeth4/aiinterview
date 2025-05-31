package com.sampreeth.aiinterview.controller;

import com.sampreeth.aiinterview.dto.LoginRequest;
import com.sampreeth.aiinterview.model.User;
import com.sampreeth.aiinterview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public String register(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest request){
        String token = userService.loginUser(request.getEmail(), request.getPassword());

        if(token == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        return ResponseEntity.ok(token);
    }

    @GetMapping("/secure-test")
    public ResponseEntity<String> testSecure() {
        return ResponseEntity.ok("You are authorized!");
    }

}



