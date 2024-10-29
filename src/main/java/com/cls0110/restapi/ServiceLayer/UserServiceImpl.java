package com.cls0110.restapi.ServiceLayer;

import com.cls0110.restapi.ResourceNotFoundException;
import com.cls0110.restapi.User;
import com.cls0110.restapi.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ResourceNotFoundException("User", "id", id);
        }
    }

    @Override
    public User updateUser(User user, Integer id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        //Modify the Data or Update
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setMobNo(user.getMobNo());

        return userRepository.save(existingUser);
    }


}
