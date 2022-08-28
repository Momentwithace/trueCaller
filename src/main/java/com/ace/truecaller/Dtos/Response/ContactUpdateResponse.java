package com.ace.truecaller.Dtos.Response;

import lombok.Data;

@Data
public class ContactUpdateResponse {
    private String message;
    public ContactUpdateResponse(String message) {
        this.message = message;
    }
}
