package com.example.users_demo.controller;

import com.example.users_demo.entities.UserInfo;
import com.example.users_demo.repo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @PostMapping("/register")
    public String addUser(@RequestBody UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "User added successfully";
    }

    @GetMapping("/loadForgotPassword")
    public String loadForgotPassword(){
        return "Forgot password";
    }

    @GetMapping("/loadResetPassword")
    public String loadResetPassword(){
        return "reset_password";
    }
}
