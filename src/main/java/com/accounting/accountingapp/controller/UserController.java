package com.accounting.accountingapp.controller;

import com.accounting.accountingapp.dto.ResponseWrapper;
import com.accounting.accountingapp.dto.UserDto;
import com.accounting.accountingapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/create")
    public ResponseEntity<ResponseWrapper> getCreateUserForm(){
        return ResponseEntity.ok(new ResponseWrapper("User create page is successfully retrieved",new UserDto()));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseWrapper> createUser(@RequestBody UserDto userDto){
        userService.save(userDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseWrapper("User is successfully created", userDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseWrapper> updateUser(@RequestBody UserDto userDto, @PathVariable("id") Long id ){
        userService.update(userDto, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseWrapper("User is successfully updated", userDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> deleteUser(@PathVariable("id") Long id, @RequestBody UserDto userDto){
        userService.delete(id, userDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseWrapper("User is successfully deleted", userDto));
    }
}
