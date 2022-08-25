package com.ace.truecaller.Dtos.Request;


import lombok.Data;

@Data
public class ContactUpdateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String id;
}
