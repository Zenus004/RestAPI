package com.cls0110.restapi.ServiceLayer;

import com.cls0110.restapi.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

}
