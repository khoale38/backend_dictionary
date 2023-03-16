package com.example.backenddictionnary.backend_dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.models.User;
import com.example.backenddictionnary.backend_dictionary.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setEmail(user.getEmail().isEmpty() ? user.getEmail() : existingUser.getEmail());
            existingUser.setPassword(user.getPassword().isEmpty() ? user.getPassword() : existingUser.getPassword());
            existingUser.setUserName(user.getUserName().isEmpty() ? user.getUserName() : existingUser.getUserName());
            existingUser.setDateOfBirth(user.getDateOfBirth());
            existingUser.setFavoriteUnit(user.getFavoriteUnit());
            existingUser.setFavoriteVocabularies(user.getFavoriteVocabularies());
            existingUser.setTestHistory(user.getTestHistory());
            existingUser.setUserName(user.getUserName().isEmpty() ? user.getUserName() : existingUser.getUserName());

            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
