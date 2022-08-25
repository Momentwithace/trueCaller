package com.ace.truecaller.Dtos.Request;


import lombok.Data;

@Data
public class UpdateRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String userId;
    private String password;
}
