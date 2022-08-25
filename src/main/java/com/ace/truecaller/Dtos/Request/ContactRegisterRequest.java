package com.ace.truecaller.Dtos.Request;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ContactRegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
