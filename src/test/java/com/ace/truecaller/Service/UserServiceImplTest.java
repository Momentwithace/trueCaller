package com.ace.truecaller.Service;

import com.ace.truecaller.Dtos.Request.UpdateRequest;
import com.ace.truecaller.Dtos.Request.UserRequest;
import com.ace.truecaller.Dtos.Response.RegisterResponse;
import com.ace.truecaller.Models.User;
import com.ace.truecaller.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")

public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @BeforeEach
    void setup() {
        userService.clearDatabase();
    }

    @Test
    public void testThatUserCanBeCreated() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("Ace");
        userRequest.setLastName("Boyo");
        userRequest.setUserName("Ace1");
        userRequest.setPhoneNumber("09035123");
        userRequest.setPassword("12345");

        userService.createUser(userRequest);
        assertEquals(1L, userService.getNumberOfUser());

    }

    @Test
    public void testThatWeCanGetUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("Tman");
        userRequest.setLastName("jesuth");
        userRequest.setPhoneNumber("0908767546");
        userRequest.setUserName("awero");
        userRequest.setPassword("1234");

        userService.createUser(userRequest);
        User user = userService.getUser("awero");

        assertEquals("Tman", user.getFirstName());
    }

    @Test
    public void testThatWeCanUpdateUserDetails() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("John");
        userRequest.setLastName("Paul");
        userRequest.setPhoneNumber("090786534");
        userRequest.setUserName("paulo");
        userRequest.setPassword("12345");

        User user = userService.createUser(userRequest).getUser();

        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setUserId(user.getId());
        updateRequest.setLastName("ace");
        updateRequest.setPhoneNumber("98967543");

        userService.updateUser(updateRequest);

        user = userService.getUser("paulo");

        assertEquals(1L, userService.getNumberOfUser());
        assertEquals("ace", user.getLastName());
    }

    @Test
    public void testThatWeCanDeleteUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("ace");
        userRequest.setLastName("boyo");
        userRequest.setUserName("moment");
        userRequest.setPhoneNumber("09087678");
        userRequest.setPassword("12345");

        userService.createUser(userRequest);
        userService.deleteUser("moment");

        assertEquals(0, userService.getNumberOfUser());
    }

    @Test
    public void testThatWeCanGetListOfUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("ace");
        userRequest.setLastName("boyo");
        userRequest.setUserName("moment");
        userRequest.setPhoneNumber("09087678");
        userRequest.setPassword("12345");

        userService.createUser(userRequest);

        UserRequest userRequest1 = new UserRequest();
        userRequest1.setFirstName("ace");
        userRequest1.setLastName("boyo");
        userRequest1.setUserName("moment");
        userRequest1.setPhoneNumber("09087678");
        userRequest1.setPassword("12345");

        userService.createUser(userRequest1);

        UserRequest userRequest2 = new UserRequest();
        userRequest2.setFirstName("ace");
        userRequest2.setLastName("boyo");
        userRequest2.setUserName("moment");
        userRequest2.setPhoneNumber("09087678");
        userRequest2.setPassword("12345");

        userService.createUser(userRequest2);


        assertEquals(3, userService.getListOfUser().size());
    }

    @Test
    public void testThatWeCanFindUserByFirstName() {
        UserRequest userRequest2 = new UserRequest();
        userRequest2.setFirstName("ace");
        userRequest2.setLastName("boyo");
        userRequest2.setUserName("moment");
        userRequest2.setPhoneNumber("09087678");
        userRequest2.setPassword("12345");

        userService.createUser(userRequest2);

        User user = userService.getUser("moment");


        assertEquals(1L, userService.getNumberOfUser());
        assertEquals("boyo", user.getLastName());
    }

    @Test
    public void testThatWeCanGetUserUsingUserFirstName(){
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("tee");
        userRequest.setLastName("bayo");
        userRequest.setUserName("ray");
        userRequest.setPhoneNumber("09087678");
        userRequest.setPassword("12345");

        userService.createUser(userRequest);

        UserRequest userRequest1 = new UserRequest();
        userRequest1.setFirstName("tee");
        userRequest1.setLastName("boyo");
        userRequest1.setUserName("coder");
        userRequest1.setPhoneNumber("09087678");
        userRequest1.setPassword("12345");

        userService.createUser(userRequest1);

        UserRequest userRequest2 = new UserRequest();
        userRequest2.setFirstName("tee");
        userRequest2.setLastName("paul");
        userRequest2.setUserName("momentwithace");
        userRequest2.setPhoneNumber("09087678");
        userRequest2.setPassword("12345");

        userService.createUser(userRequest2);

        UserRequest userRequest3 = new UserRequest();
        userRequest3.setFirstName("mike");
        userRequest3.setLastName("paul");
        userRequest3.setUserName("momentwithace");
        userRequest3.setPhoneNumber("09087678");
        userRequest3.setPassword("12345");

        userService.createUser(userRequest3);

        assertEquals(3, userService.getUserByFirstName("tee").size());
    }

    @Test
    public void testThatWeCanGetListOfUserWithTheSameLastName(){
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("tee");
        userRequest.setLastName("bayo");
        userRequest.setUserName("ray");
        userRequest.setPhoneNumber("09087678");
        userRequest.setPassword("12345");

        userService.createUser(userRequest);

        UserRequest userRequest1 = new UserRequest();
        userRequest1.setFirstName("tee");
        userRequest1.setLastName("boyo");
        userRequest1.setUserName("coder");
        userRequest1.setPhoneNumber("09087678");
        userRequest1.setPassword("12345");

        userService.createUser(userRequest1);

        UserRequest userRequest2 = new UserRequest();
        userRequest2.setFirstName("tee");
        userRequest2.setLastName("paul");
        userRequest2.setUserName("momentwithace");
        userRequest2.setPhoneNumber("09087678");
        userRequest2.setPassword("12345");

        userService.createUser(userRequest2);

        UserRequest userRequest3 = new UserRequest();
        userRequest3.setFirstName("mike");
        userRequest3.setLastName("paul");
        userRequest3.setUserName("momentwithace");
        userRequest3.setPhoneNumber("09087678");
        userRequest3.setPassword("12345");

        userService.createUser(userRequest3);

        assertEquals(2, userService.getUserByLastName("paul").size());
    }

    @Test
    public void testThatUserCanSaveContact(){
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("ace");
        userRequest.setLastName("boyo");
        userRequest.setUserName("unlikeace");
        userRequest.setPhoneNumber("09087856");

    }






}