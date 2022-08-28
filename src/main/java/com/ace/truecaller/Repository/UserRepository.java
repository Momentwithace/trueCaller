package com.ace.truecaller.Repository;

import com.ace.truecaller.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
        User findUserByUserName(String username);

        User findUserByFirstName();
}
