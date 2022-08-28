package com.ace.truecaller.Dtos.Response;

import com.ace.truecaller.Models.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BothContactRegisterResponseAndContact {
    private Contact contact;
    private ContactRegisterResponse contactRegisterResponse;

}
