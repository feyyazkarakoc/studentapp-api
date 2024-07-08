package com.tpe.controller;


import com.tpe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")//http://localhost:8080/register
public class UserController {


    @Autowired
    private UserService userService;
}
