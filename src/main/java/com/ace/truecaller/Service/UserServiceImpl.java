package com.ace.truecaller.Service;

import com.ace.truecaller.Dtos.Request.UpdateRequest;
import com.ace.truecaller.Dtos.Request.UserRequest;
import com.ace.truecaller.Dtos.Response.BothRegisterAndUser;
import com.ace.truecaller.Dtos.Response.DeleteResponse;
import com.ace.truecaller.Dtos.Response.RegisterResponse;
import com.ace.truecaller.Dtos.Response.UpdateResponse;
import com.ace.truecaller.Models.User;
import com.ace.truecaller.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // used for servicesContactRegisterResponse
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired // used to create an instance of a class
    private UserRepository userRepository;

    @Override
    public BothRegisterAndUser createUser(UserRequest userRequest) {
        log.info("registering user {}", userRequest);
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setLastName(userRequest.getLastName());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setFirstName(userRequest.getFirstName());
        user.setPassword(userRequest.getPassword());
        user = userRepository.save(user);

        log.info("finished registration {}", user);

        return new BothRegisterAndUser(user, new RegisterResponse("User registered Successfully!"));
    }

    @Override
    public User getUser(String userName) {
        var user = userRepository.findUserByUserName(userName);
        return user;
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public UpdateResponse updateUser(UpdateRequest updateRequest) {
        var user = getUserById(updateRequest.getUserId());
        if (notNullOrEmpty(updateRequest.getFirstName())) {
            user.setFirstName(updateRequest.getFirstName());
        }
        if (notNullOrEmpty(updateRequest.getLastName())) {
            user.setLastName(updateRequest.getLastName());
        }
        if (notNullOrEmpty(updateRequest.getPhoneNumber())) {
            user.setPhoneNumber(updateRequest.getPhoneNumber());
        }

        if (notNullOrEmpty(updateRequest.getPassword())) {
            user.setPassword(updateRequest.getPassword());
        }
        userRepository.save(user);

        return new UpdateResponse("User details successfully updated!");

    }

    private boolean notNullOrEmpty(String data) {
        if(data != null && !data.equals("")){
            return  true;
        }
        return false;
    }

    @Override
    public DeleteResponse deleteUser(String userName) {
        var user = userRepository.findUserByUserName(userName);
        userRepository.delete(user);
        return new DeleteResponse("User successfully deleted!");
    }

    @Override
    public Long getNumberOfUser() {
        return userRepository.count();
    }

    @Override
    public void clearDatabase() {
        userRepository.deleteAll();
    }

    @Override
    public List<User> getListOfUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
       var usersWithFirstNameProvided =  userRepository.findAll()
                .stream()
                .filter(user -> user.getFirstName().equalsIgnoreCase(firstName))
                .toList();


        return usersWithFirstNameProvided;
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        var listOfUserWithSameLastName = userRepository.findAll()
                .stream()
                .filter(user -> user.getLastName().equalsIgnoreCase(lastName))
                .toList();


        return listOfUserWithSameLastName;
    }
}
