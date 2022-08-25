package com.ace.truecaller.Service;

import com.ace.truecaller.Dtos.Request.ContactDeleteRequest;
import com.ace.truecaller.Dtos.Request.ContactRegisterRequest;
import com.ace.truecaller.Dtos.Request.ContactUpdateRequest;
import com.ace.truecaller.Dtos.Response.ContactDeleteResponse;
import com.ace.truecaller.Dtos.Response.ContactRegisterResponse;
import com.ace.truecaller.Dtos.Response.ContactUpdateResponse;
import com.ace.truecaller.Dtos.Response.RegisterResponse;
import com.ace.truecaller.Models.Contact;
import org.springframework.beans.factory.annotation.Autowired;

public interface ContactService {

    ContactRegisterResponse createContact(ContactRegisterRequest contactRegisterRequest);
    Contact getContact(String id);
    ContactUpdateResponse updateContact(ContactUpdateRequest contactUpdateRequest);
    ContactDeleteResponse deleteContact(String id);

    void clearDatabase();

    long getNoOfContact();
}
