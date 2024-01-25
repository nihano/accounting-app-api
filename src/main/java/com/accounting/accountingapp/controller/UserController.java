package com.accounting.accountingapp.controller;

import com.accounting.accountingapp.dto.ResponseWrapper;
import com.accounting.accountingapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/list")
    public ResponseEntity<ResponseWrapper> listUsers(){
        return ResponseEntity.ok()
                .body(new ResponseWrapper("Users are successfully retrieved", userService.listUsers()));

    }
}
