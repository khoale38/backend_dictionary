package com.example.backenddictionnary.backend_dictionary.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.models.User;
import com.example.backenddictionnary.backend_dictionary.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User login(String email, String password) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        User result = mongoTemplate.findOne(query, User.class);

        try {
            String hexedInput = toHexString(getSHA(password));
            if (result == null)
                return null;

            if (result.getPassword().equals(hexedInput))
                return result;
            else
                return null;

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
            return null;

        }

    }

    public User addUser(User user) {
        try {
            user.setPassword(toHexString(getSHA(user.getPassword())));
            return userRepository.save(user);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
            return null;
        }
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

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

}
