package com.ace.truecaller.Service;

import com.ace.truecaller.Dtos.Request.ContactDeleteRequest;
import com.ace.truecaller.Dtos.Request.ContactRegisterRequest;
import com.ace.truecaller.Dtos.Request.ContactUpdateRequest;
import com.ace.truecaller.Dtos.Response.ContactDeleteResponse;
import com.ace.truecaller.Dtos.Response.ContactRegisterResponse;
import com.ace.truecaller.Dtos.Response.ContactUpdateResponse;
import com.ace.truecaller.Models.Contact;
import com.ace.truecaller.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ContactRegisterResponse createContact(ContactRegisterRequest contactRegisterRequest) {
        Contact contact = new Contact();
        contact.setFirstName(contactRegisterRequest.getFirstName());
        contact.setLastName(contactRegisterRequest.getLastName());
        contact.setPhoneNumber(contactRegisterRequest.getPhoneNumber());
        contact.setEmail(contactRegisterRequest.getEmail());


        contactRepository.save(contact);
        ContactRegisterResponse contactRegisterResponse = new ContactRegisterResponse();
        contactRegisterResponse.setId(contact.getId());
        contactRegisterResponse.setMessage("Contact Successfully Created!");
        return contactRegisterResponse;
    }

    @Override
    public Contact getContact(String id) {
        var contact = contactRepository.findContactById(id);;
        return contact;
    }

    @Override
    public ContactUpdateResponse updateContact(ContactUpdateRequest contactUpdateRequest) {
        var contact = getContact(contactUpdateRequest.getId());
        contact.setFirstName(contactUpdateRequest.getFirstName());
        contact.setLastName(contactUpdateRequest.getLastName());
        contact.setPhoneNumber(contactUpdateRequest.getPhoneNumber());
        contact.setEmail(contactUpdateRequest.getEmail());

        contactRepository.save(contact);

        return new ContactUpdateResponse("Contact Details Successfully Updated!");
    }

    @Override
    public ContactDeleteResponse deleteContact(String id) {
        var contact = contactRepository.findContactById(id);
        contactRepository.deleteContactById(contact.getId());

        return new ContactDeleteResponse("Deleted");
    }

    @Override
    public void clearDatabase() {
        contactRepository.deleteAll();
    }

    @Override
    public long getNoOfContact() {
        return contactRepository.count();
    }
}
