package com.ace.truecaller.Dtos.Response;

import lombok.Data;
@Data
public class UpdateResponse {

    private String message;
    public UpdateResponse(String message) {
        this.message = message;
    }
}
