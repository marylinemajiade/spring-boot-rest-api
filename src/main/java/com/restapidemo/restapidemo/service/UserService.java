package com.restapidemo.restapidemo.service;

import com.restapidemo.restapidemo.model.User;
import com.restapidemo.restapidemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Integer id) {
        Optional<User> existingUser = userRepository.findById(id);
        return existingUser.orElse(null);
    }

    public void saveUpdatedUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
