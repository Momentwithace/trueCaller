package com.ace.truecaller.Dtos.Request;


import lombok.Data;

@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String userName;
    private String password;
}
