package com.ace.truecaller.Service;

import com.ace.truecaller.Dtos.Request.ContactRegisterRequest;
import com.ace.truecaller.Dtos.Request.ContactUpdateRequest;
import com.ace.truecaller.Dtos.Response.BothContactRegisterResponseAndContact;
import com.ace.truecaller.Dtos.Response.ContactDeleteResponse;
import com.ace.truecaller.Dtos.Response.ContactRegisterResponse;
import com.ace.truecaller.Dtos.Response.ContactUpdateResponse;
import com.ace.truecaller.Models.Contact;
import com.ace.truecaller.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public BothContactRegisterResponseAndContact createContact(ContactRegisterRequest contactRegisterRequest) {
        Contact contact = new Contact();
        contact.setFirstName(contactRegisterRequest.getFirstName());
        contact.setLastName(contactRegisterRequest.getLastName());
        contact.setPhoneNumber(contactRegisterRequest.getPhoneNumber());
        contact.setEmail(contactRegisterRequest.getEmail());


        contact = contactRepository.save(contact);
        return new BothContactRegisterResponseAndContact(contact, new ContactRegisterResponse("Contact Successfully Created!"));
    }

    @Override
    public Contact getContact(String contactId) {
        var contact = contactRepository.findContactById(contactId);;
        return contact;
    }

    @Override
    public ContactUpdateResponse updateContact(ContactUpdateRequest contactUpdateRequest) {
        var contact = getContact(contactUpdateRequest.getId());
        if(isEmptyOrIsBlank(contactUpdateRequest.getFirstName())){
            contact.setFirstName(contactUpdateRequest.getFirstName());
        }
        if(isEmptyOrIsBlank(contactUpdateRequest.getLastName())){
            contact.setLastName(contactUpdateRequest.getLastName());
        }
        if(isEmptyOrIsBlank(contactUpdateRequest.getFirstName())){
            contact.setPhoneNumber(contactUpdateRequest.getPhoneNumber());
        }
        if(isEmptyOrIsBlank(contactUpdateRequest.getEmail())){
            contact.setEmail(contactUpdateRequest.getEmail());
        }

        contactRepository.save(contact);

        return new ContactUpdateResponse("Contact Details Successfully Updated!");
    }

    private boolean isEmptyOrIsBlank(String data){
        if(data != null && !data.equals("")){
            return true;
        }
        return false;
    }

    @Override
    public ContactDeleteResponse deleteContact(String id) {
        contactRepository.deleteContactById(id);
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

    @Override
    public List<Contact> getContactFirstName(String firstName) {
        var listOfCContactWithTheSameFirstName = contactRepository.findAll()
                .stream()
                .filter(contact -> contact.getFirstName().equalsIgnoreCase(firstName)).toList();

        return listOfCContactWithTheSameFirstName;
    }

    @Override
    public List<Contact> getContactLastName(String lastName) {
        var listOfCContactWithTheSameLastName = contactRepository.findAll()
                .stream()
                .filter(contact -> contact.getLastName().equalsIgnoreCase(lastName))
                .toList();


        return listOfCContactWithTheSameLastName;
    }

    @Override
    public List<Contact> listOfContactUser() {
        return contactRepository.findAll();
    }


}
