package com.tpe.controller;


import com.tpe.dto.Userrequest;
import com.tpe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("register")//http://localhost:8080/register
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping//http://localhost:8080/register + POST +JSON
    public ResponseEntity<String> register(@Valid @RequestBody Userrequest userRequest){
        userService.saveUser(userRequest);
        String response = "User registered successfully";
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
