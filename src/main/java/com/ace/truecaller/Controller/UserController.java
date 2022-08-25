package com.ace.truecaller.Controller;


import com.ace.truecaller.Dtos.Request.UpdateRequest;
import com.ace.truecaller.Dtos.Request.UserRequest;
import com.ace.truecaller.Dtos.Response.DeleteResponse;
import com.ace.truecaller.Dtos.Response.RegisterResponse;
import com.ace.truecaller.Dtos.Response.UpdateResponse;
import com.ace.truecaller.Models.User;
import com.ace.truecaller.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public RegisterResponse createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest).getRegisterResponse();

    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @PatchMapping
    public ResponseEntity<?> updateUser(@RequestBody UpdateRequest updateRequest){
        log.info("updating user {}",updateRequest);
       return new ResponseEntity<>( userService.updateUser(updateRequest), HttpStatus.OK);
    }

    @DeleteMapping
    public DeleteResponse deleteUser(String userName){
        return userService.deleteUser(userName);
    }

    @GetMapping("/all-users")
    public Long getNumberOfUser(){
      return userService.getNumberOfUser();
    }

    @GetMapping("/users-list")
    public List<User> getListOfUser(){
        return userService.getListOfUser();
    }
}
