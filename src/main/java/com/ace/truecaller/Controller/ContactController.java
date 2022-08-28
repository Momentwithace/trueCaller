package com.ace.truecaller.Controller;

import com.ace.truecaller.Dtos.Request.ContactDeleteRequest;
import com.ace.truecaller.Dtos.Request.ContactRegisterRequest;
import com.ace.truecaller.Dtos.Request.ContactUpdateRequest;
import com.ace.truecaller.Dtos.Response.ContactDeleteResponse;
import com.ace.truecaller.Dtos.Response.ContactRegisterResponse;
import com.ace.truecaller.Dtos.Response.ContactUpdateResponse;
import com.ace.truecaller.Models.Contact;
import com.ace.truecaller.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ContactRegisterResponse createContact(@RequestBody ContactRegisterRequest contactRegisterRequest){
        return contactService.createContact(contactRegisterRequest).getContactRegisterResponse();
    }

    @GetMapping("/{contactId}")
    public Contact getContact (@PathVariable String contactId){
        return contactService.getContact(contactId);
    }

    @PatchMapping("/update")
    public ContactUpdateResponse updateContact(@RequestBody ContactUpdateRequest contactUpdateRequest){
        return contactService.updateContact(contactUpdateRequest);
    }

    @DeleteMapping("/{contactId}")
    public ContactDeleteResponse deleteContact(@PathVariable String contactId){
        return contactService.deleteContact(contactId);
    }

    @GetMapping("/all-contact")
    public Long getNumberOfContact(){
        return contactService.getNoOfContact();
    }

    @GetMapping("/list-of-contact")
    public List<Contact> getListOfContact(){
        return contactService.listOfContactUser();
    }

    @GetMapping("firstName/{firstName}")
    public List<Contact> getListOfContactWithSameFirstName(@PathVariable("firstName") String firstName){
        return contactService.getContactFirstName(firstName);
    }

    @GetMapping("/otherName/{lastName}")
    public List<Contact> getListOfContactWithSameLastName(@PathVariable("lastName") String lastName){
        return contactService.getContactLastName(lastName);
    }
}
