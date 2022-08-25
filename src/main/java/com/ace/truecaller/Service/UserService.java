package com.ace.truecaller.Service;

import com.ace.truecaller.Dtos.Request.UpdateRequest;
import com.ace.truecaller.Dtos.Request.UserRequest;
import com.ace.truecaller.Dtos.Response.BothRegisterAndUser;
import com.ace.truecaller.Dtos.Response.DeleteResponse;
import com.ace.truecaller.Dtos.Response.RegisterResponse;
import com.ace.truecaller.Dtos.Response.UpdateResponse;
import com.ace.truecaller.Models.User;

import java.util.List;

public interface UserService {
    BothRegisterAndUser createUser(UserRequest userRequest);
    User getUser(String userName);

    User getUserById(String userId);
    UpdateResponse updateUser(UpdateRequest updateRequest);
    DeleteResponse deleteUser(String userName);

    Long getNumberOfUser();

    void clearDatabase();

    List<User> getListOfUser();


}
