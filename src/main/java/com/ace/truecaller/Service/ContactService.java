package com.ace.truecaller.Service;

import com.ace.truecaller.Dtos.Request.ContactDeleteRequest;
import com.ace.truecaller.Dtos.Request.ContactRegisterRequest;
import com.ace.truecaller.Dtos.Request.ContactUpdateRequest;
import com.ace.truecaller.Dtos.Response.*;
import com.ace.truecaller.Models.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

public interface ContactService {

    BothContactRegisterResponseAndContact createContact(ContactRegisterRequest contactRegisterRequest);
    Contact getContact(String contactId);
    ContactUpdateResponse updateContact(ContactUpdateRequest contactUpdateRequest);
    ContactDeleteResponse deleteContact(String id);

    void clearDatabase();

    long getNoOfContact();

    List<Contact> getContactFirstName(String firstName);

    List<Contact> getContactLastName(String lastName);

    List<Contact> listOfContactUser();
}
