package com.sampreeth.aiinterview.service;

import com.sampreeth.aiinterview.model.User;
import com.sampreeth.aiinterview.repository.UserRepository;
import com.sampreeth.aiinterview.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    @Autowired
//    private UserRepository userRepository;

    public String registerUser(User user){

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            return "Email already exists!";
        }

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("CANDIDATE"); // or whatever default role you use
        }

        userRepository.save(user);
        return "User registered successfully";
    }

    public boolean authenticateUser(String email, String rawPassword){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return false;
        }
        return passwordEncoder.matches(rawPassword, optionalUser.get().getPassword());

    }

    @Autowired
    private JwtUtil jwtUtil;

    public String loginUser(String email, String password){
        Optional<User> user = userRepository.findByEmail(email);
        if(user == null || !passwordEncoder.matches(password, user.get().getPassword())){
            return null;
        }
        return jwtUtil.generateToken(user.get().getEmail());
    }
}
