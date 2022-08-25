package com.ace.truecaller.Repository;

import com.ace.truecaller.Models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
    Contact findContactByEmail(String email);
    Contact findContactById(String id);

    void deleteContactById(String id);
}
