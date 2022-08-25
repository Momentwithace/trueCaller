package com.ace.truecaller.Service;

import com.ace.truecaller.Dtos.Request.ContactDeleteRequest;
import com.ace.truecaller.Dtos.Request.ContactRegisterRequest;
import com.ace.truecaller.Dtos.Request.ContactUpdateRequest;
import com.ace.truecaller.Dtos.Response.ContactRegisterResponse;
import com.ace.truecaller.Models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
class ContactServiceImplTest {

    @Autowired
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService.clearDatabase();
    }


    @Test
    public void testThatWeCanAddContact(){
        ContactRegisterRequest contactRegisterRequest = new ContactRegisterRequest();
        contactRegisterRequest.setFirstName("Boyo");
        contactRegisterRequest.setLastName("Micheal");
        contactRegisterRequest.setPhoneNumber("090765546");
        contactRegisterRequest.setEmail("boyo@gmail.com");

        contactService.createContact(contactRegisterRequest);

        assertEquals(1L, contactService.getNoOfContact());
    }

    @Test
    public void testThatWeCanGetAContact(){
        ContactRegisterRequest contactRegisterRequest = new ContactRegisterRequest();
        contactRegisterRequest.setFirstName("benson");
        contactRegisterRequest.setLastName("Mike");
        contactRegisterRequest.setPhoneNumber("090765546");
        contactRegisterRequest.setEmail("ben@gmail.com");

        ContactRegisterResponse contactRegisterResponse = contactService.createContact(contactRegisterRequest);

        Contact contact = contactService.getContact(contactRegisterResponse.getId());
        assertEquals("benson", contact.getFirstName());
    }

    @Test
    public void testThatWeCanUpdateContactInformation(){
        ContactRegisterRequest contactRegisterRequest = new ContactRegisterRequest();
        contactRegisterRequest.setFirstName("Boyo");
        contactRegisterRequest.setLastName("Micheal");
        contactRegisterRequest.setPhoneNumber("090765546");
        contactRegisterRequest.setEmail("boyo@gmail.com");

        ContactRegisterResponse contactRegisterResponse = contactService.createContact(contactRegisterRequest);

        ContactUpdateRequest contactUpdateRequest = new ContactUpdateRequest();
        contactUpdateRequest.setLastName("ezekiel");
        contactUpdateRequest.setPhoneNumber("09087675");
        contactUpdateRequest.setId(contactRegisterResponse.getId());

        contactService.updateContact(contactUpdateRequest);

        Contact contact = contactService.getContact(contactRegisterResponse.getId());

        assertEquals(1, contactService.getNoOfContact());
        assertEquals("ezekiel", contact.getLastName());
    }

    @Test
    public void testThatWeCanDeleteConUsingContactId(){
        ContactRegisterRequest contactRegisterRequest = new ContactRegisterRequest();
        contactRegisterRequest.setFirstName("Dan");
        contactRegisterRequest.setLastName("Ray");
        contactRegisterRequest.setEmail("ray@gmail.com");
        contactRegisterRequest.setPhoneNumber("09087865");

        ContactRegisterResponse contactRegisterResponse = contactService.createContact(contactRegisterRequest);

        ContactRegisterRequest contactRegisterRequest1 = new ContactRegisterRequest();
        contactRegisterRequest1.setFirstName("Dan");
        contactRegisterRequest1.setLastName("Ray");
        contactRegisterRequest1.setEmail("ray@gmail.com");
        contactRegisterRequest1.setPhoneNumber("09087865");

        ContactRegisterResponse contactRegisterResponse1 = contactService.createContact(contactRegisterRequest);

        contactService.deleteContact("1");

        assertEquals(1, contactService.getNoOfContact());
    }
}