package com.ace.truecaller.Dtos.Response;

import com.ace.truecaller.Models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BothRegisterAndUser {
    private User user;
    private RegisterResponse registerResponse;
}
